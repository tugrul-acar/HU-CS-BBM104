public abstract class Property extends Square{   //this is also abstract class
    private final String name;
    private final int cost;
    private String tür1;
    private String owner = "bank";
    private int rent;
    public Property(int position,String name,int cost,String tür1){

        super(position,"property");
        this.tür1 = tür1;
        this.name = name;
        this.cost = cost;
        if(tür1.equals("land")){   //if property is a land ı calculated its rent
            if(cost <= 2000){
                rent = (int) (cost*0.4);
            }
            else if(cost <= 3000){
                rent = cost*30/100;
            }
            else if(cost <= 4000){
                rent = cost*35/100;
            }
        }
    }
    public abstract void sell(String playerno,Player player,Property property1); //this is also abstract method

    public abstract void payrent(Player player,Player playerdiger,String a);  //this is also abstract method

    public String getTür1() {
        return tür1;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRent() {
        return rent;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
