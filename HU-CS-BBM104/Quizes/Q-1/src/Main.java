import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        int birler,onlar,yuzler,binler,onbinler,sum;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Integer> listascent = new ArrayList<Integer>();
        ArrayList<Integer> listdescent = new ArrayList<Integer>();
        ArrayList<Integer> Armstrongnumbers = new ArrayList<Integer>();
        String inputfile = args[0];
        String outputfile = args[1];
        File output = new File(outputfile);
        File file = new File(inputfile);
        FileReader freader = new FileReader(file);
        String line;
        BufferedReader breader = new BufferedReader(freader);
        while ((line = breader.readLine()) != null){
            list.add(line);



        }
        breader.close();
        int length = list.size();
        for(int i = 0; i < length;i++){
            if ("Calculating Armstrong numbers".equals(list.get(i))){
                FileWriter xWriter = new FileWriter(output,false);
                BufferedWriter yWriter = new BufferedWriter(xWriter);
                yWriter.write("Calculating Armstrong numbers \n"); yWriter.close();
                Integer number = Integer.valueOf(list.get(i+1));
                for(int j =100;j <= number;j++){
                    if(j < 1000){
                        int temp = j;
                        birler = temp % 10;
                        temp = temp /10;
                        onlar = temp % 10;
                        temp = temp /10;
                        yuzler =temp %10;
                        temp = temp /10;
                        sum = birler*birler*birler + onlar*onlar*onlar + yuzler*yuzler*yuzler;
                        if(sum == j){
                            Armstrongnumbers.add(j);
                        }
                    }
                    if(j >= 1000 && j<10000){
                        int temp = j;
                        birler = temp % 10;
                        temp = temp /10;
                        onlar = temp % 10;
                        temp = temp /10;
                        yuzler =temp %10;
                        temp = temp /10;
                        binler = temp %10;
                        temp = temp /10;
                        sum = birler*birler*birler*birler + onlar*onlar*onlar*onlar + yuzler*yuzler*yuzler*yuzler + binler*binler*binler*binler;
                        if(sum == j){
                            Armstrongnumbers.add(j);
                        }
                    }
                    if(j >= 10000){
                        int temp = j;
                        birler = temp % 10;
                        temp = temp /10;
                        onlar = temp % 10;
                        temp = temp /10;
                        yuzler =temp %10;
                        temp = temp /10;
                        binler = temp %10;
                        temp = temp /10;
                        onbinler = temp %10;
                        temp = temp /10;
                        sum = birler*birler*birler*birler*birler + onlar*onlar*onlar*onlar*onlar + yuzler*yuzler*yuzler*yuzler*yuzler + binler*binler*binler*binler*binler+ onbinler*onbinler*onbinler*onbinler*onbinler;
                        if(sum == j){
                            Armstrongnumbers.add(j);
                        }
                    }

                }
                int len = Armstrongnumbers.size();
                for(int k=0;k<len;k++ ){
                    FileWriter myWriter = new FileWriter(output,true);
                    BufferedWriter bWriter = new BufferedWriter(myWriter);
                    bWriter.write(String.valueOf(Armstrongnumbers.get(k))+" "); bWriter.close();
                }
            }

            if ("Ascending order sorting".equals(list.get(i))){
                FileWriter myWriter = new FileWriter(output,true);
                BufferedWriter bWriter = new BufferedWriter(myWriter);
                bWriter.write("\nAscending order sorting \n"); bWriter.close();
                while (!("-1".equals(list.get(i+1)))){
                    i++;
                    Integer number = Integer.valueOf(list.get(i));
                    listascent.add(number);
                    int len1 = listascent.size();
                    Collections.sort(listascent);
                    for(int l=0;l<len1;l++){
                        FileWriter yuWriter = new FileWriter(output,true);
                        BufferedWriter buWriter = new BufferedWriter(yuWriter);
                        buWriter.write(listascent.get(l)+" "); buWriter.close();
                    }
                    FileWriter yiWriter = new FileWriter(output,true);
                    BufferedWriter biWriter = new BufferedWriter(yiWriter);
                    biWriter.write("\n"); biWriter.close();

                }

            }
            if ("Descending order sorting".equals(list.get(i))){
                FileWriter myWriter = new FileWriter(output,true);
                BufferedWriter bWriter = new BufferedWriter(myWriter);
                bWriter.write("Descending order sorting \n"); bWriter.close();

                while (!("-1".equals(list.get(i+1)))){
                    i++;
                    Integer number = Integer.valueOf(list.get(i));
                    listdescent.add(number);
                    int len1 = listdescent.size();
                    Collections.sort(listdescent, Collections.reverseOrder());
                    for(int l=0;l<len1;l++){
                        FileWriter yuWriter = new FileWriter(output,true);
                        BufferedWriter buWriter = new BufferedWriter(yuWriter);
                        buWriter.write(listdescent.get(l)+" "); buWriter.close();
                    }
                    FileWriter yiWriter = new FileWriter(output,true);
                    BufferedWriter biWriter = new BufferedWriter(yiWriter);
                    biWriter.write("\n"); biWriter.close();

                }
            }
            if("Exit".equals(list.get(i))){
                FileWriter myWriter = new FileWriter(output,true);
                BufferedWriter bWriter = new BufferedWriter(myWriter);
                bWriter.write("Terminated.."); bWriter.close();

            }


        }






    }
}
