import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application
{   public static int errortime = 0;
    public static void main(String[] args) throws IOException {
        PropertyReader.propertyreader();
        ArrayList<String> commands = ReadFile.addcommandtoarray("assets\\data\\backup.dat");
        ReadFile.makecommands(commands);

        launch(args);

    }
    @Override
    public void stop() throws IOException {
        ReadFile.savebackup();

    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Media media = new Media(new File("assets\\effects\\error.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);

        Image icon = new Image(new FileInputStream("assets\\icons\\logo.png"));
        primaryStage.getIcons().add(icon);

        Image empty_seat = new Image(new FileInputStream("assets\\icons\\empty_seat.png"));
        Image reserved_seat = new Image(new FileInputStream("assets\\icons\\reserved_seat.png"));

        Scene girisscene = Scenes.girisscene(primaryStage,player,empty_seat,reserved_seat);
        primaryStage.setScene(girisscene);

        primaryStage.setTitle(PropertyReader.getTitle());
        primaryStage.show();


    }


}
