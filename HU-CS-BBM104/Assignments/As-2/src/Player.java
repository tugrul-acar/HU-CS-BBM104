import java.util.ArrayList;

public class Player {
    private int jail = 0;
    private int money = 15000;
    public int playernumber;
    private int location = 1;
    private int railroadnumber = 0;
    private ArrayList<Property> properties = new ArrayList<>();
    public Player(int number){playernumber = number;
    }

    public int getMoney() {
        return money;
    }

    public int getJail() {
        return jail;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public int getLocation() {
        return location;
    }

    public int getRailroadnumber() {
        return railroadnumber;
    }

    public void setLocation(int location) {
        this.location = location;
    }
    public int makelocation(){
        this.location = this.location%40;
        return this.location;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public void setJail(int jail) {
        this.jail = jail;
    }


    public void setRailroadnumber(int railroadnumber) {
        this.railroadnumber = railroadnumber;
    }
}
