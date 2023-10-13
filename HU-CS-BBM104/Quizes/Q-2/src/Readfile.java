import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Readfile {

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
    public static ArrayList<String> addfmatches(String[] lines, int length){
        ArrayList<String> fmatches = new ArrayList<String>();
        for(int i=0;i<length;i++){
            String[] partofline =lines[i].split("\t");
            if(partofline[0].equals("F")){
                fmatches.add(lines[i]);
            }
        }
    return fmatches;

    }
    public static ArrayList<String> addvmatches(String[] lines, int length){
        ArrayList<String> vmatches = new ArrayList<String>();
        for(int i=0;i<length;i++){
            String[] partofline =lines[i].split("\t");
            if(partofline[0].equals("V")){
                vmatches.add(lines[i]);
            }
        }
        return vmatches;

    }
    public static ArrayList<String> addbmatches(String[] lines, int length){
        ArrayList<String> bmatches = new ArrayList<String>();
        for(int i=0;i<length;i++){
            String[] partofline =lines[i].split("\t");
            if(partofline[0].equals("B")){
                bmatches.add(lines[i]);
            }
        }
        return bmatches;
    }
    public static ArrayList<String> addhmatches(String[] lines, int length){
        ArrayList<String> hmatches = new ArrayList<String>();
        for(int i=0;i<length;i++){
            String[] partofline =lines[i].split("\t");
            if(partofline[0].equals("H")){
                hmatches.add(lines[i]);
            }
        }
        return hmatches;
    }

}
