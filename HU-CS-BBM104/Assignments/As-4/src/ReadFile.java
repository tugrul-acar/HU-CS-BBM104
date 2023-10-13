import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;

public class ReadFile {



    public static String[] Readfromfile(String path){
        try{
            Path path1 = Paths.get(path);
            if(!Files.exists(path1)){
                FileWriter writer = new FileWriter("assets\\data\\backup.dat");
                writer.write("user\tadmin\tX03MO1qnZdYdgyfeuILPmQ==\ttrue\ttrue"+System.lineSeparator());
                writer.close();
            }
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] lines = new String[length];
            for(String line : Files.readAllLines(Paths.get(path))){
                lines[i++] = line;
            }
            return lines;

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> addcommandtoarray(String Path){ //this function read commands.txt and make arraylist
        String[] lines = Readfromfile(Path);

        ArrayList<String> commands = new ArrayList<String>();
        int x = lines.length;
        for(int i=0;i<x;i++){
            commands.add(lines[i]);
        }
        return commands;
    }



    public static ArrayList<String> makecommands(ArrayList<String> commands) { //this function read backup dat make users,movies,halls,seats
        for (String command : commands) {
            String[] command1 = command.split("\t");
            if(command1[0].equals("user")){
                byte[] decodedBytes = Base64.getDecoder().decode(command1[2]);
                boolean admin = Boolean.parseBoolean(command1[4]);
                boolean clupmember = Boolean.parseBoolean(command1[3]);
                User user = new User(command1[1],admin,clupmember,command1[2]);

            }
            else if(command1[0].equals("film")){
                Movie movie = new Movie(command1[1],command1[2],Integer.parseInt(command1[3]));
            }
            else if(command1[0].equals("hall")){
                Hall hall = new Hall(command1[1],command1[2],Integer.parseInt(command1[3]),Integer.parseInt(command1[4]),Integer.parseInt(command1[5]));
            }
            else if(command1[0].equals("seat")){
                if(command1[5].equals("null")){
                    Seat seat = new Seat(command1[1],command1[2],Integer.parseInt(command1[3]),Integer.parseInt(command1[4]),command1[5],0);
                }
                else {
                    Seat seat = new Seat(command1[1],command1[2],Integer.parseInt(command1[3]),Integer.parseInt(command1[4]),command1[5],Integer.parseInt(command1[6]));
                }

            }



        }
        for (Movie movie : Movie.movies) {
            for (Hall hall : Hall.hallArrayList) {
                if(hall.filmname.equals(movie.name)){
                    movie.hallArrayList.add(hall.hallname);
                }
            }
        }
        return commands;
    }




    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
            if(d < 0){
                return false;
            }
            else {
                return true;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }






    public static void savebackup() throws IOException {
        FileWriter writer = new FileWriter("assets\\data\\backup.dat");
        for (User user : User.users) {
            writer.write("user\t"+user.getName()+"\t"+user.getPassword()+"\t"+user.isClubmember()+"\t"+user.isAdmin()+System.lineSeparator());
        }
        for (Movie movie : Movie.movies) {
            writer.write("film\t"+movie.name+"\t"+movie.path+"\t"+movie.duration+System.lineSeparator());
        }
        for (Hall hall : Hall.hallArrayList) {
            writer.write("hall\t"+hall.filmname+"\t"+hall.hallname+"\t"+hall.price+"\t"+hall.row+"\t"+hall.column+"\t"+System.lineSeparator());
        }
        for (Seat seat : Seat.seatArrayList) {
            if(seat.user == null){
                writer.write("seat\t"+seat.movie+"\t"+seat.hall.hallname+"\t"+seat.row+"\t"+seat.column+"\t"+"null"+"\t"+"0"+System.lineSeparator());
            }
            else {
                writer.write("seat\t"+seat.movie+"\t"+seat.hall.hallname+"\t"+seat.row+"\t"+seat.column+"\t"+seat.user.getName()+"\t"+seat.price+System.lineSeparator());
            }

        }
        writer.close();
    }






}
