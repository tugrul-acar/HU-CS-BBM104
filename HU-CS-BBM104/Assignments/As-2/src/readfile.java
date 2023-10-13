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

    public static ArrayList<String> addcommandtoarray(String Path){ //this function read commands.txt and make arraylist
        String[] lines = Readfromfile(Path);
        ArrayList<String> commands = new ArrayList<String>();
        int x = lines.length;
        for(int i=0;i<x;i++){
            commands.add(lines[i]);
        }
        return commands;
    }

    public static Square[] addsquares(ArrayList<Company> companies, ArrayList<Land> lands, ArrayList<Railroads> railroads, ArrayList<String> chanceListarray, ArrayList<String> communityChestListarray) {
        Square[] kareler = new Square[41];              //I make 41 array because for index 1 ı set first square
                                                        //if I set 0 for first square that would be confusing for some parts
        for (Company company : companies) {
            int a = company.positon;
            kareler[a] = company;
        }                                               //these commands make monpoly board for every square
        for (Land land : lands) {
            int a = land.positon;
            kareler[a] = land;
        }
        for (Railroads railroad : railroads) {
            int a = railroad.positon;
            kareler[a] = railroad;

        }
        kareler[8] = new ChanceSquare(8, chanceListarray);
        kareler[23] = new ChanceSquare(23, chanceListarray);
        kareler[37] = new ChanceSquare(37, chanceListarray);
        kareler[3] = new communityChestsquare(3, communityChestListarray);
        kareler[18] = new communityChestsquare(18, communityChestListarray);
        kareler[34] = new communityChestsquare(34, communityChestListarray);
        kareler[1] = new Othersquares(1, "GO");
        kareler[5] = new Othersquares(5, "tax");
        kareler[11] = new Othersquares(11, "jail");
        kareler[21] = new Othersquares(21, "parking");
        kareler[31] = new Othersquares(31, "gojail");
        kareler[39] = new Othersquares(39, "tax");

        return kareler;
    }
}