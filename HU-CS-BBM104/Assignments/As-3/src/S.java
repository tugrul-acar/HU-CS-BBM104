import java.util.ArrayList;

public class S extends Letter{
    public int point =15;
    @Override
    public int getpoint() {
        return point;
    }
    @Override
    public String toString() {
        return "S";
    }
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){

        String a1 = " ";
        String a2 = " ";
        String a3 = " ";
        String a4 = " ";
        if (xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a1 = String.valueOf(gridlist.get(xcordinate-1).get(ycordinate));
            a2 = String.valueOf(gridlist.get(xcordinate-2).get(ycordinate));
        }

        if (xcordinate + 1 <= gridlist.size() && xcordinate + 2 <= gridlist.size()) {
            a3 = String.valueOf(gridlist.get(xcordinate+1).get(ycordinate ));
            a4 = String.valueOf(gridlist.get(xcordinate+2).get(ycordinate ));
        }
        if (a1.equals("S") && a2.equals("S")) {
            jeweldeleter.leftdelete(xcordinate,ycordinate, gridlist);
            return 45;
        } else if (a3.equals("S") && a4.equals("S")) {
            jeweldeleter.rightdelete(xcordinate,ycordinate, gridlist);
            return 45;
        }
        else {
            return 45;
        }

    }

}
