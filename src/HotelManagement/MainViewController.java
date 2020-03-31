package HotelManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.mainView;


public class MainViewController {

    // When this method is called, it will change the scene to a table
    // view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
        mainView.hide();
        table.show();
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
