import java.util.ArrayList;

public class Minus extends Mathsymbol{
    @Override
    public int getpoint() {
        return 0;
    }

    @Override
    public String toString() {
        return "-";
    }

    @Override
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist) {

        jewel a1 = null;
        jewel a2 = null;
        if (xcordinate - 1 >= 0 && xcordinate - 2 >= 0) {
            a1 = gridlist.get(xcordinate-1).get(ycordinate);
            a2 = gridlist.get(xcordinate-2).get(ycordinate);
        }

        jewel a3 = null;
        jewel a4 = null;
        if (xcordinate + 1 <= gridlist.size() && xcordinate + 2 <= gridlist.size()) {
            a3 = gridlist.get(xcordinate+1).get(ycordinate );
            a4 = gridlist.get(xcordinate+2).get(ycordinate );
        }
        if (a1 instanceof Mathsymbol && a2 instanceof Mathsymbol) {
            jeweldeleter.leftdelete(xcordinate,ycordinate, gridlist);
            return 60;
        } else if (a3 instanceof Mathsymbol && a4 instanceof Mathsymbol) {
            jeweldeleter.rightdelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else
            return 0;

    }
}
