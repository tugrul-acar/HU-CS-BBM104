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

    public static ArrayList<ArrayList<jewel>> gamegridread(String path){
        String[] a = Readfile.Readfromfile(path);
        ArrayList<ArrayList<jewel>> gridlist= new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            gridlist.add(new ArrayList<>());
        }
        for (String s : a) {
            String[] harfler = s.split(" ");
            for (int i = 0; i < harfler.length; i++) {
                switch (harfler[i]) {
                    case "T" :
                        gridlist.get(i).add(new T());
                        break;
                    case "W" :
                        gridlist.get(i).add(new W());
                        break;
                    case "D" :
                        gridlist.get(i).add(new D());
                        break;
                    case "S" :
                        gridlist.get(i).add(new S());
                        break;
                    case "/" :
                        gridlist.get(i).add(new Slash());
                        break;
                    case "-" :
                        gridlist.get(i).add(new Minus());
                        break;
                    case "+" :
                        gridlist.get(i).add(new Plus());
                        break;
                    case "\\" :
                        gridlist.get(i).add(new backslash());
                        break;
                    case "|" :
                        gridlist.get(i).add(new verticalbar());
                        break;
                }
            }
        }
        return gridlist;
    }
    public static ArrayList<Player> playerlistmake(){
        String[] a2 = Readfile.Readfromfile("leaderboard.txt");
        ArrayList<Player> playerlist= new ArrayList<>();
        for (String s : a2) {
            String[] nameandpoint = s.split(" ");
            if(nameandpoint.length == 2){
                playerlist.add(new Player(nameandpoint[0],Integer.parseInt(nameandpoint[1])));
            }

        }
        return playerlist;
    }


}
