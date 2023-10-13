public class FullException extends RuntimeException{
    public FullException(){
        this("stack");
    }
    public FullException(String name){
        super(name +" is full");
    }
}