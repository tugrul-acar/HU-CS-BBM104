import java.util.ArrayList;

public class W extends Letter{
    public int point =10;
    public int sum =0;
    @Override
    public String toString() {
        return "W";
    }
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        jewel a1 = new space();
        jewel a2 = new space();
        jewel a3 = new space();
        jewel a4 = new space();
        jewel a5 = new space();
        jewel a6 = new space();
        jewel a7 = new space();
        jewel a8 = new space();
        jewel a9 = new space();
        jewel a10 = new space();
        jewel a11 = new space();
        jewel a12 = new space();
        jewel a13 = new space();
        jewel a14 = new space();
        jewel a15 = new space();
        jewel a16 = new space();
        if (ycordinate + 1 < gridlist.size() && ycordinate + 2 < gridlist.size()) {
            a1 = gridlist.get(xcordinate).get(ycordinate + 1);
            a2 = gridlist.get(xcordinate).get(ycordinate + 2);

        }

        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0) {
            a3 = gridlist.get(xcordinate).get(ycordinate - 1);
            a4 = gridlist.get(xcordinate).get(ycordinate - 2);
        }
        if (xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a5 = gridlist.get(xcordinate-1).get(ycordinate);
            a6 = gridlist.get(xcordinate-2).get(ycordinate);
        }

        if (xcordinate + 1 < gridlist.size() && xcordinate + 2 < gridlist.size()) {
            a7 = gridlist.get(xcordinate+1).get(ycordinate );
            a8 = gridlist.get(xcordinate+2).get(ycordinate );
        }
        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0 && xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a9 = gridlist.get(xcordinate-1).get(ycordinate - 1);
            a10 = gridlist.get(xcordinate-2).get(ycordinate - 2);
        }
        if (ycordinate + 1 < gridlist.size() && ycordinate + 2 < gridlist.size() && xcordinate + 1 < gridlist.size() && xcordinate + 2 < gridlist.size()) {
            a11 = gridlist.get(xcordinate+1).get(ycordinate + 1);
            a12 = gridlist.get(xcordinate+2).get(ycordinate + 2);
        }
        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0 && xcordinate + 1 < gridlist.size() && xcordinate + 2 < gridlist.size()) {
            a13 = gridlist.get(xcordinate+1).get(ycordinate - 1);
            a14 = gridlist.get(xcordinate+2).get(ycordinate - 2);
        }
        if (ycordinate + 1 < gridlist.size() && ycordinate + 2 < gridlist.size() && xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a15 = gridlist.get(xcordinate-1).get(ycordinate + 1);
            a16 = gridlist.get(xcordinate-2).get(ycordinate + 2);
        }
        if (a3.toString().equals("W") && a4 instanceof Letter || a3 instanceof Letter && a4.toString().equals(a3.toString()) || a3 instanceof Letter && a4.toString().equals("W")) {
            jeweldeleter.updelete(xcordinate,ycordinate, gridlist);
            sum += a3.getpoint() + a4.getpoint();
        }
        else if (a1.toString().equals("W") && a2 instanceof Letter || a1 instanceof Letter && a2.toString().equals(a1.toString()) || a1 instanceof Letter && a2.toString().equals("W")) {
            jeweldeleter.lowdelete(xcordinate,ycordinate, gridlist);
            sum += a1.getpoint() + a2.getpoint();
        }
        else if (a5.toString().equals("W") && a6 instanceof Letter || a5 instanceof Letter && a6.toString().equals(a5.toString()) || a5 instanceof Letter && a6.toString().equals("W")) {
            jeweldeleter.leftdelete(xcordinate,ycordinate, gridlist);
            sum += a5.getpoint() + a6.getpoint();
        } else if (a7.toString().equals("W") && a8 instanceof Letter || a7 instanceof Letter && a8.toString().equals(a7.toString()) || a7 instanceof Letter && a8.toString().equals("W")) {
            jeweldeleter.rightdelete(xcordinate,ycordinate, gridlist);
            sum += a7.getpoint() + a8.getpoint();
        }
        else if (a9.toString().equals("W") && a10 instanceof Letter || a9 instanceof Letter && a10.toString().equals(a9.toString()) || a9 instanceof Letter && a10.toString().equals("W")) {
            jeweldeleter.leftupdelete(xcordinate,ycordinate, gridlist);
            sum += a9.getpoint() + a10.getpoint();
        }else if (a11.toString().equals("W") && a12 instanceof Letter || a11 instanceof Letter && a12.toString().equals(a11.toString()) || a11 instanceof Letter && a12.toString().equals("W")) {
            jeweldeleter.rightlowdelete(xcordinate,ycordinate, gridlist);
            sum += a11.getpoint() + a12.getpoint();
        }else if (a13.toString().equals("W") && a14 instanceof Letter || a13 instanceof Letter && a14.toString().equals(a13.toString()) || a13 instanceof Letter && a14.toString().equals("W")) {
            jeweldeleter.rightupdelete(xcordinate,ycordinate, gridlist);
            sum += a13.getpoint() + a14.getpoint();
        }else if (a15.toString().equals("W") && a16 instanceof Letter || a15 instanceof Letter && a16.toString().equals(a15.toString()) || a15 instanceof Letter && a16.toString().equals("W")) {
            jeweldeleter.leftlowdelete(xcordinate,ycordinate, gridlist);
            sum += a15.getpoint() + a16.getpoint();
        }
        if(sum == 0){
            return sum;
        }
        else {
            return sum+10;
        }


    }

    @Override
    public int getpoint() {
        return point;
    }
}
