public class Node<T>{
    private T data;
    public Node<T> nextnode = null;
    public Node(T obje){
        this(obje,null);
    }
    public Node(T obje,Node<T> node ){
        data = obje;
        nextnode = node;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNextnode() {
        return nextnode;
    }
}
