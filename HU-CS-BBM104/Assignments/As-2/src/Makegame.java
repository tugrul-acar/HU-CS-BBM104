import java.util.ArrayList;


public class Makegame {
    public static int finish = 0;
    //playgame function calls this method
    public static ArrayList<String> runcommand(Player player, Square[] kareler, String[] a,int i,Player playerdiger,Player player1,Player player2) {
        ArrayList<String> out = new ArrayList<>();
        if (player.getJail() > 0) {
            player.setJail(player.getJail()-1);
            int jailnumber = 3-player.getJail();
            if(i == 1){
                out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+" in jail (count="+jailnumber+")");
            }
            else{
                out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+" in jail (count="+jailnumber+")");
            }

        } else {
            player.setLocation(player.getLocation()+Integer.parseInt(a[1]));
            if(player.getLocation() > 40){
                player.setMoney(200);
                Bank.money -= 200;
            }
            player.makelocation();
            if(player.getLocation() == 0){
                player.setLocation(40);
            }
            if(player.getLocation() == 1){
                player.setMoney(-200);
                Bank.money += 200;
            }
            String tür = kareler[player.getLocation()].getTür(); //takes square type

            if (tür.equals("property")) {

                Property property1 = (Property) kareler[player.getLocation()];
                if (property1.getOwner().equals("bank") && player.getMoney() >= property1.getCost()) { //check the owner is banker and player money
                    property1.sell(String.valueOf(i), player,property1); //call sell method
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "bought" + " " + property1.getName());
                    }
                else if(property1.getOwner().equals("bank") && player.getMoney() < property1.getCost()){
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt");
                    Makegame.finish = 1;
                }
                else if(!property1.getOwner().equals(String.valueOf(i)) && player.getMoney() > property1.getCost()){//check the owner is banker and player money
                    property1.payrent(player,playerdiger,a[1]);

                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " +"paid rent for "+property1.getName());


                }
                else if(!property1.getOwner().equals(String.valueOf(i)) && player.getMoney() < property1.getCost()){
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt");
                    Makegame.finish = 1;
                }
                else if(property1.getOwner().equals(String.valueOf(i))){
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " +"has "+property1.getName());
                }

            }
            //if square type is other ı use this part
            if (tür.equals("other")) {
                Othersquares othersquare = (Othersquares) kareler[player.getLocation()];
                if (othersquare.getName().equals("GO")) {
                    player.setMoney(200);
                    Bank.money -= 200;
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ "\t" +"is in GO square");
                }
                if (othersquare.getName().equals("tax")) {
                    player.setMoney(-100);
                    Bank.money += 100;
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " +"paid Tax");
                }
                if (othersquare.getName().equals("parking")) {
                    player.setJail(1);
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+" is in Free Parking");
                }
                if (othersquare.getName().equals("jail")) {
                    player.setJail(3);
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+" went to jail");
                }

                if (othersquare.getName().equals("gojail")) {
                    player.setJail(3);
                    player.setLocation(11);
                    out.add("Player "+i+ "\t" + a[1] + "\t" + player.getLocation() + "\t" + player1.getMoney()+ "\t" + player2.getMoney() + "\t" + "Player "+i+ " " +"went to jail");
                }


                //if square type is communityChest I use this part
            } else if (tür.equals("communityChest")) {
                String output = communityChestsquare.happencommunitychest(player,playerdiger,player1,player2,i,a[1]);//calls happencommunitychest method
                out.add(output);

            }
            //if square type is chance I use this part
            else if (tür.equals("chance")) {
                String output = ChanceSquare.happenchance(player,playerdiger,player1,player2,i,a[1],kareler); //calls happenchance method
                out.add(output);
            }


        }
        return out;
    }




    public static ArrayList<String> playgame(ArrayList<String> commands, Player player1, Player player2, Square[] kareler) {
        ArrayList<String> out = new ArrayList<>();
        for (String command : commands) {
            if(Makegame.finish ==1){
                String player1have = "";
                String player2have = "";
                for (Property property : player1.getProperties()) {
                    player1have = player1have + "," + property.getName();
                }
                for (Property property : player2.getProperties()) {
                    player2have = player2have + "," + property.getName();
                }
                if(player1have.length() != 0){
                    player1have = player1have.substring(1);

                }
                if(player2have.length() != 0){
                    player2have = player2have.substring(1);

                }
                out.add("-----------------------------------------------------------------------------------------------------------");
                out.add("Player 1"+ "\t" +player1.getMoney() + "\t" +"have: "+player1have);
                out.add("Player 2"+ "\t" +player2.getMoney() + "\t" +"have: "+player2have);
                out.add("Banker"+"\t"+Bank.money);
                if(player1.getMoney() > player2.getMoney()){
                    out.add("Winner Player 1");
                }
                else {
                    out.add("Winner Player 2");
                }
                out.add("-----------------------------------------------------------------------------------------------------------");

                break;
            }
            String[] a = command.split(";");
            if (a[0].equals("Player 1")) {
                ArrayList<String> out1 =runcommand(player1, kareler, a,1,player2,player1,player2);
                out.addAll(out1);
            }
            else if (a[0].equals("Player 2")) {
                ArrayList<String> out1 =runcommand(player2, kareler, a,2,player1,player1,player2);
                out.addAll(out1);
            }
            else if(a[0].equals("show()")){
                String player1have = "";
                String player2have = "";

                for (Property property : player1.getProperties()) {
                    player1have = player1have + "," + property.getName();

                }
                for (Property property : player2.getProperties()) {
                    player2have = player2have + "," + property.getName();
                }
                if(player1have.length() != 0){
                    player1have = player1have.substring(1);

                }
                if(player2have.length() != 0){
                    player2have = player2have.substring(1);

                }
                out.add("-----------------------------------------------------------------------------------------------------------");
                out.add("Player 1"+ "\t" +player1.getMoney() + "\t" +"have: "+player1have);
                out.add("Player 2"+ "\t" +player2.getMoney() + "\t" +"have: "+player2have);
                out.add("Banker"+"\t"+Bank.money);
                if(player1.getMoney() > player2.getMoney()){
                    out.add("Winner Player 1");
                }
                else {
                    out.add("Winner Player 2");
                }
                out.add("-----------------------------------------------------------------------------------------------------------");
            }


        }

        return out;

    }

}
