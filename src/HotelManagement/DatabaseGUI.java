package HotelManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.*;

/*****************************************************************
 DatabaseGUI is the code that runs the Java FX file so the gui can
 be displayed. Currently we have to Gui set up for quick and easy
 testing. This will be more user friendly in the next release.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/

public class DatabaseGUI extends Application {

    public static Stage table = new Stage();
    public static Stage mainView = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        table.setTitle("Hotel Actual Database v2");
        table.setScene(new Scene(root1, 1500, 800));
        table.hide();

        Parent root2 = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        mainView.setTitle("Hotel Database v1");
        mainView.setScene(new Scene(root2, 800, 400));
        mainView.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}