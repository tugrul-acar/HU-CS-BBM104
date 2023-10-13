import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sceneseditfilm {
    public static boolean iszero = true;
    public static Scene addilmsecene(MediaPlayer player, Stage primaryStage, GridPane movieselect2, ComboBox<String> movies,Scene movie_choice_scene,Button ok){
        GridPane addfilmpane1 = new GridPane();
        addfilmpane1.setHgap(5);
        addfilmpane1.setVgap(5);
        Button back1 = new Button("back");
        Button ok1 = new Button("OK");
        GridPane addfilmpane = new GridPane();
        addfilmpane.setHgap(5);
        addfilmpane.setVgap(5);
        TextField namefield = new TextField();
        TextField trailerfield = new TextField();
        TextField durationfield = new TextField();
        Label welcome11 = new Label("Please give name,relative path of the trailer and duration of film.");
        Label name = new Label("Name:");
        Label trailer = new Label("Trailer (Path):");
        Label duration = new Label("Duration (m):");
        GridPane addfilmpane2 = new GridPane();
        Label error1 = new Label("");
        addfilmpane1.add(name,0,0);
        addfilmpane1.add(namefield,1,0);
        addfilmpane1.add(trailer,0,1);
        addfilmpane1.add(trailerfield,1,1);
        addfilmpane1.add(duration,0,2);
        addfilmpane1.add(durationfield,1,2);
        addfilmpane.setAlignment(Pos.CENTER);
        addfilmpane1.setAlignment(Pos.CENTER);
        addfilmpane.add(welcome11,0,0);
        addfilmpane.add(addfilmpane1,0,1);
        addfilmpane1.add(back1,0,3);
        addfilmpane1.add(ok1,1,3);
        GridPane.setHalignment(ok1, HPos.RIGHT);
        Scene addfilmscene = new Scene(addfilmpane,400,400);

        back1.setOnAction(event1 -> {
            movies.getItems().clear();
            movieselect2.getChildren().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);
            primaryStage.setScene(movie_choice_scene);
        });

        ok1.setOnAction(event1 -> {
            String trailerpath = "assets\\trailers\\"+trailerfield.getText();
            Path path = Paths.get(trailerpath);
            if(namefield.getText().equals("")){
                String a = "ERROR: Film name could not be empty!";
                error1.setText(a);
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);
                player.stop();
                player.play();

            }
            else if(Movie.movienames.contains(namefield.getText())){
                String a = "ERROR: Film name already taken!";
                error1.setText(a);
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);
                player.stop();
                player.play();

            }
            else if(trailerfield.getText().equals("")){
                error1.setText("ERROR: Trailer path could not be empty!");
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);
                player.stop();
                player.play();
            }
            else if(!ReadFile.isNumeric(durationfield.getText())){
                error1.setText("ERROR: Duration has to be a positive integer!");
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);
                player.stop();
                player.play();
            }
            else if(!Files.exists(path)){
                error1.setText("ERROR: There is no such a trailer!");
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);
                player.stop();
                player.play();
            }
            else {
                Movie movie = new Movie(namefield.getText(),trailerfield.getText(),Integer.parseInt(durationfield.getText()));
                error1.setText("SUCCESS : Film added successfully!");
                addfilmpane.getChildren().clear();
                addfilmpane.add(welcome11,0,0);
                addfilmpane.add(addfilmpane1,0,1);
                addfilmpane.add(error1,0,2);


            }



        });
        return addfilmscene;
    }



    public static Scene removefilmscene(Stage primaryStage, GridPane movieselect2, ComboBox<String> movies,Scene movie_choice_scene,Button ok){
        GridPane gridPaneremovefilm = new GridPane();
        Button backremove = new Button("< back");
        Button okremove = new Button("OK");
        Label welcome111 = new Label("Select the film that you desire to remove and then click OK.");
        ComboBox<String> moviesremove = new ComboBox<>();
        if(Movie.movienames.size() != 0){
            moviesremove.setValue(Movie.movienames.get(0));
        }

        ObservableList<String> items11 = FXCollections.observableArrayList(Movie.movienames);
        moviesremove.getItems().addAll(items11);
        gridPaneremovefilm.setAlignment(Pos.CENTER);
        gridPaneremovefilm.add(welcome111,0,0);
        gridPaneremovefilm.add(moviesremove,0,1);
        gridPaneremovefilm.add(backremove,0,2);
        gridPaneremovefilm.add(okremove,1,2);
        GridPane.setHalignment(okremove, HPos.LEFT);
        Scene removescene = new Scene(gridPaneremovefilm,400,400);
        okremove.setOnAction(event -> {
            if(Movie.movienames.size() != 0){
                int index = Movie.movienames.indexOf(moviesremove.getValue());

                Movie movie = Movie.movies.get(index);
                for (String s : movie.hallArrayList){
                    for (Hall hall : Hall.hallArrayList) {
                        if(hall.hallname.equals(s)){
                            for (Seat[] seat : hall.seats) {
                                for (Seat seat1 : seat) {
                                    Seat.seatArrayList.remove(seat1);
                                }
                            }
                        }
                    }
                }

                for (String s : movie.hallArrayList) {
                    Hall.hallArrayList.removeIf(hall -> hall.hallname.equals(s));
                    Hall.hallnames.removeIf(hall -> hall.equals(s));
                }
                Movie.movies.remove(index);
                Movie.movienames.remove(index);
                gridPaneremovefilm.getChildren().clear();
                moviesremove.getItems().clear();
                ObservableList<String> items11_1 =
                        FXCollections.observableArrayList(Movie.movienames);
                moviesremove.getItems().addAll(items11_1);
                if(Movie.movienames.size() != 0){
                    moviesremove.setValue(Movie.movienames.get(0));
                }

                gridPaneremovefilm.setAlignment(Pos.CENTER);
                gridPaneremovefilm.add(welcome111,0,0);
                gridPaneremovefilm.add(moviesremove,0,1);
                gridPaneremovefilm.add(backremove,0,2);
                gridPaneremovefilm.add(okremove,1,2);
            }



        });
        backremove.setOnAction(event -> {
            movies.getItems().clear();
            movieselect2.getChildren().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }

            primaryStage.setScene(movie_choice_scene);
        });
        return removescene;

    }


    public static Scene playtrailerscene(MediaPlayer player, Stage primaryStage, GridPane movieselect2, ComboBox<String> movies, Scene movie_choice_scene, Image empty_seat,Image reserved_seat){
        ComboBox<String> selecthall = new ComboBox<>();
        int index = Movie.movienames.indexOf(movies.getValue());
        Movie movie = Movie.movies.get(index);
        String path = "assets\\trailers\\"+movie.path;



        ObservableList<String> itemshall = FXCollections.observableArrayList(movie.hallArrayList);
        selecthall.getItems().addAll(itemshall);
        Media moviemedia = new Media(new File(path).toURI().toString());
        MediaPlayer movieplayer = new MediaPlayer(moviemedia);
        Button btnpause = new Button("||");
        Button btnplay = new Button(">");
        Button btngo = new Button(">>");
        Button btnback = new Button("<<");
        Button btnzero = new Button("|<<");
        Button back = new Button("< Back");
        Button addhall = new Button("Add hall");
        Button removehall = new Button("Remove hall");
        Button ok2 = new Button("OK");

        Slider volume = new Slider();
        volume.setOrientation(Orientation.VERTICAL);
        volume.setValue(10);
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                movieplayer.setVolume(volume.getValue()/100);
            }
        });
        MediaView movieview = new MediaView(movieplayer);
        movieview.setFitHeight(500);
        movieview.setFitWidth(500);
        player.setOnReady(() -> primaryStage.sizeToScene());
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnplay,btngo,btnback,btnzero,volume);
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();

        vBox.setSpacing(10);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        pane.setRight(vBox);



        ///////////////////
        ////////////////////

        if(User.isadmin){
            hBox.getChildren().addAll(back,addhall,removehall,selecthall,ok2);
        }
        else {
            hBox.getChildren().addAll(back,selecthall,ok2);
        }
        pane.setBottom(hBox);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setCenter(movieview);
        if(movie.hallArrayList.size() != 0 && iszero){
            selecthall.setValue(movie.hallArrayList.get(0));
        }
        else {
            selecthall.getItems().clear();
        }
        Scene scene5 = new Scene(pane);

        /////////////////////////
        /////////////////////////media butonları ayarları
        btngo.setOnAction(event1 -> {
            Duration currentime = movieplayer.getCurrentTime();
            int value = (int) currentime.toSeconds() + 5;
            Duration time = Duration.seconds(value);
            movieplayer.seek(time);
        });



        btnback.setOnAction(event1 -> {
            Duration currentime = movieplayer.getCurrentTime();
            int value = (int) currentime.toSeconds() - 5;
            Duration time = Duration.seconds(value);
            movieplayer.seek(time);
        });
        ////////////////
        back.setOnAction(event1 -> {
            movieplayer.stop();
            primaryStage.setScene(movie_choice_scene);
        });
        ///////////////////
        btnpause.setOnAction(event1 -> {
            movieplayer.pause();

            vBox.getChildren().clear();
            vBox.getChildren().addAll(btnplay,btngo,btnback,btnzero,volume);
        });
        ///////////////////////
        btnplay.setOnAction(event1 -> {
            movieplayer.play();
            vBox.getChildren().clear();
            vBox.getChildren().addAll(btnpause,btngo,btnback,btnzero,volume);
        });
        /////////////////////////
        btnzero.setOnAction(event1 -> {
            movieplayer.seek(Duration.ZERO);
        });
        ///////////////////////////
        addhall.setOnAction(event1 -> {
            movieplayer.stop();
            primaryStage.setScene(Hallscenes.addhallscene(movieplayer,movie,primaryStage,scene5,player,selecthall));

        });
        ok2.setOnAction(event -> {
            movieplayer.stop();
            primaryStage.sizeToScene();
            if(movie.hallArrayList.size() != 0){
                primaryStage.setScene(Hallscenes.makehall(empty_seat,reserved_seat,selecthall,primaryStage,scene5,movie));
            }


        });
        removehall.setOnAction(event -> {
            movieplayer.stop();
            primaryStage.setScene(removehallscene(primaryStage,scene5,movie,selecthall));
        });

        return scene5;
    }


    public static Scene removehallscene(Stage primaryStage,Scene scene5,Movie movie,ComboBox<String> selecthall){
        GridPane removehallpane = new GridPane();
        Button back = new Button("<Back");
        Button ok = new Button("OK");
        Label removefilmlabel = new Label("Select the hall that you desire to remove from "+movie.name+" and then click OK.");
        ComboBox<String> removefilmbox = new ComboBox<>();
        ObservableList<String> itemshall = FXCollections.observableArrayList(movie.hallArrayList);

        if(movie.hallArrayList.size() != 0){
            removefilmbox.setValue(movie.hallArrayList.get(0));
        }


        removefilmbox.getItems().addAll(itemshall);
        removehallpane.setHgap(20);
        removehallpane.setVgap(20);
        removehallpane.setAlignment(Pos.CENTER);
        removehallpane.setPadding(new Insets(20,20,20,20));
        removehallpane.add(removefilmlabel,0,0);
        GridPane.setColumnSpan(removefilmlabel,3);
        GridPane.setHalignment(removefilmlabel,HPos.CENTER);
        removehallpane.add(removefilmbox,0,1);
        removehallpane.add(ok,1,2);
        removehallpane.add(back,0,2);

        ok.setOnAction(event -> {
            if(movie.hallArrayList.size() != 0){
                int index = Hall.hallnames.indexOf(removefilmbox.getValue());
                Hall hall = Hall.hallArrayList.get(index);

                for (Seat[] seat : hall.seats) {
                    for (Seat seat1 : seat) {
                        Seat.seatArrayList.remove(seat1);
                    }
                }

                Hall.hallnames.remove(hall.hallname);

                movie.hallArrayList.remove(hall.hallname);
                Hall.hallArrayList.remove(hall);
                selecthall.getItems().clear();

                if(movie.hallArrayList.size() != 0){
                    removefilmbox.setValue(movie.hallArrayList.get(0));
                }

                ObservableList<String> items= FXCollections.observableArrayList(movie.hallArrayList);
                removefilmbox.getItems().clear();
                removefilmbox.getItems().addAll(items);
                if(removefilmbox.getItems().size() != 0){
                    removefilmbox.setValue(removefilmbox.getItems().get(0));
                }


                selecthall.getItems().addAll(items);

            }

        });
        back.setOnAction(event -> {
            if(movie.hallArrayList.size() != 0){
                selecthall.getItems().addAll(itemshall);
                selecthall.setValue(movie.hallArrayList.get(0));
                iszero = true;
            }
            else {
                selecthall.getItems().clear();
                iszero = false;
            }
            primaryStage.setScene(scene5);
        });
        Scene scene = new Scene(removehallpane);
        return scene;
    }































}
