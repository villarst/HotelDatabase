package HotelManagement;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.mainView;



/**
 * Need to fix the table so it doesn't reset data every time we change scenes,
 * Also need to somehow get database involved so the table can display the room numbers.
 */
public class TableViewController implements Initializable {
    // Configure the table
    @FXML private TableView<User> tableView;
    @FXML private TableColumn<User, String> nameColumn;
    @FXML private TableColumn<User, String> phoneNumColumn;
    @FXML private TableColumn<User, String> emailColumn;
    @FXML private TableColumn<User, String> userNameColumn;
    @FXML private TableColumn<User, String> passwordColumn;
    @FXML private TableColumn<User, Integer> tierColumn;
    @FXML private TableColumn<User, String> dateofbirthColumn;
    @FXML private TableColumn<User, Integer> roomNum;

    // These variables are used to create new User Objects
    @FXML private TextField nameTextField;
    @FXML private TextField phoneNumTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField userNameTextField;
    @FXML private TextField dobTextField;


//    // Combobox for choosing tier level.
//    @FXML private ComboBox comboBox;

    Database d = new Database();

    public void changeNameColumn(TableColumn.CellEditEvent editedCell){
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        d.findUser(userSelected).setName(editedCell.getNewValue().toString());
        userSelected.setName(editedCell.getNewValue().toString());
    }

    public void changeEmailColumn(TableColumn.CellEditEvent editedCell){
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        if(d.findUser(userSelected).setEmail(editedCell.getNewValue().toString())){
            userSelected.setEmail(editedCell.getNewValue().toString());
        }
        else{
            // You have to click it or double click it then the email will be the original email in the gui.
            userSelected.setEmail(d.findUser(userSelected).getEmail());
        }
    }

    public void changePhoneNumColumn(TableColumn.CellEditEvent editedCell){
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        if(d.findUser(userSelected).setPhoneNum(editedCell.getNewValue().toString())){
            userSelected.setPhoneNum(editedCell.getNewValue().toString());
        }
        else{
            // You have to click it or double click it then the phone # will be the original phone # in the gui.
            userSelected.setPhoneNum(d.findUser(userSelected).getPhoneNum());
        }
    }

    // When this method is called, it will change the scene to a table view.
    public void changeScreenBtnPushed(ActionEvent event) throws IOException {
        table.hide();
        mainView.show();
    }

    // This method will create new User and add it to the table and database.
    public void newUserButtonPushed(){
        User u = new User(nameTextField.getText(),
                          phoneNumTextField.getText(),
                          emailTextField.getText(),
                          3, userNameTextField.getText(),
                          dobTextField.getText());

        // Verifies if email, phone #, and date of birth are valid, then adds the user to database then table.
        if(u.verifyAll(emailTextField.getText(), phoneNumTextField.getText(), dobTextField.getText())){
            d.addUser(u);
            tableView.getItems().add(u);
        }
        else{
            System.out.println("User was not added, check email, phone #, or date of birth.");
        }
    }

    public void deleteButtonPushed(){
        ObservableList<User> selectedRows, allPeople;
        allPeople = tableView.getItems();

        // This gives us the row that was selected.
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        // loop over the selected rows and remove the User Object from the table.
        // also removes the User and frees up the room for the database 'd'
        if(tableView.getItems().get(0) != null) {
            for (User u : selectedRows) {
                allPeople.remove(u);
                d.searchUser(u);
                System.out.println("Check");
            }
        }
        else{
            System.out.println("Sorry list is empty.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<Integer> tiersComboBox = FXCollections.observableArrayList(1, 2, 3);

        // Sets up the Columns in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<User, String>("PhoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        tierColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("tier"));
        dateofbirthColumn.setCellValueFactory(new PropertyValueFactory<User, String>("dob"));
        roomNum.setCellValueFactory(new PropertyValueFactory<User, Integer>("roomNum"));

//        // Sets up the combo box
//        comboBox.setValue(1);
//        comboBox.setItems(tiersComboBox);

        // load dummy data
        tableView.setItems(getUsers());

        // Update the table to allow for the Name, Email, and Phone # to be editable.
        tableView.setEditable(false);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    // This method will return an Observable list of User objects.
    public ObservableList<User> getUsers(){
        ObservableList<User> users = FXCollections.observableArrayList();
        d.addUser(new User("Steven", "6168342729", "villarst@mail.gvsu.edu", 1,
                "villarst", "03/27/00"));
        users.add(new User("Steven", "6168342729", "villarst@mail.gvsu.edu", 1,
                d.viewRoom(0), "villarst", d.getUser(0).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new User("Corey R", "6168342729", "ricecore@mail.gvsu.edu", 2,
                "villarst", "03/27/00"));
        users.add(new User("Corey R", "6165583079", "ricecore@mail.gvsu.edu", 2,
                d.viewRoom(1), "villarst", d.getUser(1).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new User("Corey S", "6168342729", "sutterco@mail.gvsu.edu", 2,
                "villarst", "03/27/00"));
        users.add(new User("Corey S", "6165583079", "cutterco@mail.gvsu.edu", 2,
                d.viewRoom(2), "villarst", d.getUser(2).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new User("Jason", "6168342729", "kaipjaso@mail.gvsu.edu", 3,
                "villarst", "03/27/00"));
        users.add(new User("Jason", "6165583079", "kaipjaso@mail.gvsu.edu", 3,
                d.viewRoom(3), "villarst", d.getUser(3).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new User("Bobby V", "6168342729", "vuerbobb@mail.gvsu.edu", 1,
                "villarst", "03/27/00"));
        users.add(new User("Bobby V", "6165583079", "vuerbobb@mail.gvsu.edu", 1,
                d.viewRoom(4), "villarst", d.getUser(4).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new User("Mike J", "6168342729", "johnmike@mail.gvsu.edu", 3,
                "villarst", "03/27/00"));
        users.add(new User("Mike J", "6165583079", "johnmike@mail.gvsu.edu", 3,
                d.viewRoom(5), "villarst", d.getUser(5).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        users.add(new User("ADMIN", "9999999999", "admin@login.com", "ADMIN", 0, "04/23/29"));
        System.out.println("Admin Tier level: " + users.get(6).getTier());
        return users;
    }
}

