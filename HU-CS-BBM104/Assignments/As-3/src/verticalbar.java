import java.util.ArrayList;

public class verticalbar extends Mathsymbol{
    @Override
    public int getpoint() {
        return 0;
    }
    @Override
    public String toString() {
        return "|";
    }

    @Override
    public int jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist) {
        jewel a1 = null;
        jewel a2 = null;
        jewel a3 = null;
        jewel a4 = null;
        if (ycordinate - 1 >= 0 && ycordinate - 2 >= 0) {
            a1 = gridlist.get(xcordinate).get(ycordinate - 1);
            a2 = gridlist.get(xcordinate).get(ycordinate - 2);
        }
        if (ycordinate + 1 <= gridlist.size() && ycordinate + 2 <= gridlist.size()) {
            a3 = gridlist.get(xcordinate).get(ycordinate + 1);
            a4 = gridlist.get(xcordinate).get(ycordinate + 2);
        }
        if (a1 instanceof Mathsymbol && a2 instanceof Mathsymbol) {
            jeweldeleter.updelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else if (a3 instanceof Mathsymbol && a4 instanceof Mathsymbol) {
            jeweldeleter.lowdelete(xcordinate,ycordinate, gridlist);
            return 60;
        }
        else
            return 0;


    }
}
