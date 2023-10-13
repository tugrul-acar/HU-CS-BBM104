public class Player implements Comparable<Player>{
    private String name;
    private int point;
    Player(String name, int point){
        this.name = name;
        this.point = point;
    }


    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public void setPoint(int point) {
        this.point = point;
    }




    @Override
    public int compareTo(Player o) {
        return o.point - this.point;
    }
}
