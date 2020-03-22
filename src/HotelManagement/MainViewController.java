package HotelManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    // When this method is called, it will change the scene to a table
    // view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        Scene tableViewScene =  new Scene(tableView);

        // This line gets the stage information.
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void pressButton(ActionEvent event){
        System.out.println("Hello World");
    }

    public void exitButton(ActionEvent event){
        System.exit(0);
    }

    public void createDB(ActionEvent event){
        Database d = new Database();
    }

}
