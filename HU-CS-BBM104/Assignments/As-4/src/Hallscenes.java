import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Hallscenes {




    public static Scene addhallscene(MediaPlayer movieplayer, Movie movie, Stage primaryStage,Scene scene5,MediaPlayer player,ComboBox<String> selecthall ){
        movieplayer.stop();
        GridPane labelpane = new GridPane();
        Button back_trailer = new Button("< Back");
        Button ok_makehall = new Button("OK");
        Label row =new Label("Row :");
        Label column =new Label("Column :");
        Label name_hall =new Label("Name :");
        Label price_ticket =new Label("Price :");
        Label filmname = new Label(movie.name +" ("+movie.duration+")");
        labelpane.add(filmname,0,0);
        labelpane.setAlignment(Pos.CENTER);
        filmname.setAlignment(Pos.TOP_CENTER);
        ComboBox<Integer> selectrow = new ComboBox<>();
        ComboBox<Integer> selectcolumn = new ComboBox<>();
        TextField name_hall_field = new TextField();
        TextField price_ticket_field = new TextField();
        ArrayList<Integer> numbers_hall = new ArrayList<>();

        for (int i = 3; i <11 ; i++) {
            numbers_hall.add(i);
        }

        ObservableList<Integer> hall_items = FXCollections.observableArrayList(numbers_hall);
        selectcolumn.getItems().addAll(hall_items);
        selectrow.getItems().addAll(hall_items);
        selectcolumn.setValue(hall_items.get(0));
        selectrow.setValue(hall_items.get(0));
        GridPane addhallpane = new GridPane();
        addhallpane.add(row,0,1);
        addhallpane.add(selectrow,1,1);
        addhallpane.add(column,0,2);
        addhallpane.add(selectcolumn,1,2);
        addhallpane.add(back_trailer,0,5);
        addhallpane.add(ok_makehall,1,5);
        addhallpane.add(name_hall,0,3);
        addhallpane.add(name_hall_field,1,3);
        addhallpane.add(price_ticket,0,4);
        addhallpane.add(price_ticket_field,1,4);
        labelpane.add(addhallpane,0,1);
        addhallpane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(selectcolumn, HPos.CENTER);
        GridPane.setHalignment(selectrow, HPos.CENTER);
        GridPane.setHalignment(name_hall_field, HPos.CENTER);
        GridPane.setHalignment(price_ticket_field, HPos.CENTER);
        GridPane.setHalignment(ok_makehall, HPos.RIGHT);
        addhallpane.setVgap(10);
        Scene addhallscene = new Scene(labelpane,400,400);
        primaryStage.setScene(addhallscene);

        ////////////////////yeni hall yapımı onaylama butonu ayarı
        ok_makehall.setOnAction(event -> {
            Label error = new Label();
            int row_number = selectrow.getValue();
            int column_number = selectcolumn.getValue();
            if(name_hall_field.getText().equals("")){
                error.setText("ERROR: Hall name could not be empty!");
                labelpane.getChildren().clear();
                labelpane.add(filmname,0,0);
                labelpane.add(addhallpane,0,1);

                labelpane.add(error,0,2);
                player.stop();
                player.play();
            }
            else if(Hall.hallnames.contains(name_hall_field.getText())){
                error.setText("ERROR: Hall name already taken!");
                labelpane.getChildren().clear();
                labelpane.add(filmname,0,0);
                labelpane.add(addhallpane,0,1);

                labelpane.add(error,0,2);
                player.stop();
                player.play();
            }
            else if(price_ticket_field.getText().equals("")){

                error.setText("ERROR: Price could not be empty!");
                labelpane.getChildren().clear();
                labelpane.add(filmname,0,0);
                labelpane.add(addhallpane,0,1);
                labelpane.add(error,0,2);
                player.stop();
                player.play();
            }
            else if(!ReadFile.isNumeric(price_ticket_field.getText())){
                error.setText("ERROR: Price should be integer");
                labelpane.getChildren().clear();
                labelpane.add(filmname,0,0);
                labelpane.add(addhallpane,0,1);
                labelpane.add(error,0,2);
                player.stop();
                player.play();
            }
            else {
                error.setText("SUCCESS: Hall successfully created!");

                labelpane.getChildren().clear();
                labelpane.add(filmname,0,0);
                labelpane.add(addhallpane,0,1);
                labelpane.add(error,0,2);
                Hall hall =new Hall(movie.name,name_hall_field.getText(),Integer.parseInt(price_ticket_field.getText()),row_number,column_number);
                movie.hallArrayList.add(hall.hallname);
                ObservableList<String> itemshall = FXCollections.observableArrayList(movie.hallArrayList);
                selecthall.getItems().clear();
                selecthall.getItems().addAll(itemshall);
                if(movie.hallArrayList.size() != 0){
                    selecthall.setValue(movie.hallArrayList.get(0));
                }
                for (int i = 0; i < row_number; i++) {
                    for (int j = 0; j < column_number; j++) {
                        new Seat(movie.name,hall.hallname,i,j,"null",0);
                    }
                }


            }


        });

        //////////////////////trailer izleme yerine geri dönme butonu
        back_trailer.setOnAction(event -> {
            if(movie.hallArrayList.size() != 0){
                selecthall.setValue(movie.hallArrayList.get(0));
            }
            else {
                selecthall.getItems().clear();
            }
            primaryStage.setScene(scene5);
        });

        return addhallscene;
    }


    public static Scene makehall(Image empty_seat, Image reserved_seat, ComboBox<String> selecthall,Stage primaryStage,Scene scene5,Movie movie){

        GridPane hallgridpane = new GridPane();
        Button backhall_button = new Button("back");
        BorderPane hall_mainpane = new BorderPane();

        ComboBox<String> userstobuy = new ComboBox<>();
        userstobuy.setValue(User.usersname.get(0));
        ObservableList<String> userlist = FXCollections.observableArrayList(User.usersname);
        userstobuy.getItems().addAll(userlist);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);

        Scene hallscene = new Scene(vBox);
        String hallname = selecthall.getValue();
        int indexhall = Hall.hallnames.indexOf(hallname);
        Hall hall = Hall.hallArrayList.get(indexhall);
        int xhall = hall.column;
        int yhall = hall.row;
        Label filmname = new Label(movie.name +" ("+movie.duration+" minutes) Hall: " + hallname);
        vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,backhall_button);

        if(User.isadmin){
            userstobuy.setVisible(true);
        }
        else {
            userstobuy.setVisible(false);
        }

        hallgridpane.setVgap(10);
        hallgridpane.setHgap(10);
        hallgridpane.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20,20,20,20));
        Label buy_or_refund = new Label("");
        for (int i = 0; i < yhall; i++) {
            for (int j = 0; j < xhall; j++) {
                javafx.scene.image.ImageView a3 =  new javafx.scene.image.ImageView();
                a3.setFitWidth(50);
                a3.setFitHeight(50);
                if(hall.seats[i][j].user == null){
                    a3.setImage(empty_seat);
                }
                else if(User.isadmin){
                    a3.setImage(reserved_seat);
                }
                else if(hall.seats[i][j].user.getName().equals(User.logusername)){
                    a3.setImage(reserved_seat);
                }
                else {
                    a3.setImage(reserved_seat);
                    a3.setBlendMode(BlendMode.ADD);
                }

                hallgridpane.add(a3,j,i);
                Label buyname = new Label("");


                if(User.isadmin || hall.seats[i][j].user == null || hall.seats[i][j].user.getName().equals(User.logusername)){
                    int finalJ1 = j;
                    int finalI1 = i;
                    int finalJ3 = j;
                    int finalI3 = i;
                    int finalI4 = i;
                    int finalJ4 = j;
                    a3. addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event11 -> {
                        javafx.scene.image.ImageView b1 =  new javafx.scene.image.ImageView();
                        b1.setFitWidth(50);
                        b1.setFitHeight(50);
                        if(a3.getImage().equals(empty_seat)){
                            if(User.isadmin){
                                int indexuser = User.usersname.indexOf(userstobuy.getValue());
                                int index1 = finalI1+1;
                                int index2 = finalJ1+1;
                                if(!User.users.get(indexuser).isClubmember()){
                                    hall.seats[finalI3][finalJ3].price = hall.price;

                                    buy_or_refund.setText("Seat at "+index1+"-"+index2+" is bought for "+User.usersname.get(indexuser)+" for "+hall.price +" TL successfully!");
                                }
                                else {
                                    int priceticket = hall.price*(100-Integer.parseInt(PropertyReader.getDiscountpercentage()))/100;
                                    hall.seats[finalI3][finalJ3].price = priceticket;
                                    buy_or_refund.setText("Seat at "+index1+"-"+index2+" is bought for "+User.usersname.get(indexuser)+" for "+priceticket +" TL successfully!");
                                }


                                hall.seats[finalI3][finalJ3].user = User.users.get(indexuser);
                                buyname.setText("Bought by "+hall.seats[finalI3][finalJ3].user.getName()+" for "+hall.seats[finalI3][finalJ3].price+" TL");
                                vBox.getChildren().clear();
                                vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,buyname,buy_or_refund,backhall_button);
                                buyname.setVisible(true);

                                a3.setImage(reserved_seat);

                            }
                            else {

                                int indexuser = User.usersname.indexOf(User.logusername);
                                int index1 =finalI3+1;
                                int index2 = finalJ1+1;
                                if(!User.users.get(indexuser).isClubmember()){
                                    hall.seats[finalI3][finalJ3].user = User.users.get(indexuser);
                                    hall.seats[finalI3][finalJ3].price = hall.price;
                                    buy_or_refund.setText("Seat at "+index1+"-"+index2+" is bought for "+User.usersname.get(indexuser)+" for "+hall.price +" TL successfully!");
                                }
                                else {

                                    int priceticket = hall.price*(100-Integer.parseInt(PropertyReader.getDiscountpercentage()))/100;
                                    hall.seats[finalI3][finalJ3].user = User.users.get(indexuser);
                                    hall.seats[finalI3][finalJ3].price = priceticket;
                                    buy_or_refund.setText("Seat at "+index1+"-"+index2+" is bought for "+User.usersname.get(indexuser)+" for "+priceticket +" TL successfully!");
                                }
                                buyname.setText("Bought by "+hall.seats[finalI3][finalJ3].user.getName()+" for "+hall.seats[finalI3][finalJ3].price+" TL");
                                hall.seats[finalI3][finalJ3].user = User.users.get(indexuser);


                                vBox.getChildren().clear();
                                vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,buyname,backhall_button);
                                buyname.setVisible(true);
                                a3.setImage(reserved_seat);
                            }


                        }
                        else {

                            int indexuser = User.usersname.indexOf(User.logusername);
                            buyname.setText("Bought by "+hall.seats[finalI3][finalJ3].user.getName()+"for "+hall.seats[finalI3][finalJ3].price+" TL");

                            buyname.setText(hall.seats[finalI4][finalJ4].user.getName());
                            hall.seats[finalI1][finalJ1].user = null;
                            hall.seats[finalI1][finalJ1].price = 0;
                            buyname.setText("Not bought yet!");
                            int index1 =finalI1+1;
                            int index2 = finalJ1+1;
                            buy_or_refund.setText("Seat at "+index1+"-"+index2+" is refunded successfully!");
                            a3.setImage(empty_seat);
                            vBox.getChildren().clear();
                            vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,buyname,buy_or_refund,backhall_button);
                        }

                    });
                }



                int finalJ = i;
                int finalI = j;

                if(hall.seats[finalJ][finalI].user == null){
                    buyname.setText("Not bought yet!");
                }
                else {
                    buyname.setText("Bought by "+hall.seats[i][j].user.getName()+" for "+hall.seats[i][j].price+" TL");
                }
                buyname.setVisible(false);
                int finalI2 = i;
                int finalJ2 = j;
                a3.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
                    if (a3.getImage().equals(reserved_seat)) {
                        vBox.getChildren().clear();
                        vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,buyname,buy_or_refund,backhall_button);
                        buyname.setVisible(true);
                    }
                    else if (a3.getImage().equals(empty_seat)) {
                        vBox.getChildren().clear();
                        vBox.getChildren().addAll(filmname,hallgridpane,userstobuy,buyname,buy_or_refund,backhall_button);
                        buyname.setVisible(true);
                    }
                });

            }
        }

        backhall_button.setOnAction(event -> {

            primaryStage.setScene(scene5);
        });
        return hallscene;
    }



}
