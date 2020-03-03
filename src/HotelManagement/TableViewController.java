package HotelManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TableViewController {

    // When this method is called, it will change the scene to a table
    // view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
        Parent tableView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene tableViewScene =  new Scene(tableView);

        // This line gets the stage information.
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}

