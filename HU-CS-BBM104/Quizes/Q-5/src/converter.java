import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class converter {
    public static void convert(ArrayList<String> command) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        writer.close();
        Stack<Integer> converterstack = new Stack<>();

        for (String s : command) {
            int number = Integer.parseInt(s);
            while (number != 0){
                int remainder = number % 8;
                number = number / 8;
                converterstack.Push(remainder);
            }
            FileWriter writer1 = new FileWriter("output.txt",true);
            while (!converterstack.isEmpty()){
                writer1.write(String.valueOf(converterstack.Pop()));
            }
            writer1.write("\n");
            writer1.close();


        }

    }
    public static void queuecommandmake(ArrayList<String> queuecommand) throws IOException {
        Queue a = new Queue();

        for (String s : queuecommand) {
            String[] command= s.split(" ");
            if(command.length == 2){
                if(command[0].equals("enqueFront")){
                    a.enqueFront(Integer.parseInt(command[1]));
                    a.print();
                }
                if(command[0].equals("enqueBack")){
                    a.enqueBack(Integer.parseInt(command[1]));
                    a.print();
                }
                if(command[0].equals("enqueMiddle")){
                    a.enqueMiddle(Integer.parseInt(command[1]));
                    a.print();
                }
            }else if(command.length == 1){
                if(command[0].equals("dequeFront")){
                    a.dequeFront();
                    a.print();
                }
                if(command[0].equals("dequeMiddle")){
                    a.dequeMiddle();
                    a.print();
                }
                if(command[0].equals("dequeBack")){
                    a.dequeBack();
                    a.print();
                }
            }

        }

    }
}
