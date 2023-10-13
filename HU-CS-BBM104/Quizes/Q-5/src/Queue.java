import java.io.FileWriter;
import java.io.IOException;

public class Queue {
    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int nodeNumber= 0;

    public Queue(){
        firstNode = lastNode = null;
    }
    public void enqueFront(int val){
        if(isEmpty())
            firstNode = lastNode = new Node<>(val);
        else if (isFull()){
            throw new FullException();
        }
        else
            firstNode = new Node<>(val,firstNode);
        this.nodeNumber += 1;
    }
    public void enqueBack(int val){
        if(isEmpty())
            firstNode = lastNode = new Node<>(val);
        else {
            lastNode =lastNode.nextnode = new Node<>(val);
        }
        this.nodeNumber += 1;
    }
    public void enqueMiddle(int val){
        if(isEmpty())
            firstNode = lastNode = new Node<>(val);
        else {
            int middle = 0;
            Node<Integer> currentnode = firstNode;
            if(nodeNumber % 2 ==1){
                middle = nodeNumber / 2 +1;
            }
            else{
                middle = nodeNumber / 2;
            }
            for (int i = 0; i < middle-2; i++) {
                currentnode = currentnode.nextnode;
            }
            currentnode.nextnode = new Node<>(val,currentnode.nextnode);

        }
        this.nodeNumber += 1;
    }

    public int dequeFront(){
        this.nodeNumber -= 1;
        if(isEmpty())
            return -1;
        int item = firstNode.getData();
        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.getNextnode();
        return item;

    }



    public int dequeBack(){
        this.nodeNumber -= 1;
        if(isEmpty())
            return -1;
        int item = lastNode.getData();

        if(firstNode == lastNode)
            firstNode = lastNode = null;
        else{
            Node<Integer> currentnode = firstNode;
            while (currentnode.nextnode != lastNode){
                currentnode = currentnode.nextnode;
            }
            lastNode = currentnode;

            currentnode.nextnode = null;
        }
        return item;
    }
    public int dequeMiddle(){

        if(isEmpty())
            return -1;
        else {
            int middle = 0;
            Node<Integer> currentnode = firstNode;
            Node<Integer> currentnodebefore = firstNode;
            int item = currentnode.getData();
            if(nodeNumber % 2 ==1){
                middle = nodeNumber / 2 +1;
            }
            else{
                middle = nodeNumber / 2;
            }
            this.nodeNumber -= 1;
            for (int i = 0; i < middle-2; i++) {
                currentnodebefore = currentnodebefore.nextnode;
            }
            for (int i = 0; i < middle-1; i++) {
                currentnode = currentnode.nextnode;
            }
            if(currentnodebefore == currentnode){
                firstNode = currentnode.nextnode;
            }
            else{
                currentnodebefore.nextnode = currentnode.nextnode;
            }

            return item;

        }

    }












    public boolean isFull(){
        return nodeNumber > 50;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }
    public void print() throws IOException {
        Node<Integer> currentnode = firstNode;
        String a = "[";
        int append = 0;
        for (int i = 0; i < nodeNumber; i++) {
            if(nodeNumber == 1){
                FileWriter writer1 = new FileWriter("output.txt",true);
                writer1.write("["+String.valueOf(currentnode.getData())+"]");
                writer1.write("\n");
                writer1.close();
            }
            else{
                if(append == 0){
                    a = a+currentnode.getData();
                    append = 1;
                }
                else
                    a = a+","+currentnode.getData();
            }

            currentnode = currentnode.nextnode;
        }
        a = a+"]";
        if(nodeNumber != 1){
            FileWriter writer1 = new FileWriter("output.txt",true);
            writer1.write(a);
            writer1.write("\n");
            writer1.close();
        }



    }
}
