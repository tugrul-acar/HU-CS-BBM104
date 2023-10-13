import java.util.ArrayList;

public class T extends Letter{
    public int point = 15;
    @Override
    public int getpoint() {
        return point;
    }
    @Override
    public String toString() {
        return "T";
    }
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist) {
        String a1 = " ";
        String a2 = " ";
        String a3 = " ";
        String a4 = " ";
        if (ycordinate + 1 <= gridlist.size() && ycordinate + 2 <= gridlist.size()) {
            a1 = String.valueOf(gridlist.get(xcordinate).get(ycordinate + 1));
            a2 = String.valueOf(gridlist.get(xcordinate).get(ycordinate + 2));
        }

        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0) {
            a3 = String.valueOf(gridlist.get(xcordinate).get(ycordinate - 1));
            a4 = String.valueOf(gridlist.get(xcordinate).get(ycordinate - 2));
        }

        if (a3.equals("T") && a4.equals("T")) {
            jeweldeleter.updelete(xcordinate,ycordinate, gridlist);
            return 45;
        }
        else if (a1.equals("T") && a2.equals("T")) {
            jeweldeleter.lowdelete(xcordinate,ycordinate, gridlist);
            return 45;
        }
        else{
            return 0;
        }



    }
    }



