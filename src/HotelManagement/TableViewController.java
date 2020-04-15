package HotelManagement;

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

import static HotelManagement.DatabaseGUI.table;
import static HotelManagement.DatabaseGUI.sceneAdmin;

import static HotelManagement.adminLoginSceneController.adminLoggedIn;


/**
 * Need to fix the table so it doesn't reset data every time we change scenes,
 * Also need to somehow get database involved so the table can display the room numbers.
 */
public class TableViewController implements Initializable {
    // Configure the table
    @FXML public TableView<User> tableView;
    @FXML public ObservableList<User> users;
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

    // These variables let an ADMIN login.
    @FXML private Button btnLoginAdmin;

    // User for Menu Bar
    @FXML private Button btnDelete;


    // Combo box for choosing tier level.
    @FXML private ComboBox<Integer> comboBox;

    public static Database d = new Database();

    public void changeNameColumn(TableColumn.CellEditEvent editedCell){
        User userSelected = tableView.getSelectionModel().getSelectedItem();
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
        User userSelected = tableView.getSelectionModel().getSelectedItem();
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
        User userSelected = tableView.getSelectionModel().getSelectedItem();
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
            User u = new User(nameTextField.getText(),
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
        ObservableList<User> selectedRow, allPeople;
        allPeople = tableView.getItems();

        // This gives us the row that was selected.
        try {
            selectedRow = tableView.getSelectionModel().getSelectedItems();
            if(selectedRow.size() != 0){
                if (adminLoggedIn == true && !tableView.getSelectionModel().getSelectedItem().getName().equals("ADMIN")) {
                    if (allPeople != null) {
                        for (User u : selectedRow) {
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

    public void focusOnName(){
        nameTextField.requestFocus();
    }

    public void tierPermissionsPushed(){
        ObservableList<User> selectedRows, allPeople;
        allPeople = tableView.getItems();
        // This gives us the row that was selected.
        selectedRows = tableView.getSelectionModel().getSelectedItems();


        if(selectedRows.size() != 0) {
            for (User u : selectedRows) {
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

    public void saveFile(ObservableList<User> userObservableList, File file){
        try{
            BufferedWriter outWriter = new BufferedWriter((new FileWriter(file + ".txt")));
            for(User u : userObservableList){
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
                    "/src/HotelManagement/TestFile.txt")));
            String line;
            String[] array;

            d.clearDb();
            users.clear();
            while ((line = br.readLine()) != null){
                array = line.split(",");
                users.add(new User(array[0], array[1], array[2], array[3], array[4], Integer.parseInt(array[5]),
                        array[6], Integer.parseInt(array[7])));
                if(Integer.parseInt(array[5]) == 0){
                    d.addAdmin(new User(array[0], array[1], array[2], array[3], array[4], Integer.parseInt(array[5]),
                            array[6], Integer.parseInt(array[7])));
                }
                else{
                    d.addUserFromLoad(new User(array[0], array[1], array[2], array[3], array[4],
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
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'TableView.fxml'.";
        btnDelete.setVisible(true);
        comboBox.getItems().setAll(1,2,3);
        btnLoginAdmin.setText("Logout");
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
        users = FXCollections.observableArrayList();
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
        d.addAdmin(new User("ADMIN", "9999999999", "admin@login.com", "ADMIN", "jscc1234",  0, "04/23/29"));
        users.add(new User("ADMIN", "9999999999", "admin@login.com", "ADMIN", d.getUserSecondaryDb(0).getPassword(), 0, "04/23/29"));
        System.out.println("Admin Tier level: " + users.get(6).getTier());
        return users;
    }
}