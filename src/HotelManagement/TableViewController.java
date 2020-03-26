package HotelManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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

    Database d = new Database();

    // Right Here
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
        Parent tableView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene tableViewScene =  new Scene(tableView);

        // This line gets the stage information.
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets up the Columns in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<User, String>("PhoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        tierColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("tier"));
        dateofbirthColumn.setCellValueFactory(new PropertyValueFactory<User, String>("dob"));
        roomNum.setCellValueFactory(new PropertyValueFactory<User, Integer>("roomNum"));
        // load dummy data
        tableView.setItems(getUsers());

        // Update the table to allow for the Name, Email, and Phone # to be editable.
        tableView.setEditable(true);
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
        return users;
    }
}

