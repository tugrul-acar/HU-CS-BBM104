import java.util.ArrayList;

public class Hall {
    public String hallname;
    public String filmname;
    public int price;
    public int row;
    public int column;
    public Seat[][] seats;
    public static ArrayList<Hall> hallArrayList = new ArrayList<>();
    public static ArrayList<String> hallnames = new ArrayList<>();
    public Hall(String filmname,String hallname,int price,int row,int column){
        this.filmname = filmname;
        this.hallname = hallname;
        this.price = price;
        this.column = column;
        this.row = row;

        hallArrayList.add(this);
        hallnames.add(this.hallname);
        seats = new Seat[row][column];
    }


}
