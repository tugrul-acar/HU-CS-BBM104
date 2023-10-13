public class Railroads extends Property{
    public Railroads(int id,String name,int cost){
        super(id,name,cost,"railroad");


    }
    public void sell(String playerno,Player player,Property property1){ //with this command player buy property from banker
        this.setOwner(playerno);
        player.setMoney(-this.getCost());
        Bank.money += this.getCost();
        player.setRailroadnumber(player.getRailroadnumber()+1);
        player.getProperties().add(property1);
    }
    public void payrent(Player player,Player playerdiger,String a) {
        playerdiger.setMoney(25*playerdiger.getRailroadnumber());

        player.setMoney(-25*playerdiger.getRailroadnumber());

    }


}
