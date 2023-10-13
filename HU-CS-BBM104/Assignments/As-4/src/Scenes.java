import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Scenes{


    public static Scene girisscene(Stage primaryStage,MediaPlayer player, Image empty_seat,Image reserved_seat){

        TextField username = new TextField();
        Button signup = new Button("SIGN UP");
        Button login = new Button("LOG IN");
        PasswordField passwordField = new PasswordField();
        PasswordField passwordField1 = new PasswordField();
        Label welcome = new Label("Welcome to the HUCS Cinema Reservation System!\nPlease enter your credentials below and click LOGIN.\nYou can create a new account by clicking SIGN UP button");
        welcome.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR,15));
        GridPane girispane = new GridPane();
        GridPane maingridpane = new GridPane();
        maingridpane.add(welcome,0,0);
        welcome.setAlignment(Pos.TOP_CENTER);
        maingridpane.setAlignment(Pos.CENTER);
        girispane.setHgap(5);
        girispane.setVgap(5);
        girispane.add(new Label("Username:"), 0, 1);
        girispane.add(username, 1, 1);
        girispane.add(new Label("Password:"), 0, 2);
        girispane.add(passwordField, 1, 2);
        girispane.setAlignment(Pos.CENTER);
        girispane.add(signup, 0, 3);
        girispane.add(login, 1, 3);
        GridPane.setHalignment(login, HPos.RIGHT);
        maingridpane.add(girispane,0,1);
        Scene girisscene = new Scene(maingridpane, 400, 400);

        login.setOnAction(event -> {
            Label welcomeuser = new Label("");

            if(User.usersname.contains(username.getText())){

                int userindex = User.usersname.indexOf(username.getText());
                User user = User.users.get(userindex);
                Scene movieselect = Scenes.movieselect(primaryStage,girisscene,player,user,passwordField,username,welcomeuser,userindex,empty_seat,reserved_seat);
                if(User.loguserban){
                    Label error = new Label("ERROR: Please wait until end of the 5 seconds to make operation!");
                    username.clear();
                    passwordField1.clear();
                    passwordField.clear();

                    maingridpane.getChildren().clear();
                    maingridpane.add(welcome,0,0);
                    maingridpane.add(girispane,0,1);
                    maingridpane.add(error,0,2);

                    player.stop();
                    player.play();
                }
                else if(!User.hashpass(passwordField.getText()).equals(user.getPassword())){
                    Main.errortime++;

                    Label error = new Label("ERROR: There is no such credential!");
                    username.clear();
                    passwordField1.clear();
                    passwordField.clear();
                    maingridpane.getChildren().clear();
                    maingridpane.add(welcome,0,0);
                    maingridpane.add(girispane,0,1);
                    maingridpane.add(error,0,2);


                    player.stop();
                    player.play();

                }
                else {
                    Main.errortime = 0;
                    username.clear();
                    passwordField1.clear();
                    passwordField.clear();
                    maingridpane.getChildren().clear();
                    maingridpane.add(welcome,0,0);
                    maingridpane.add(girispane,0,1);
                    primaryStage.setScene(movieselect);
                }




            }
            else if(!User.usersname.contains(username.getText()) && !User.loguserban){
                Label error = new Label("ERROR: There is no such credential!");
                username.clear();
                passwordField1.clear();
                passwordField.clear();
                maingridpane.getChildren().clear();
                maingridpane.add(welcome,0,0);
                maingridpane.add(girispane,0,1);
                maingridpane.add(error,0,2);


                player.stop();
                player.play();
                Main.errortime++;
            }
            else if (!User.usersname.contains(username.getText()) && User.loguserban){
                Label error = new Label("ERROR: Please wait until end of the 5 seconds to make operation!");

                username.clear();
                passwordField1.clear();
                passwordField.clear();
                maingridpane.getChildren().clear();
                maingridpane.add(welcome,0,0);
                maingridpane.add(girispane,0,1);
                maingridpane.add(error,0,2);


                player.stop();
                player.play();
                Main.errortime++;
            }
            if(Main.errortime == PropertyReader.getMaxerror()-1){
                new TimeCounter();
            }

        });
        Scene signupscene = Scenes.signupscene(girisscene,player,primaryStage);

        signup.setOnAction(event -> {

            ////////////////butona tıklayınca signup ekranına gidiyoruz
            primaryStage.setScene(signupscene);




        });
        return girisscene;
    }




    public static Scene signupscene(Scene girisscene, MediaPlayer player, Stage primaryStage){
        TextField username1 = new TextField();
        Button signup1 = new Button("SIGN UP");
        Button login1 = new Button("LOG IN");
        PasswordField passwordField1_1 = new PasswordField();
        PasswordField passwordField11 = new PasswordField();

        Label welcome1 = new Label("Welcome to the HUCS Cinema Reservation System!\nPlease enter your credentials below and click LOGIN.\nYou can create a new account by clicking SIGN UP button");
        welcome1.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR,15));
        GridPane signup_pane_1 = new GridPane();
        GridPane signuppane = new GridPane();
        signuppane.add(welcome1,0,0);
        welcome1.setAlignment(Pos.TOP_CENTER);
        signuppane.setAlignment(Pos.CENTER);
        signup_pane_1.setHgap(5);
        signup_pane_1.setVgap(5);
        signup_pane_1.add(new Label("Username:"), 0, 1);
        signup_pane_1.add(username1, 1, 1);
        signup_pane_1.add(new Label("Password:"), 0, 2);
        signup_pane_1.add(passwordField11, 1, 2);
        signup_pane_1.add(new Label("Password:"), 0, 3);
        signup_pane_1.add(passwordField1_1,1,3);
        signup_pane_1.setAlignment(Pos.CENTER);
        signup_pane_1.add(signup1, 0, 4);
        signup_pane_1.add(login1, 1, 4);
        GridPane.setHalignment(login1, HPos.RIGHT);
        signuppane.add(signup_pane_1,0,1);
        Scene signupscene = new Scene(signuppane, 400, 400);
        signup1.setOnAction(e -> {

            Label error = new Label("ERROR: this username already exists!");
            if(User.usersname.contains(username1.getText())){
                username1.clear();
                passwordField1_1.clear();
                passwordField11.clear();
                signuppane.getChildren().clear();
                signuppane.add(welcome1,0,0);
                signuppane.add(signup_pane_1,0,1);
                signuppane.add(error,0,2);
                player.stop();
                player.play();
            }else if(username1.getText().equals("")){

                error.setText("ERROR: Username cannot be empty");
                username1.clear();
                passwordField1_1.clear();
                passwordField11.clear();
                signuppane.getChildren().clear();
                signuppane.add(welcome1,0,0);
                signuppane.add(signup_pane_1,0,1);
                signuppane.add(error,0,2);

                player.play();
                player.stop();
                player.play();
            }
            else if(!passwordField1_1.getText().equals(passwordField11.getText())){

                error.setText("ERROR: Passwords are not match");
                username1.clear();
                passwordField1_1.clear();
                passwordField11.clear();
                signuppane.getChildren().clear();
                signuppane.add(welcome1,0,0);
                signuppane.add(signup_pane_1,0,1);
                signuppane.add(error,0,2);

                player.stop();
                player.play();
            }
            else if(passwordField1_1.getText().equals("") || passwordField11.getText().equals("")){

                error.setText("ERROR: Password cannot be empty");
                username1.clear();
                passwordField1_1.clear();
                passwordField11.clear();
                signuppane.getChildren().clear();
                signuppane.add(welcome1,0,0);
                signuppane.add(signup_pane_1,0,1);
                signuppane.add(error,0,2);

                player.stop();
                player.play();
            }else{
                error = new Label("SUCCESS:You have successfully registered with your new credentials!");
                signuppane.getChildren().clear();
                signuppane.add(welcome1,0,0);
                signuppane.add(signup_pane_1,0,1);
                signuppane.add(error,0,2);
                String pass = User.hashpass(passwordField11.getText());
                User user = new User(username1.getText(),false,false,pass);



            }



        });

        login1.setOnAction(e -> primaryStage.setScene(girisscene));
        return signupscene;
    }





    public static Scene movieselect( Stage primaryStage,Scene girisscene,MediaPlayer player,User user,PasswordField passwordField,TextField username,Label welcomeuser,int a, Image empty_seat,Image reserved_seat){

        GridPane movieselect = new GridPane();
        GridPane movieselect2 = new GridPane();
        GridPane movieselect3 = new GridPane();
        ComboBox<String> movies = new ComboBox<>();
        movieselect.setAlignment(Pos.CENTER);
        movieselect2.setHgap(5);
        movieselect2.setVgap(5);
        movieselect3.setHgap(5);
        movieselect3.setVgap(5);
        if(Movie.movienames.size() != 0){
            movies.setValue(Movie.movienames.get(0));
        }

        Button log_out = new Button("LOG OUT");
        Button ok = new Button("OK");
        Button edit_user = new Button("Edit User");
        Button add_film = new Button("Add Film");
        Button remove_film = new Button("Remove Film");
        log_out.setOnAction(event -> primaryStage.setScene(girisscene));
        ObservableList<String> movie_items =
                FXCollections.observableArrayList(Movie.movienames);
        movieselect2.add(movies,1,2);
        movieselect2.add(ok,2,2);
        movieselect3.add(edit_user,3,3);
        movieselect3.add(add_film,1,3);
        movieselect3.add(remove_film,2,3);
        movieselect3.add(log_out,3,4);
        movies.getItems().addAll(movie_items);
        movieselect.add(movieselect2,0,1);
        movieselect.add(movieselect3,0,2);
        Scene movie_choice_scene = new Scene(movieselect, 500, 500);
        GridPane.setHalignment(log_out, HPos.RIGHT);


        add_film.setOnAction(event -> {
            Scene addfilmscene = Sceneseditfilm.addilmsecene(player, primaryStage, movieselect2, movies,movie_choice_scene,ok);
            primaryStage.setScene(addfilmscene);
        });

        if(!User.loguserban && !user.isAdmin() && User.hashpass(passwordField.getText()).equals(user.getPassword()) && !user.isClubmember()){
            User.isadmin = false;
            User.logusername = username.getText();
            movieselect2.getChildren().clear();
            movies.getItems().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);

            movieselect.getChildren().clear();
            movieselect.add(movieselect2,0,1);
            movieselect.add(movieselect3,0,2);
            edit_user.setVisible(false);
            add_film.setVisible(false);
            remove_film.setVisible(false);
            String message = "Welcome " + User.usersname.get(a) + " you can select film below";
            welcomeuser = new Label(message);
            welcomeuser.setAlignment(Pos.TOP_CENTER);
            movieselect.add(welcomeuser,0,0);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }

            primaryStage.setScene(movie_choice_scene);
        }
        else if(!User.loguserban && !user.isAdmin() && User.hashpass(passwordField.getText()).equals(user.getPassword()) && user.isClubmember()){
            User.isadmin = false;
            User.logusername = username.getText();
            movieselect2.getChildren().clear();
            movies.getItems().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);

            movieselect.getChildren().clear();
            movieselect.add(movieselect2,0,1);
            movieselect.add(movieselect3,0,2);
            edit_user.setVisible(false);
            add_film.setVisible(false);
            remove_film.setVisible(false);
            String message = "Welcome " + User.usersname.get(a) + "(Club Member) you can select film below";
            welcomeuser = new Label(message);
            welcomeuser.setAlignment(Pos.TOP_CENTER);
            movieselect.add(welcomeuser,0,0);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }

            primaryStage.setScene(movie_choice_scene);
        }else if(!User.loguserban && user.isAdmin() && User.hashpass(passwordField.getText()).equals(user.getPassword()) && !user.isClubmember()){
            User.logusername = username.getText();
            User.isadmin = true;
            movies.getItems().clear();
            movieselect2.getChildren().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);
            movieselect.getChildren().clear();
            movieselect.add(movieselect2,0,1);
            movieselect.add(movieselect3,0,2);
            edit_user.setVisible(true);
            add_film.setVisible(true);
            remove_film.setVisible(true);
            String message = "Welcome " + User.usersname.get(a) + "(Admin)!\n You can either select film below or do edits";
            welcomeuser = new Label(message);
            movieselect.add(welcomeuser,0,0);
            welcomeuser.setAlignment(Pos.TOP_CENTER);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }

            primaryStage.setScene(movie_choice_scene);
        }
        else if(!User.loguserban && user.isAdmin() && User.hashpass(passwordField.getText()).equals(user.getPassword())){
            User.logusername = username.getText();
            User.isadmin = true;
            movies.getItems().clear();
            movieselect2.getChildren().clear();
            ObservableList<String> items1 =
                    FXCollections.observableArrayList(Movie.movienames);
            movies.getItems().addAll(items1);
            movieselect2.add(movies,1,2);
            movieselect2.add(ok,2,2);
            movieselect.getChildren().clear();
            movieselect.add(movieselect2,0,1);
            movieselect.add(movieselect3,0,2);
            edit_user.setVisible(true);
            add_film.setVisible(true);
            remove_film.setVisible(true);
            String message = "Welcome " + User.usersname.get(a) + "(Admin-Club Member)!\n You can either select film below or do edits";
            welcomeuser = new Label(message);
            movieselect.add(welcomeuser,0,0);
            welcomeuser.setAlignment(Pos.TOP_CENTER);
            if(Movie.movienames.size() != 0){
                movies.setValue(Movie.movienames.get(0));
            }

            primaryStage.setScene(movie_choice_scene);
        }


        remove_film.setOnAction(event -> {
            primaryStage.setScene(Sceneseditfilm.removefilmscene(primaryStage,movieselect2, movies,movie_choice_scene,ok));
        });


        edit_user.setOnAction(event -> {
            Scene edituserscene = edituser(primaryStage,movie_choice_scene);
            primaryStage.setScene(edituserscene);
        });

        ok.setOnAction(event -> {
            if(Movie.movienames.size() != 0){
                primaryStage.setScene(Sceneseditfilm.playtrailerscene(player,primaryStage,movieselect2, movies, movie_choice_scene,empty_seat,reserved_seat));
            }

        });


        return movie_choice_scene;
    }


    public static Scene edituser(Stage primaryStage,Scene movie_choice_scene){
        BorderPane edituserpane = new BorderPane();
        TableView<User> table = new TableView<User>();
        TableColumn<User,String> table_name = new TableColumn<>("Username");
        TableColumn<User, Boolean> table_admin =new TableColumn<>("Admin");
        TableColumn<User, Boolean> table_clubmember = new TableColumn<>("Club Member");
        table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        table_admin.setCellValueFactory(new PropertyValueFactory<>("admin"));
        table_clubmember.setCellValueFactory(new PropertyValueFactory<>("clubmember"));
        table.setEditable(true);
        Button denoteadmin = new Button("Promote/Denote Admin");
        Button denotemember = new Button("Promote/Denote Club Member");
        Button backedituser = new Button("<Back");
        HBox hbox_editbuttons = new HBox();
        edituserpane.setPadding(new Insets(20, 20, 20, 20));
        hbox_editbuttons.setSpacing(10);
        hbox_editbuttons.getChildren().addAll(backedituser,denotemember,denoteadmin);
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.addAll(User.users);
        int index = User.usersname.indexOf(User.logusername);
        userArrayList.remove(index);
        userObservableList.addAll(userArrayList);
        table.setItems(userObservableList);
        table.requestFocus();
        table.getSelectionModel().select(0);
        table.getFocusModel().focus(0);

        ////////////////////
        ////////////////////edit user dan cıkma butonu
        backedituser.setOnAction(event1 -> {
            primaryStage.setScene(movie_choice_scene);
        });


        ////////////////////
        ////////////////////admin ayarlama butonu
        denoteadmin.setOnAction(event1 -> {
            User user = table.getSelectionModel().getSelectedItem();
            if(user.isAdmin()){
                user.setAdmin(false);
            }
            else {
                user.setAdmin(true);
            }

            table.getColumns().get(0).setVisible(false);
            table.getColumns().get(0).setVisible(true);
            table.requestFocus();
            table.getSelectionModel().select(userArrayList.indexOf(user));
            table.getFocusModel().focus(userArrayList.indexOf(user));
        });


        ////////////////////
        ////////////////////Clubmember ayarlama butonu
        denotemember.setOnAction(event1 -> {
            User user = table.getSelectionModel().getSelectedItem();
            if(user.isClubmember()){
                user.setClubmember(false);
            }
            else {
                user.setClubmember(true);
            }
            table.getColumns().get(0).setVisible(false);
            table.getColumns().get(0).setVisible(true);
            table.requestFocus();
            table.getSelectionModel().select(userArrayList.indexOf(user));
            table.getFocusModel().focus(userArrayList.indexOf(user));
        });

        table.getColumns().addAll(table_name,table_clubmember,table_admin);
        edituserpane.setCenter(table);
        edituserpane.setBottom(hbox_editbuttons);
        Scene edituserscene = new Scene(edituserpane,500,500);
        return  edituserscene;
    }


}
