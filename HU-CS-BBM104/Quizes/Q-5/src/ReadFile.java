import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFile {
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

    public static ArrayList<String> addcommandtoarray(String Path){ //this function read commands.txt and make arraylist
        String[] lines = Readfromfile(Path);
        ArrayList<String> commands = new ArrayList<String>();
        int x = lines.length;
        for(int i=0;i<x;i++){
            commands.add(lines[i]);
        }
        return commands;
    }
    public static ArrayList<String> addstackcommands(ArrayList<String> command){
        ArrayList<String> stackcommand = new ArrayList<>();
        for (String s : command) {
            String[] a = s.split(" ");
            if(a.length == 2)
                break;
            else
                stackcommand.add(s);
        }
        return stackcommand;

    }
    public static ArrayList<String> addqueuecommands(ArrayList<String> command){
        ArrayList<String> queuecommand = new ArrayList<>();
        int j = 1;
        for (String s : command) {
            String[] a = s.split(" ");
            if(a.length == 2)
                j = 0;
            if(j == 0){
                queuecommand.add(s);
            }
        }
        return queuecommand;

    }


}
