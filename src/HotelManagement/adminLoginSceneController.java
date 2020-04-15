package HotelManagement;

import static HotelManagement.DatabaseGUI.sceneTable;
import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.TableViewController.d; //NOPMD

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

  /** Text fields for entering the password. */
  @FXML public TextField passwordTextField; //NOPMD

  /** Text fields for entering the username. */
  @FXML public TextField usernameTextField; //NOPMD


  /*****************************************************************
  Method used to display an error message.
  *****************************************************************/
  public void alertError(final ActionEvent event) {
    final Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Login Credentials Incorrect");
    alert.showAndWait();
  }

  /*****************************************************************
  Method used to detrmine if the Admin has logged in.
  *****************************************************************/
  public void loginAdmin(final ActionEvent event) {
    if (!adminLoggedIn) {
      for (int i = 0; i < d.secondaryDbSize(); i++) {
        if (d.searchSecondary(passwordTextField.getText())) {
          usernameTextField.clear();
          passwordTextField.clear();
          usernameTextField.setVisible(true);
          passwordTextField.setVisible(true);
          adminLoggedIn = true;
          table.setScene(sceneTable);
          table.setTitle("Database Screen");
          return;
        } else {
          alertError(event);
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
