public class Othersquares extends Square{
    private final String name;
    public Othersquares(int position,String name){
        super(position,"other");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
