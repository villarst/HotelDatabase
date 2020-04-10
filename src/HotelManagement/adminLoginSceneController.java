package HotelManagement;

import static HotelManagement.DatabaseGUI.sceneTable;
import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.TableViewController.d; //NOPMD

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/*****************************************************************
 A class that is used to control the functionality in the
 adminLoginScene.fxml
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 ****************************************************************/


public class adminLoginSceneController implements Initializable { //NOPMD

    /** Boolean variable to determine if the admin is logged in. */
    public static boolean adminLoggedIn;

    /** FX button for the admin login screen. */
    @FXML public Button btnLoginAdmin;

    /** Text fields for entering the password. */
    @FXML public transient TextField passwordTextField;

    /** Text fields for entering the username. */
    @FXML public transient TextField usernameTextField;


    /*****************************************************************
     Method used to detrmine if the Admin has logged in.
     *****************************************************************/
    public void loginAdmin() {
        if (!adminLoggedIn) {
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


    /*****************************************************************
     Method used to detrmine if the Admin has logged in.
     @param url FXML URL
     @param resourceBundle FXML resource bundle
     *****************************************************************/
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) { //NOPMD

    }
}