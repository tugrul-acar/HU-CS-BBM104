public class EmptyException extends RuntimeException{
    public EmptyException(){
        this("stack");
    }
    public EmptyException(String name){
        super(name +" is empty");
    }
}
