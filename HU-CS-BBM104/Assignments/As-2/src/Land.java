public class Land extends Property{
    public Land(int id,String name,int cost){
        super(id,name,cost,"land");
    }
    public void sell(String playerno,Player player,Property property1){ //with this command player buy property from banker
        this.setOwner(playerno);
        player.setMoney(-this.getCost());
        Bank.money += this.getCost();
        player.getProperties().add(property1);
    }
    public void payrent(Player player,Player playerdiger,String a) {
        player.setMoney(-this.getRent());
        playerdiger.setMoney(this.getRent());

    }
}
