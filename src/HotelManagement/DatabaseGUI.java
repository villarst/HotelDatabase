package HotelManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

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