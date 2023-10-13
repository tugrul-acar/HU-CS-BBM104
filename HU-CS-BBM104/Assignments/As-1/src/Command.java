import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Command {
    public static ArrayList<String> calculatecommands(String[] commands, ArrayList<Person> people, ArrayList<Food> foods, ArrayList<Sport> sports){
        ArrayList<Integer> liste= new ArrayList<>();
        ArrayList<String> outputtxt = new ArrayList<>();
        for (String command : commands) {
            String[] commandinarray =command.split("\t");
            String[] commandinarray1 = command.split("\\(");
            if(commandinarray.length == 3){
                for (Person person : people) {
                    if(commandinarray[0].equals(String.valueOf(person.getPersonid()))){
                        liste.add(person.getPersonid());
                        if(Integer.parseInt(commandinarray[1])< 2000){
                            for (Food food : foods) {
                                if(String.valueOf(food.getFoodid()).equals(commandinarray[1])){
                                    String foodname = food.getname();
                                    person.calculategained(food.getCalorie(),Integer.parseInt(commandinarray[2]));
                                    int totalgain = food.getCalorie()*Integer.parseInt(commandinarray[2]);
                                    String output = person.getPersonid() + "\t" + "has" +"\t"+"taken"+ "\t"+totalgain +"kcal"+"\t"+"from"+"\t"+foodname;
                                    outputtxt.add(output);
                                    outputtxt.add("***************");
                                }
                            }
                        }
                        if(Integer.parseInt(commandinarray[1]) > 2000){
                            for (Sport sport : sports) {
                                if(String.valueOf(sport.getSportidid()).equals(commandinarray[1])){
                                    String sportname = sport.getname();
                                    int calorielose = sport.getCalorie();
                                    person.calculatelosed(calorielose,Integer.parseInt(commandinarray[2]));
                                    int totallose  = sport.getCalorie()*Integer.parseInt(commandinarray[2])/60;
                                    String output = person.getPersonid() +"\t" +"has"+"\t"+ "burned"+ "\t" +totallose +"kcal"+"\t" +"thanks to"+"\t"+sportname ;
                                    outputtxt.add(output);
                                    outputtxt.add("***************");
                                }
                            }
                        }
                    }
                }
            }
            else if(commandinarray[0].equals("printList")){
                LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(liste);
                ArrayList<Integer> newlist = new ArrayList<>(hashSet);
                for (Integer s : newlist) {
                    for (Person person : people) {
                        if(person.getPersonid() == s){
                            int yas = 2022- person.getDateofbirth();
                            long result = person.getGainedcalorie() - person.getLosedcalorie() - person.getCalorieneed();
                            if(result < 0){
                                String output = person.getname() + "\t"+ yas + "\t"+person.getCalorieneed()+"kcal"+"\t"+person.getGainedcalorie()+"kcal"+"\t"+person.getLosedcalorie()+"kcal"+"\t"+result+"kcal";
                                outputtxt.add(output);
                            }
                            else {
                                String output = person.getname() + "\t"+ yas + "\t"+person.getCalorieneed()+"kcal"+"\t"+person.getGainedcalorie()+"kcal"+"\t"+person.getLosedcalorie()+"kcal"+"\t"+"+"+result+"kcal";
                                outputtxt.add(output);
                            }
                        }
                    }
                }
                outputtxt.add("***************");
            }
            else if(commandinarray1[0].equals("print")){
                String command1 = commandinarray1[1].substring(0,commandinarray1[1].length()-1);
                for (Person person : people) {
                    if(person.getPersonid() == Integer.parseInt(command1)){
                        int yas = 2022 - person.getDateofbirth();
                        long result = person.getGainedcalorie() - person.getLosedcalorie() - person.getCalorieneed();
                        if(result < 0){
                            String output = person.getname() + "\t"+ yas + "\t"+person.getCalorieneed()+"kcal"+"\t"+person.getGainedcalorie()+"kcal"+"\t"+person.getLosedcalorie()+"kcal"+"\t"+result+"kcal";
                            outputtxt.add(output);
                        }
                        else {
                            String output = person.getname() + "\t"+ yas + "\t"+person.getCalorieneed()+"kcal"+"\t"+person.getGainedcalorie()+"kcal"+"\t"+person.getLosedcalorie()+"kcal"+"\t"+"+"+result+"kcal";
                            outputtxt.add(output);
                        }
                        outputtxt.add("***************");
                    }
                }
            }
            else if(commandinarray[0].equals("printWarn")){
                LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(liste);
                ArrayList<Integer> newlist1 = new ArrayList<>(hashSet);
                ArrayList<String> deneme = new ArrayList<>();
                for (Integer s : newlist1) {

                    for (Person person : people) {
                        if(person.getPersonid() == s){
                            long result = person.getGainedcalorie() - person.getLosedcalorie() - person.getCalorieneed();
                            if(result > 0){
                                int yas = 2022 - person.getDateofbirth();
                                String output = person.getname() + "\t"+yas +"\t"+person.getCalorieneed()+"kcal"+"\t"+person.getGainedcalorie()+"kcal"+"\t"+person.getLosedcalorie()+"kcal"+"\t"+"+"+result+"kcal";
                                deneme.add(output);
                                outputtxt.add(output);
                                outputtxt.add("***************");
                            }
                        }

                    }

                }
                if(deneme.size() == 0){
                    outputtxt.add("there"+"\t" +"is"+"\t"+ "no"+"\t"+ "such"+"\t"+ "person");
                    outputtxt.add("***************");
                }
            }
        }
        return outputtxt;
    }















}

