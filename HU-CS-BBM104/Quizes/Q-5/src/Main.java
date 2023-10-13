import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        ArrayList<String> commandlist = ReadFile.addcommandtoarray(path);

        ArrayList<String> stackcommand = ReadFile.addstackcommands(commandlist);
        ArrayList<String> queuecommand = ReadFile.addqueuecommands(commandlist);

        converter.convert(stackcommand);
        converter.queuecommandmake(queuecommand);









    }
}
