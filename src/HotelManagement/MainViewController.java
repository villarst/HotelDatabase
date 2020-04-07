package HotelManagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.mainView;
import static HotelManagement.TableViewController.d;



public class MainViewController {
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;
    @FXML private Text lblAdminLogin;
    @FXML private Button btnLoginAdmin;

    public static boolean adminLoggedIn = false;

    // When this method is called, it will change the scene to a table
    // view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
    }

    // this logins the Admin only. may modify to login a user maybe..
    public void loginAdmin(){
        if(adminLoggedIn == false) {
            for (int i = 0; i < d.secondaryDbSize(); i++) {
                if (d.searchSecondary(passwordTextField.getText())) {
                    usernameTextField.clear();
                    passwordTextField.clear();
                    usernameTextField.setVisible(false);
                    passwordTextField.setVisible(false);
                    lblAdminLogin.setVisible(false);
                    btnLoginAdmin.setText("Logout");
                    adminLoggedIn = true;
                    mainView.hide();
                    table.show();
                    return;
                }
            }
        }
        else{
            usernameTextField.setVisible(true);
            passwordTextField.setVisible(true);
            lblAdminLogin.setVisible(true);
            btnLoginAdmin.setText("Login");
            adminLoggedIn = false;
            return;
        }
    }

    public void exitButton(ActionEvent event){
        System.exit(0);
    }
}
