package hotelmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static hotelmanagement.databaseGUI.*;
import static hotelmanagement.adminLoginSceneController.adminLoggedIn;


/*****************************************************************
 A class that is used to control the functionality in the
 adminLoginScene.fxml
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 ****************************************************************/

public class tableViewController implements Initializable {

    @FXML public TableView<user> tableView;
    @FXML public ObservableList<user> users;
    @FXML private TableColumn<user, String> nameColumn;
    @FXML private TableColumn<user, String> phoneNumColumn;
    @FXML private TableColumn<user, String> emailColumn;
    @FXML private TableColumn<user, String> userNameColumn;
    @FXML private TableColumn<user, String> passwordColumn;
    @FXML private TableColumn<user, Integer> tierColumn;
    @FXML private TableColumn<user, String> dateofbirthColumn;
    @FXML private TableColumn<user, Integer> roomNum;

    // These variables are used to create new User Objects
    @FXML private TextField nameTextField;
    @FXML private TextField phoneNumTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField userNameTextField;
    @FXML private TextField dobTextField;

    // These variables let an ADMIN login.
    @FXML private Button btnLoginAdmin;

    // User for Menu Bar
    @FXML private Button btnDelete;


    // Combo box for choosing tier level.
    @FXML private ComboBox<Integer> comboBox;

    public static database d = new database();

    public void changeNameColumn(TableColumn.CellEditEvent editedCell){
        user userSelected = tableView.getSelectionModel().getSelectedItem();
        if(!editedCell.getNewValue().toString().equals("")) {
            d.findUser(userSelected).setName(editedCell.getNewValue().toString());
            userSelected.setName(editedCell.getNewValue().toString());
        }
        else{
            alertErrorName();
            tableView.refresh();
            userSelected.setName(d.findUser(userSelected).getName());
        }
    }

    public void changeEmailColumn(TableColumn.CellEditEvent editedCell){
        user userSelected = tableView.getSelectionModel().getSelectedItem();
        if(d.findUser(userSelected).setEmail(editedCell.getNewValue().toString())){
            userSelected.setEmail(editedCell.getNewValue().toString());
        }
        else{
            // You have to click it or double click it then the email will be the original email in the gui.
            alertErrorEmail();
            tableView.refresh();
            userSelected.setEmail(d.findUser(userSelected).getEmail());
        }
    }

    public void changePhoneNumColumn(TableColumn.CellEditEvent editedCell){
        user userSelected = tableView.getSelectionModel().getSelectedItem();
        if(d.findUser(userSelected).setPhoneNum(editedCell.getNewValue().toString())){
            userSelected.setPhoneNum(editedCell.getNewValue().toString());
        }
        else{
            alertErrorPhoneNum();
            tableView.refresh();
            userSelected.setPhoneNum(d.findUser(userSelected).getPhoneNum());
        }
    }

    // This method pops a message about some info for the "about" menu item.
    public void alertAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application Info");
        alert.setHeaderText("Hotel Database");
        alert.setContentText("Created by: Steven Villarreal, Corey Rice,\n\t\t   Jason Kaip, Corey Sutter\n\n" +
                "This application serves as a Hotel Database System that can add, delete users." +
                " Admin can login and edit fields of User(s). Only \"Name\", \"Phone #\", \"Email\"," +
                " are editable.");
        alert.showAndWait();
    }

    // This method pops up an error if the ADMIN types something wrong into adding a user.
    public void alertError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.showAndWait();
    }

    // This method pops up an error if the ADMIN types something wrong into adding a user.
    public void alertErrorName(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Name is invalid.");
        alert.showAndWait();
    }

    // This method pops up an error if the ADMIN types something wrong into adding a user.
    public void alertErrorPhoneNum(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Phone # is invalid length of characters.");
        alert.showAndWait();
    }

    // This method pops up an error if the ADMIN types something wrong into adding a user.
    public void alertErrorEmail(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Email is invalid.");
        alert.showAndWait();
    }

    // This method pops up an error if the ADMIN types something wrong into adding a user.
    public void alertAll(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Please check Phone #, Email, or Date of Birth.");
        alert.showAndWait();
    }

    // This method pops up an info message if the ADMIN tries deleting a user that isn't
    public void alertInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Important");
        alert.setHeaderText("No User to Delete and or cannot delete ADMIN");
        alert.showAndWait();
    }

    // This method will create new User and add it to the table and database.
    public void newUserButtonPushed(){
        try {
            user u = new user(nameTextField.getText(),
                    phoneNumTextField.getText(),
                    emailTextField.getText(), comboBox.getValue(), userNameTextField.getText(),
                    dobTextField.getText());
            // Verifies if email, phone #, and date of birth are valid, then adds the user to database then table.
            if(u.verifyAll(emailTextField.getText(), phoneNumTextField.getText(), dobTextField.getText())){
                d.addUser(u);
                nameTextField.clear();
                phoneNumTextField.clear();
                emailTextField.clear();
                userNameTextField.clear();
                dobTextField.clear();
                comboBox.setValue(null);
                tableView.getItems().add(u);
            }
            else{
                alertAll();
            }
        }
        catch (Exception e){
            alertError();
        }
    }


    // this logins the Admin only. may modify to login a user maybe..
    public void logoutAdmin(){
        if(adminLoggedIn){
            table.setTitle("Admin Login Screen");
            table.setScene(sceneAdmin);
            adminLoggedIn = false;
        }
    }


    public void deleteButtonPushed() {
        ObservableList<user> selectedRow, allPeople;
        allPeople = tableView.getItems();

        // This gives us the row that was selected.
        try {
            selectedRow = tableView.getSelectionModel().getSelectedItems();
            if(selectedRow.size() != 0){
                if (adminLoggedIn == true && !tableView.getSelectionModel().getSelectedItem().getName().equals("ADMIN")) {
                    if (allPeople != null) {
                        for (user u : selectedRow) {
                            if (selectedRow.size() == 1) {
                                allPeople.remove(u);
                                d.removeUser(u);
                                System.out.println("Check");
                                break;
                            }
                            else {
                                d.searchUser(u);
                                allPeople.remove(u);
                                System.out.println("Check");
                            }
                        }
                    }
                }
                else{
                    alertInfo();
                }
            }
            else{
                alertError();
            }
        }
        catch (Exception e){
            alertError();
        }
    }

    public void tierPermissionsPushed(){
        ObservableList<user> selectedRows;
        // This gives us the row that was selected.
        selectedRows = tableView.getSelectionModel().getSelectedItems();


        if(selectedRows.size() != 0) {
            for (user u : selectedRows) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tier Info");
                alert.setHeaderText("Info for Tier: " + u.getTier());
                alert.setContentText(u.returnPermissions(u.getTier()));
                alert.showAndWait();
            }
        }
        else{
            alertError();
        }
    }

    public void handleSave(){
        Stage secondaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save User Table");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fileChooser.showSaveDialog(secondaryStage);
        if(file != null){
            saveFile(tableView.getItems(), file);
        }
    }

    public void saveFile(ObservableList<user> userObservableList, File file){
        try{
            BufferedWriter outWriter = new BufferedWriter((new FileWriter(file + ".txt")));
            for(user u : userObservableList){
                outWriter.write((u.toString()));
                outWriter.newLine();
            }
            System.out.println(userObservableList.toString());
            System.out.println(d.getUserSecondaryDb(0));
            outWriter.close();
        }
        catch (IOException e) {
            Alert ioAlert = new Alert(Alert.AlertType.ERROR, "OOPS!", ButtonType.OK);
            ioAlert.setContentText(("Sorry. An error has occurred."));
            ioAlert.showAndWait();
            if(ioAlert.getResult() == ButtonType.OK){
                ioAlert.close();
            }
        }
    }

    public void loadFile() {
        try {
            String filePath = new File("").getAbsolutePath();
            System.out.println (filePath);
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath +
                    "/src/hotelmanagement/TestFile.txt")));
            String line;
            String[] array;

            d.clearDb();
            users.clear();
            while ((line = br.readLine()) != null){
                array = line.split(",");
                users.add(new user(array[0], array[1], array[2], array[3], array[4], Integer.parseInt(array[5]),
                        array[6], Integer.parseInt(array[7])));
                if(Integer.parseInt(array[5]) == 0){
                    d.addAdmin(new user(array[0], array[1], array[2], array[3], array[4], Integer.parseInt(array[5]),
                            array[6], Integer.parseInt(array[7])));
                }
                else{
                    d.addUserFromLoad(new user(array[0], array[1], array[2], array[3], array[4],
                            Integer.parseInt(array[5]), array[6], Integer.parseInt(array[7])));
                }
            }
            System.out.println("");

            br.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Exits the program via the File --> Close
    public void exitButton(ActionEvent event){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets up the Columns in the table
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'tableView.fxml'.";
        btnDelete.setVisible(true);
        comboBox.getItems().setAll(1,2,3);
        btnLoginAdmin.setText("Logout");
        nameColumn.setCellValueFactory(new PropertyValueFactory<user, String>("name"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<user, String>("PhoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<user, String>("Email"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<user, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<user, String>("password"));
        tierColumn.setCellValueFactory(new PropertyValueFactory<user, Integer>("tier"));
        dateofbirthColumn.setCellValueFactory(new PropertyValueFactory<user, String>("dob"));
        roomNum.setCellValueFactory(new PropertyValueFactory<user, Integer>("roomNum"));

        // load dummy data
        tableView.setItems(getUsers());

        // Update the table to allow for the Name, Email, and Phone # to be editable.
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    // This method will return an Observable list of User objects.
    public ObservableList<user> getUsers(){
        users = FXCollections.observableArrayList();
        d.addUser(new user("Steven", "6168342729", "villarst@mail.gvsu.edu", 1,
                "villarst", "03/27/00"));
        users.add(new user("Steven", "6168342729", "villarst@mail.gvsu.edu", 1,
                d.viewRoom(0), "villarst", d.getUser(0).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new user("Corey R", "6168342729", "ricecore@mail.gvsu.edu", 2,
                "villarst", "03/27/00"));
        users.add(new user("Corey R", "6165583079", "ricecore@mail.gvsu.edu", 2,
                d.viewRoom(1), "riceco", d.getUser(1).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new user("Corey S", "6168342729", "sutterco@mail.gvsu.edu", 2,
                "villarst", "03/27/00"));
        users.add(new user("Corey S", "6165583079", "cutterco@mail.gvsu.edu", 2,
                d.viewRoom(2), "sutterco", d.getUser(2).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new user("Jason", "6168342729", "kaipjaso@mail.gvsu.edu", 3,
                "villarst", "03/27/00"));
        users.add(new user("Jason", "6165583079", "kaipjaso@mail.gvsu.edu", 3,
                d.viewRoom(3), "kaipja", d.getUser(3).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new user("Bobby V", "6168342729", "vuerbobb@mail.gvsu.edu", 1,
                "villarst", "03/27/00"));
        users.add(new user("Bobby V", "6165583079", "vuerbobb@mail.gvsu.edu", 1,
                d.viewRoom(4), "VBobby", d.getUser(4).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addUser(new user("Mike J", "6168342729", "johnmike@mail.gvsu.edu", 3,
                "villarst", "03/27/00"));
        users.add(new user("Mike J", "6165583079", "johnmike@mail.gvsu.edu", 3,
                d.viewRoom(5), "JMike", d.getUser(5).getPassword(), "03/27/00"));
////--------------------------------------------------------------------------------------------------------------------
        d.addAdmin(new user("ADMIN", "9999999999", "admin@login.com", "ADMIN",
                "jscc1234",  0, "04/23/29"));
        users.add(new user("ADMIN", "9999999999", "admin@login.com", "ADMIN", d.getUserSecondaryDb(0).getPassword(), 0, "04/23/29"));
        return users;
    }
}