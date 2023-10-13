import java.util.ArrayList;

public class communityChestsquare extends Square{
    public static int sira = 0;
    public static ArrayList<String> commands;
    public communityChestsquare(int positon,ArrayList<String> commands1) {
        super(positon, "communityChest");
        commands = commands1;
    }
    public static String getcommand(){
        return commands.get(sira++);
    }
    public static String happencommunitychest(Player player,Player playerdiger,Player player1,Player player2,int i,String a){
        String command = communityChestsquare.getcommand();
        String out = "";
        String firstcommand = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " ";
        if (command.equals("Advance to Go (Collect $200)")) {
            player.setLocation(1);
            player.setMoney(200);
            Bank.money -= 200;
            out = ("Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " +"draw Community Chest"+ "-advance to go (collect 200)");
        }
        if(command.equals("Bank error in your favor - collect $75")){
            player.setMoney(75);

            Bank.money -= 75;
            out =(firstcommand +"draw Community Chest"+ "-Bank error in your favor - collect $75");
        }
        if(command.equals("Doctor's fees - Pay $50")){
            if(player.getMoney() < 50){
                out= "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else{
                player.setMoney(-50);

                Bank.money += 50;
                out =(firstcommand +"draw Community Chest"+ "-Doctor's fees - Pay $50");
            }


        }
        if(command.equals("It is your birthday Collect $10 from each player")){

            if(playerdiger.getMoney() < 10){
                out = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else{
                player.setMoney(10);
                playerdiger.setMoney(-10);

                out =(firstcommand +"draw Community Chest"+ "-It is your birthday Collect $10 from each player");
            }

        }
        if(command.equals("Grand Opera Night - collect $50 from every player for opening night seats")){
            if(playerdiger.getMoney() < 50){
                out = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else{
                player.setMoney(50);
                playerdiger.setMoney(-50);

                out =(firstcommand +"draw Community Chest"+ "-Grand Opera Night - collect $50 from every player for opening night seats");
            }

        }
        if(command.equals("Income Tax refund - collect $20")){
            player.setMoney(20);

            Bank.money -= 20;
            out =(firstcommand +"draw Community Chest"+ "-Income Tax refund - collect $20");

        }
        if(command.equals("Life Insurance Matures - collect $100")){
            player.setMoney(100);

            Bank.money -= 100;
            out =(firstcommand +"draw Community Chest"+ "-Life Insurance Matures - collect $100");

        }
        if(command.equals("Pay Hospital Fees of $100")){
            if(player.getMoney() < 100){
                out = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else{
                player.setMoney(-100);
                Bank.money += 100;
                out =(firstcommand +"draw Community Chest"+ "-Pay Hospital Fees of $100");
            }


        }
        if(command.equals("Pay School Fees of $50")){
            if(player.getMoney() < 50){
                out = "Player "+i+ "\t" + a + "\t" + player.getLocation() + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t" + "Player "+i+ " " + "goes bankrupt";
                Makegame.finish = 1;
            }
            else{
                player.setMoney(-50);

                Bank.money += 50;
                out =(firstcommand +"draw Community Chest"+"-Pay School Fees of $50");
            }


        }
        if(command.equals("You inherit $100")){
            player.setMoney(100);

            Bank.money -= 100;
            out =(firstcommand +"draw Community Chest"+ "-You inherit $100");

        }
        if(command.equals("From sale of stock you get $50")){
            player.setMoney(50);

            Bank.money -= 50;
            out =(firstcommand +"draw Community Chest"+ "-From sale of stock you get $50");

        }
        return out;
    }
}
