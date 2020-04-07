package HotelManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*****************************************************************
 DatabaseGUI is the code that runs the Java FX file so the gui can
 be displayed. Currently we have to Gui set up for quick and easy
 testing. This will be more user friendly in the next release.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/

public class DatabaseGUI extends Application {

    public static Stage table = new Stage();

    public static Parent root1;
    public static Parent root2;

    public static Scene sceneAdmin;
    public static Scene sceneTable;

    static {
        try {
            root1 = FXMLLoader.load(DatabaseGUI.class.getResource("TableView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            root2 = FXMLLoader.load(DatabaseGUI.class.getResource("adminLoginScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(final Stage primaryStage) throws Exception{
        sceneAdmin = new Scene(root2, 1000, 600);
        sceneTable = new Scene(root1, 1210, 800);
        table.setTitle("Admin Login Screen");
        table.setScene(sceneAdmin);
        table.show();
    }


    public static void main(final String[] args) {
        launch(args);
    }
}