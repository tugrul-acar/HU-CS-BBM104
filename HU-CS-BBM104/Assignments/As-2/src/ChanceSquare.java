import java.util.ArrayList;

public class ChanceSquare extends Square {
    public static int sira = 0;
    public static ArrayList<String> commands;
    public ChanceSquare(int positon,ArrayList<String> commands1) {
        super(positon, "chance");
        commands = commands1;
    }
    public static String getcommand(){
        return commands.get(sira++);
    }
    public static String happenchance(Player player,Player playerdiger,Player player1,Player player2,int i,String a,Square[] kareler){

        String command = ChanceSquare.getcommand();
        String out = "";
        String firstcommand = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " ";
        if (command.equals("Advance to Go (Collect $200)")) {
            player.setLocation(1);
            player.setMoney(200);
            Bank.money -= 200;
            out = ("Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "draw Advance to Go (Collect $200)");
        }
        if(command.equals("Advance to Leicester Square")){
            if(player.getLocation() > 27){
                player.setMoney(200);
                Bank.money -= 200;
            }
            player.setLocation(27);
            Property property = (Property) kareler[player.getLocation()];
            if(property.getOwner().equals("bank")){
                firstcommand = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " ";
                property.sell(String.valueOf(i),player,property);
                out = (firstcommand + "draw Advance to Leicester Square"+ "Player"+i+ " " +"bought Leicester Square");
            }
            else if(!property.getOwner().equals(String.valueOf(i))){

                playerdiger.setMoney(property.getRent());
                player.setMoney(-property.getRent());
                firstcommand ="Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " ";
                out = (firstcommand + "draw Advance to Leicester Square"+ "Player"+i+ " " +"paid rent for Leicester Square");
            }

        }
        if(command.equals("Go back 3 spaces")){
            player.setLocation(player.getLocation()-3);

            out = ("Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney()+ "\t" + "Player "+i+ " " + "draw Go back 3 spaces");
            String tür = kareler[player.getLocation()].getTür();
            if (tür.equals("property")) {
                Property property1 = (Property) kareler[player.getLocation()];
                if (property1.getOwner().equals("bank") && player.getMoney() >= property1.getCost()) {
                    property1.sell(String.valueOf(i), player,property1);
                    player.getProperties().add(property1);
                    if (property1.getTür1().equals("railroad")) {
                        player.setRailroadnumber(player.getRailroadnumber()+1);
                    }
                    out = out + " Player " + i + " " + "bought" + " " + property1.getName();
                } else if (property1.getOwner().equals("bank") && player.getMoney() < property1.getCost()) {

                    Makegame.finish = 1;
                    out = out + " Player " + i + " " + "goes bankrupt";
                } else if (!property1.getOwner().equals(String.valueOf(i))) {
                    if (property1.getTür1().equals("land")) {
                        playerdiger.setMoney(property1.getRent());
                        player.setMoney(-property1.getRent());

                        out = out + "Player " + i + " " + "paid rent for " + property1.getName();

                    }
                    if (property1.getTür1().equals("company")) {
                        playerdiger.setMoney(4 * Integer.parseInt(a));
                        player.setMoney(-4 * Integer.parseInt(a));

                        out = out + "Player " + i + " " + "paid rent for " + property1.getName();

                    }
                    if (property1.getTür1().equals("railroad")) {
                        playerdiger.setMoney(25 * playerdiger.getRailroadnumber());
                        player.setMoney(-25 * playerdiger.getRailroadnumber());



                        out = out + "Player " + i + " " + "paid rent for " + property1.getName();
                    }
                } else if (property1.getOwner().equals(String.valueOf(i))) {
                    out = out + "Player " + i + " " + "has " + property1.getName();
                }
            }

        }
        if(command.equals("Pay poor tax of $15")){
            if(player.getMoney() < 15){
                out = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else {
                player.setMoney(-15);

                Bank.money += 15;
                out = (firstcommand + "draw Pay poor tax of $15");
            }


        }
        if(command.equals("Your building loan matures - collect $150")){
            player.setMoney(150);

            Bank.money -= 150;
            out = (firstcommand + "draw Your building loan matures - collect $150");
        }
        if(command.equals("You have won a crossword competition - collect $100 ")){
            player.setMoney(100);

            Bank.money -= 100;
            out = (firstcommand + "draw You have won a crossword competition - collect $100 ");

        }
        return out;
    }
}
