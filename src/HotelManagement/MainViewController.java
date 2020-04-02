package HotelManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.mainView;



public class MainViewController {
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;

    // When this method is called, it will change the scene to a table
    // view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
        mainView.hide();
        table.show();
    }

    public void exitButton(ActionEvent event){
        System.exit(0);
    }
}
