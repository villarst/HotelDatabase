package HotelManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DatabaseGUI extends Application {

    Button button;

    public static void main(String[]args){
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DatabaseGUI.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}