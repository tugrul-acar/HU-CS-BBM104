public abstract class Square { //this is abstract class that contain chance ,community chance and properties and others
    public int positon;
    private String tür ;
    Square(int positon,String tür){
        this.tür = tür;
        this.positon = positon;
    }

    public String getTür() {
        return tür;
    }
}
