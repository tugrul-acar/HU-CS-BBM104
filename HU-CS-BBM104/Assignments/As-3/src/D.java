import java.util.ArrayList;

public class D extends Letter{
    public int point =30;
    @Override
    public int getpoint() {
        return point;
    }
    @Override
    public String toString() {
        return "D";
    }
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        String a1 = " ";
        String a2 = " ";
        String a3 = " ";
        String a4 = " ";
        String a5 = " ";
        String a6 = " ";
        String a7 = " ";
        String a8 = " ";
        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0 && xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a1 = String.valueOf(gridlist.get(xcordinate-1).get(ycordinate - 1));
            a2 = String.valueOf(gridlist.get(xcordinate-2).get(ycordinate - 2));
        }
        if (ycordinate + 1 < gridlist.size() && ycordinate + 2 < gridlist.size() && xcordinate + 1 < gridlist.size() && xcordinate + 2 < gridlist.size()) {
            a3 = String.valueOf(gridlist.get(xcordinate+1).get(ycordinate + 1));
            a4 = String.valueOf(gridlist.get(xcordinate+2).get(ycordinate + 2));
        }
        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0 && xcordinate + 1 < gridlist.size() && xcordinate + 2 < gridlist.size()) {
            a5 = String.valueOf(gridlist.get(xcordinate+1).get(ycordinate - 1));
            a6 = String.valueOf(gridlist.get(xcordinate+2).get(ycordinate - 2));
        }
        if (ycordinate + 1 < gridlist.size() && ycordinate + 2 < gridlist.size() && xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a7 = String.valueOf(gridlist.get(xcordinate-1).get(ycordinate + 1));
            a8 = String.valueOf(gridlist.get(xcordinate-2).get(ycordinate + 2));
        }

        if (a1.equals("D") && a2.equals("D")) {
            jeweldeleter.leftupdelete(xcordinate,ycordinate, gridlist);
            return 90;
        }else if (a3.equals("D") && a4.equals("D")) {
            jeweldeleter.rightlowdelete(xcordinate,ycordinate, gridlist);
            return 90;
        }else if (a5.equals("D") && a6.equals("D")) {
            jeweldeleter.rightupdelete(xcordinate,ycordinate, gridlist);
            return 90;
        }else if (a7.equals("D") && a8.equals("D")) {
            jeweldeleter.leftlowdelete(xcordinate,ycordinate, gridlist);
            return 90;
        }else{
            return 0;
        }
    }

}
