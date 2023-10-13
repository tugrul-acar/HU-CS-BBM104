import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class readfile {
    public static String[] Readfromfile(String path){
        try{
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

    public static ArrayList<String> addpeopletoarray(String Path){
        File file = new File("people.txt");
        String[] lines = Readfromfile(Path);
        ArrayList<String> people = new ArrayList<String>();
        int x = lines.length;
        for(int i=0;i<x;i++){
            people.add(lines[i]);
        }
        return people;
    }

    public static ArrayList<Person> addperson(ArrayList<String> people, int length){
        ArrayList<Person> people1 = new ArrayList<Person>();
        for (String person : people) {
            String[] veri = person.split("\t");
            people1.add(new Person(Integer.parseInt(veri[0]),veri[1],veri[2],Integer.parseInt(veri[3]),Integer.parseInt(veri[4]),Integer.parseInt(veri[5])));
        }
        return people1;
    }

    public static ArrayList<String> addfoodtoarray(String path){
        File file = new File("food.txt");
        String[] lines = Readfromfile(path);
        ArrayList<String> food = new ArrayList<String>();
        int x = lines.length;
        for(int i=0;i<x;i++){
            food.add(lines[i]);
        }
        return food;
    }
    public static ArrayList<Food> addfood(ArrayList<String> foods, int length){
        ArrayList<Food> food1 = new ArrayList<Food>();
        for (String food : foods) {
            String[] veri1 = food.split("\t");
            food1.add(new Food(Integer.parseInt(veri1[0]),veri1[1],Integer.parseInt(veri1[2])));
        }
        return food1;
    }

    public static ArrayList<String> addsporttoarray(String Path){
        File file = new File("sport.txt");
        String[] lines = Readfromfile(Path);
        ArrayList<String> sports = new ArrayList<String>();
        for(int i=0;i<lines.length;i++){
            sports.add(lines[i]);
        }
        return sports;
    }
    public static ArrayList<Sport> addsport(ArrayList<String> sports, int length){
        ArrayList<Sport> sport1 = new ArrayList<Sport>();
        for (String spor : sports) {
            String[] veri = spor.split("\t");
            sport1.add(new Sport(Integer.parseInt(veri[0]),veri[1],Integer.parseInt(veri[2])));
        }
        return sport1;
    }




}
