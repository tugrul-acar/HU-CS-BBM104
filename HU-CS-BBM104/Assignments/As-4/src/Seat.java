import java.util.ArrayList;

public class Seat {
    public int row;
    public int column;
    public String movie;
    public Hall hall;
    public User user;
    public int price;
    public static ArrayList<Seat> seatArrayList = new ArrayList<>();
    public Seat(String movie,String hall,int row,int column,String user,int price){

        int a = Hall.hallnames.indexOf(hall);
        this.hall = Hall.hallArrayList.get(a);
        Hall.hallArrayList.get(a).seats[row][column] = this;
        if(!user.equals("null")){
            int b = User.usersname.indexOf(user);
            this.user = User.users.get(b);
        }
        else {
            this.user = null;
        }

        this.row = row;
        this.column = column;
        this.movie = movie;
        this.price = price;
        seatArrayList.add(this);

    }

}
