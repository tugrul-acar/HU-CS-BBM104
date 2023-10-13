import java.util.ArrayList;

public class Plus extends Mathsymbol{
    @Override
    public int getpoint() {
        return 0;
    }
    @Override
    public String toString() {
        return "+";
    }

    @Override
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist) {
        jewel a1 = null;
        jewel a2 = null;
        jewel a3 = null;
        jewel a4 = null;
        jewel a5 = null;
        jewel a6 = null;
        jewel a7 = null;
        jewel a8 = null;
        if (xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a1 = gridlist.get(xcordinate-1).get(ycordinate);
            a2 = gridlist.get(xcordinate-2).get(ycordinate);
        }

        if (xcordinate + 1 <= gridlist.size() && xcordinate + 2 <= gridlist.size()) {
            a3 = gridlist.get(xcordinate+1).get(ycordinate );
            a4 = gridlist.get(xcordinate+2).get(ycordinate );
        }
        if (ycordinate + 1 <= gridlist.size() && ycordinate + 2 <= gridlist.size()) {
            a7 = gridlist.get(xcordinate).get(ycordinate + 1);
            a8 = gridlist.get(xcordinate).get(ycordinate + 2);
        }

        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0) {
            a5 = gridlist.get(xcordinate).get(ycordinate - 1);
            a6 = gridlist.get(xcordinate).get(ycordinate - 2);
        }
        if (a1 instanceof Mathsymbol && a2 instanceof Mathsymbol) {
            jeweldeleter.leftdelete(xcordinate,ycordinate, gridlist);
            return 60;
        } else if (a3 instanceof Mathsymbol && a4 instanceof Mathsymbol) {
            jeweldeleter.rightdelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else if (a5 instanceof Mathsymbol && a6 instanceof Mathsymbol) {
            jeweldeleter.updelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else if (a7 instanceof Mathsymbol && a8 instanceof Mathsymbol) {
            jeweldeleter.lowdelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else
            return 0;

    }
}
