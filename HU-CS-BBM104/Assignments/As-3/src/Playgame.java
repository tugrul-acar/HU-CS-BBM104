import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Playgame {
    public static ArrayList<String> game(ArrayList<ArrayList<jewel>> gridlist,ArrayList<Player> players,String path) throws IOException {
        String[] a = Readfile.Readfromfile(path);
        int sum = 0;
        int point = 0;
        ArrayList<String> output = new ArrayList<>();
        output.add("Game grid:\n");
        for (int i = 0; i < gridlist.size(); i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < gridlist.get(0).size(); j++) {
                if(j==0){
                    line.append(gridlist.get(j).get(i));
                }
                else{
                    line.append(" ").append(gridlist.get(j).get(i));
                }
            }
            output.add(line.toString());
        }
        for (String s : a) {
            String[] command = s.split(" ");
            if(command.length == 2){ // if command size equals to the 2 I split and make x and y coordinate
                jewel space = new space();
                int ycordinate = Integer.parseInt(command[0]);
                int xcordinate = Integer.parseInt(command[1]);
                jewel jewel1 = null;
                if(xcordinate < gridlist.size() && ycordinate < gridlist.size()){
                    jewel1 = gridlist.get(xcordinate).get(ycordinate);
                }
                else {//if coordinates out of grid size I consider as space
                    jewel1 = space;
                }

                point = jewel1.jewelmake(xcordinate,ycordinate,gridlist);
                sum += point;
                output.add(" ");
                output.add("Select coordinate or enter E to end the game: "+ ycordinate + " " + xcordinate+"\n");

                if(jewel1.toString().equals(" ")){ //if jewel is space then ask to valid coordinate
                    output.add("Please enter a valid coordinate\n");
                }
                else{ //if this is valid then print the gridfter execution jewel
                    for (int i = 0; i < gridlist.size(); i++) {
                        StringBuilder line = new StringBuilder();
                        for (int j = 0; j < gridlist.get(0).size(); j++) {
                            if(j==0){
                                line.append(gridlist.get(j).get(i));
                            }
                            else{
                                line.append(" ").append(gridlist.get(j).get(i));
                            }

                        }
                        output.add(line.toString());
                    }
                    output.add("");
                    output.add("Score: "+point+" points");
                }

            }
            else if(command.length == 1 && command[0].equals("E")){ //if command equals to E print the total point
                output.add("");
                output.add("Select coordinate or enter E to end the game: "+"E\n");
                output.add("Total score: "+sum+" points");
            }
            else {
                output.add(" ");
                Player player = new Player(command[0],sum); //make new player and append to txt

                players.add(player);
                FileWriter writer = new FileWriter("leaderboard.txt"); //write arraylist

                for (Player player1 : players) {
                    writer.write(player1.getName()+" "+player1.getPoint()+System.lineSeparator());
                }

                writer.close();
                Collections.sort(players);
                int index = Collections.binarySearch(players,player);
                index = index+1;
                output.add("Enter name: "+command[0]+"\n");
                if(index ==1){  //if rank is 1.this happens
                    String upper = String.valueOf(sum-players.get(index).getPoint());
                    String uppername = players.get(index).getName();
                    output.add("Your rank is " +index + "/"+ players.size()+", your score is "+upper+ " points higher than " +uppername+"\n");
                }
                else if(index == players.size()){//if rank is last this happens
                    String lower = String.valueOf(players.get(index-2).getPoint()-sum);
                    String lowername = players.get(index-2).getName();
                    output.add("Your rank is " +index + "/"+ players.size()+", your score is "+ lower +" points lower than "+lowername+"\n");
                }
                else{//if rank is not  last or first this happens
                    String lower = String.valueOf(players.get(index-2).getPoint()-sum);
                    String lowername = players.get(index-2).getName();
                    String upper = String.valueOf(sum-players.get(index).getPoint());
                    String uppername = players.get(index).getName();
                    output.add("Your rank is " +index + "/"+ players.size()+", your score is "+ lower +" points lower than "+lowername+" and "+upper+ " points higher than " +uppername+"\n");
                }
                output.add("Good bye!");
            }
        }
        return output;
    }


}
