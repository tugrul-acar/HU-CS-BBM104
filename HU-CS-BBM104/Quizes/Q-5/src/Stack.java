public class Stack<T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int nodeNumber;
    public Stack(){
        firstNode = lastNode = null;

    }
    public void Push(T object){
        if(isEmpty())
            firstNode = lastNode = new Node<>(object);
        else if (isFull()){
            throw new FullException();
        }
        else
            firstNode = new Node<>(object,firstNode);
        this.nodeNumber += 1;
    }
    public T Pop(){
        if(isEmpty())
            throw new EmptyException();
        T item = firstNode.getData();
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.getNextnode();
        return item;
    }

    public T Top(){
        return lastNode.getData();
    }


    public boolean isFull(){
        return nodeNumber > 50;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }
    public int Size(){
        return nodeNumber;
    }






}
