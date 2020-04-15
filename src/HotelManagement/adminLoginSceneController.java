package HotelManagement;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static HotelManagement.DatabaseGUI.*;
import static HotelManagement.TableViewController.*;


public class adminLoginSceneController implements Initializable {

  public static boolean adminLoggedIn;
  @FXML public TextField passwordTextField;
  @FXML public TextField usernameTextField;

  public void alertError(ActionEvent event){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Login Credentials Incorrect");
    alert.showAndWait();
  }

  public void loginAdmin(ActionEvent event){
    if(adminLoggedIn == false) {
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
        }
        else{
          alertError(event);
        }
      }
    }
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
