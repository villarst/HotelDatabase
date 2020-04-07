package HotelManagement;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.sceneTable;
import static HotelManagement.TableViewController.d;


public class adminLoginSceneController implements Initializable {

    public static boolean adminLoggedIn;
    @FXML public Button btnLoginAdmin;
    @FXML public TextField passwordTextField;
    @FXML public TextField usernameTextField;


    public void loginAdmin(){
        if(!adminLoggedIn) {
            for (int i = 0; i < d.secondaryDbSize(); i++) {
                if (d.searchSecondary(passwordTextField.getText())) {
                    usernameTextField.clear();
                    passwordTextField.clear();
                    usernameTextField.setVisible(true);
                    passwordTextField.setVisible(true);
                    adminLoggedIn = true;
                    table.setScene(sceneTable);
                    return;
                }
            }
        }
    }


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

    }
}
