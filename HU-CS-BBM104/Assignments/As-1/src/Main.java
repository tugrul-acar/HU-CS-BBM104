import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String command = args[0];
        ArrayList<String> personveri = readfile.addpeopletoarray("people.txt");
        ArrayList<Person> people = readfile.addperson(personveri,personveri.size());
        ArrayList<String> foodveri = readfile.addfoodtoarray("food.txt");
        ArrayList<Food> foods = readfile.addfood(foodveri,foodveri.size());
        ArrayList<String> sportveri = readfile.addsporttoarray("sport.txt");
        ArrayList<Sport> sports = readfile.addsport(sportveri,sportveri.size());
        String[] commandlines = readfile.Readfromfile(command);
        ArrayList<String> monitoring =Command.calculatecommands(commandlines,people,foods,sports);
        FileWriter writer = new FileWriter("monitoring.txt");
        for (int i = 0; i < monitoring.size()-1; i++) {
            writer.write(monitoring.get(i)+System.lineSeparator());
        }
        writer.close();

    }
}
