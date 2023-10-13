import java.util.ArrayList;

public abstract class jewel {
     @Override
     public abstract String toString();

     public  abstract int  jewelmake(int xcordinate, int ycordinate, ArrayList<ArrayList<jewel>> gridlist);
     public abstract int getpoint();
}
