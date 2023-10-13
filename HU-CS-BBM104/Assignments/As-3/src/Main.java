import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String gamegridpath = args[0];
        ArrayList<ArrayList<jewel>> gridlist = Readfile.gamegridread(gamegridpath); //take grid from txt to arraylist
        String commands = args[1];
        ArrayList<Player> players = Readfile.playerlistmake(); //by using leaderboard make playerlist
        ArrayList<String> output =Playgame.game(gridlist,players,commands); //run commands

        FileWriter writer = new FileWriter("monitoring.txt"); //write arraylist

        for (String s : output) {
            writer.write(s + System.lineSeparator());
        }
        writer.close();




    }


}
