import java.util.ArrayList;

public class jeweldeleter {
    public static void updelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate).remove(ycordinate - 1);
        gridlist.get(xcordinate).remove(ycordinate - 2);

        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate).add(0, new space());
    }
    public static void lowdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate).add(0, new space());
    }
    public static void leftdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate-1).remove(ycordinate);
        gridlist.get(xcordinate-2).remove(ycordinate);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate-1).add(0, new space());
        gridlist.get(xcordinate-2).add(0, new space());
    }
    public static void rightdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate+2).remove(ycordinate);
        gridlist.get(xcordinate+1).remove(ycordinate);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate+1).add(0, new space());
        gridlist.get(xcordinate+2).add(0, new space());
    }
    public static void leftupdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate-1).remove(ycordinate-1);
        gridlist.get(xcordinate-2).remove(ycordinate-2);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate-1).add(0, new space());
        gridlist.get(xcordinate-2).add(0, new space());
    }
    public static void rightlowdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate+1).remove(ycordinate+1);
        gridlist.get(xcordinate+2).remove(ycordinate+2);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate+1).add(0, new space());
        gridlist.get(xcordinate+2).add(0, new space());
    }
    public static void rightupdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate+1).remove(ycordinate-1);
        gridlist.get(xcordinate+2).remove(ycordinate-2);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate+1).add(0, new space());
        gridlist.get(xcordinate+2).add(0, new space());
    }
    public static void leftlowdelete(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist){
        gridlist.get(xcordinate).remove(ycordinate);
        gridlist.get(xcordinate-1).remove(ycordinate+1);
        gridlist.get(xcordinate-2).remove(ycordinate+2);
        gridlist.get(xcordinate).add(0, new space());
        gridlist.get(xcordinate-1).add(0, new space());
        gridlist.get(xcordinate-2).add(0, new space());
    }


}
