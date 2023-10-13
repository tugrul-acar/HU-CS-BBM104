import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        ListJsonReader chancereader = new ListJsonReader();  //read chacne and comminity chance commands from json file

        ArrayList<String> chanceListarray = chancereader.getChanceListarray(); //chance commands in arraylist

        ArrayList<String> communityChestListarray = chancereader.getCommunityChestListarray(); //community chance commands in arraylist

        PropertyJsonReader propertyreader = new PropertyJsonReader(); //read property and their values

        ArrayList<Land> lands = propertyreader.getLand1(); //land arraylsit

        ArrayList<Company> companies = propertyreader.getCompanie1(); // company arraylist

        ArrayList<Railroads> railroads = propertyreader.getRailroads1(); //railroads arraylist

        Player player1 = new Player(1); //there are two player
        Player player2 = new Player(2); //player 1 and player2
        String path = args[0];
        ArrayList<String> commands = readfile.addcommandtoarray(path); //read command txt

        if(!commands.get(commands.size()-1).equals("show()")){  //if command not end with show() I also add
            commands.add("show()");
        }
        Square[] kareler1 = readfile.addsquares(companies,lands,railroads,chanceListarray,communityChestListarray); //with this fucntion I make monoply board
        ArrayList<String> outputtxt = Makegame.playgame(commands,player1,player2,kareler1); //for output I add them all in arraylist

        FileWriter writer = new FileWriter("output.txt"); //write arraylist
        for (int i = 0; i < outputtxt.size(); i++) {
            writer.write(outputtxt.get(i)+System.lineSeparator());
        }
        writer.close();


    }

}
