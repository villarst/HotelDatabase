package hotelmanagement;

import static hotelmanagement.AdminLoginSceneController.adminLoggedIn;
import static hotelmanagement.DatabaseGUI.sceneAdmin;
import static hotelmanagement.DatabaseGUI.table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/*****************************************************************
 TableViewController sets up the commands and uses needed for the
 TableView.fxml file.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 ****************************************************************/


public class TableViewController implements Initializable { 

  /** Table View FX object. */
  @FXML public TableView<User> tableView; 

  /** List FX object. */
  @FXML public ObservableList<User> users; 

  /** Table column FX object for name. */
  @FXML private TableColumn<User, String> nameColumn; 

  /** Table column FX object for phone number. */
  @FXML private TableColumn<User, String> phoneNumColumn; 

  /** Table column FX object for email. */
  @FXML private TableColumn<User, String> emailColumn; 

  /** Table column FX object for username. */
  @FXML private TableColumn<User, String> userNameColumn; 

  /** Table column FX object for password. */
  @FXML private TableColumn<User, String> passwordColumn; 

  /** Table column FX object for tier. */
  @FXML private TableColumn<User, Integer> tierColumn; 

  /** Table column FX object for DOB. */
  @FXML private TableColumn<User, String> dateofbirthColumn; 

  /** Table column FX object for room number. */
  @FXML private TableColumn<User, Integer> roomNum; 

  /** Text field FX object for entering name. */
  @FXML private TextField nameTextField; 

  /** Text field FX object for entering phone number. */
  @FXML private TextField phoneNumTextField; 

  /** Text field FX object for entering email. */
  @FXML private TextField emailTextField; 

  /** Text field FX object for entering username. */
  @FXML private TextField userNameTextField; 

  /** Text field FX object for entering DOB. */
  @FXML private TextField dobTextField; 

  /** Button FX object for admin login. */
  @FXML private Button btnLoginAdmin; 

  /** Button FX object for deleting users. */
  @FXML private Button btnDelete; 

  /** Combo box FX object for selecting tier. */
  @FXML private ComboBox<Integer> comboBox; 

  /** Database of users. */
  public static Database d = new Database();


  /*****************************************************************
   Changes the name of a table cell when selected.
   @param editedCell the cell to be changed
    *****************************************************************/
  public void changeNameColumn(final TableColumn.CellEditEvent editedCell) {
    final User userSelected = tableView.getSelectionModel().getSelectedItem(); 

    if (!editedCell.getNewValue().toString().equals("")) { 
      d.findUser(userSelected).setName(editedCell.getNewValue().toString()); 
      userSelected.setName(editedCell.getNewValue().toString()); 
    } else {
      alertErrorName();
      tableView.refresh();
      userSelected.setName(d.findUser(userSelected).getName()); 
    }
  }


  /*****************************************************************
   Changes the email of a table cell when selected.
   @param editedCell the cell to be changed
   *****************************************************************/
  public void changeEmailColumn(final TableColumn.CellEditEvent editedCell) {
    final User userSelected = tableView.getSelectionModel().getSelectedItem(); 

    if (d.findUser(userSelected).setEmail(editedCell.getNewValue().toString())) { 
      userSelected.setEmail(editedCell.getNewValue().toString()); 
    } else {
      alertErrorEmail();
      tableView.refresh();
      userSelected.setEmail(d.findUser(userSelected).getEmail()); 
    }
  }


  /*****************************************************************
   Changes the phone number of a table cell when selected.
   @param editedCell the cell to be changed
   *****************************************************************/
  public void changePhoneNumColumn(final TableColumn.CellEditEvent editedCell) {
    final User userSelected = tableView.getSelectionModel().getSelectedItem(); 

    if (d.findUser(userSelected).setPhoneNum(editedCell.getNewValue().toString())) { 
      userSelected.setPhoneNum(editedCell.getNewValue().toString()); 
    } else {
      alertErrorPhoneNum();
      tableView.refresh();
      userSelected.setPhoneNum(d.findUser(userSelected).getPhoneNum()); 
    }
  }


  /*****************************************************************
   Displays info about the program when the menu item is selected.
   *****************************************************************/
  public void alertAbout() {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    alert.setTitle("Application Info");
    alert.setHeaderText("Hotel Database");
    alert.setContentText("Created by: Steven Villarreal, Corey Rice,\n\t\t +"
            + "   Jason Kaip, Corey Sutter\n\n"
            + "This application serves as a Hotel Database "
            + "System that can add, delete users."
            + " Admin can login and edit fields of User(s). "
            + "Only \"Name\", \"Phone #\", \"Email\","
            + " are editable.");
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if the ADMIN types something wrong into adding
   a user.
   *****************************************************************/
  public void alertError() {
    final Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Error"); 
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if the ADMIN types something wrong into adding
   a name for a user.
   *****************************************************************/
  public void alertErrorName() {
    final Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Error");
    alert.setHeaderText("Name is invalid.");
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if the ADMIN types something wrong
   into adding a phone number for a user.
   *****************************************************************/
  public void alertErrorPhoneNum() {
    final Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Error");
    alert.setHeaderText("Phone # is invalid length of characters.");
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if the ADMIN types something wrong
   into adding an email for a user.
   *****************************************************************/
  public void alertErrorEmail() {
    final Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Error");
    alert.setHeaderText("Email is invalid.");
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if the ADMIN types something wrong
   into adding a phone number, email, or DOB for a user.
   *****************************************************************/
  public void alertAll() {
    final Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Error");
    alert.setHeaderText("Please check Phone #, Email, or Date of Birth.");
    alert.showAndWait();
  }


  /*****************************************************************
   Displays an error if an attempt to delete the ADMIN is made.
   *****************************************************************/
  public void alertInfo() {
    final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    alert.setTitle("Important");
    alert.setHeaderText("No User to Delete and or cannot delete ADMIN");
    alert.showAndWait();
  }


  /*****************************************************************
   Creates a new User and adds it to the table and database.
   *****************************************************************/
  public void newUserButtonPushed() {
    try {
      User u = new User(nameTextField.getText(), 
              phoneNumTextField.getText(),
              emailTextField.getText(),
              comboBox.getValue(),
              userNameTextField.getText(),
              dobTextField.getText());
      // Verifies if email, phone #, and date of birth are valid
      // Then adds the user to database then table.
      if (u.verifyAll(emailTextField.getText(), phoneNumTextField.getText(),
              dobTextField.getText())) {
        d.addUser(u);
        nameTextField.clear();
        phoneNumTextField.clear();
        emailTextField.clear();
        userNameTextField.clear();
        dobTextField.clear();
        comboBox.setValue(null);
        tableView.getItems().add(u); 
      } else {
        alertAll();
      }
    } catch (Exception e) { 
      alertError();
    }
  }


  /*****************************************************************
   Logs the ADMIN out when the button is pressed.
   *****************************************************************/
  public void logoutAdmin() {
    if (adminLoggedIn) {
      table.setTitle("Admin Login Screen");
      table.setScene(sceneAdmin);
      adminLoggedIn = false;
    }
  }


  /*****************************************************************
   Deletes a selected user from the database.
   *****************************************************************/
  public void deleteButtonPushed() {
    ObservableList<User> selectedRow;
    ObservableList<User> allPeople;

    allPeople = tableView.getItems(); 

    // This gives us the row that was selected.
    try {
      selectedRow = tableView.getSelectionModel().getSelectedItems(); 
      if (selectedRow.size() != 0) { 
        if (adminLoggedIn && !tableView.getSelectionModel() 
                .getSelectedItem().getName().equals("ADMIN")) { 
          if (allPeople != null) {
            for (final User u : selectedRow) {
              if (selectedRow.size() == 1) { 
                allPeople.remove(u);
                d.removeUser(u);
                System.out.println("Check"); 
                break; 
              } else {
                d.searchUser(u);
                allPeople.remove(u);
                System.out.println("Check"); 
              }
            }
          }
        } else {
          alertInfo();
        }
      } else {
        alertError();
      }
    } catch (Exception e) { 
      alertError();
    }
  }


  /*****************************************************************
   Displays the tier permissions for a selected user.
   *****************************************************************/
  public void tierPermissionsPushed() {
    ObservableList<User> selectedRows;

    // This gives us the row that was selected.
    selectedRows = tableView.getSelectionModel().getSelectedItems(); 


    if (selectedRows.size() != 0) { 
      for (final User u : selectedRows) {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setTitle("Tier Info");
        alert.setHeaderText("Info for Tier: " + u.getTier());
        alert.setContentText(u.returnPermissions(u.getTier()));
        alert.showAndWait();
      }
    } else {
      alertError();
    }
  }


  /*****************************************************************
   Displays a prompt for saving a file.
   *****************************************************************/
  public void handleSave() {
    final Stage secondaryStage = new Stage();
    final FileChooser fileChooser = new FileChooser();

    fileChooser.setTitle("Save User Table");
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

    final File file = fileChooser.showSaveDialog(secondaryStage);

    if (file != null) {
      saveFile(tableView.getItems(), file);
    }
  }

  /*****************************************************************
   Saves the database to file.
   @param userObservableList the database list to be saved.
   @param file the file to save to.
   *****************************************************************/
  public void saveFile(ObservableList<User> userObservableList, File file) { 
    try {
      final BufferedWriter outWriter =
              new BufferedWriter(new FileWriter(file + ".txt"));

      for (final User u : userObservableList) {
        outWriter.write(u.toString());
        outWriter.newLine();
      }
      System.out.println(userObservableList.toString()); 
      System.out.println(d.getUserSecondaryDb(0)); 
      outWriter.close();
    } catch (IOException e) {
      final Alert ioAlert = new
              Alert(Alert.AlertType.ERROR, "OOPS!", ButtonType.OK);

      ioAlert.setContentText("Sorry. An error has occurred.");
      ioAlert.showAndWait();

      if (ioAlert.getResult() == ButtonType.OK) {
        ioAlert.close();
      }
    }
  }


  /*****************************************************************
   Loads a database file from the hotelmanagement folder.
   *****************************************************************/
  public void loadFile() {
    try {
      final String filePath = new File("").getAbsolutePath();
      System.out.println(filePath); 
      BufferedReader br =
              new BufferedReader(new FileReader(new File(filePath
                      + "/src/hotelmanagement/TestFile.txt")));
      String line;
      String[] array;

      d.clearDb();
      users.clear();
      while ((line = br.readLine()) != null) { 
        array = line.split(","); 
        users.add(new User(array[0], array[1], array[2], array[3], array[4], 
                Integer.parseInt(array[5]), array[6],
                Integer.parseInt(array[7]))); 
        if (Integer.parseInt(array[5]) == 0) { 
          d.addAdmin(new User(array[0], array[1], array[2],
                  array[3], array[4], 
                  Integer.parseInt(array[5]), array[6],
                  Integer.parseInt(array[7]))); 
        } else {
          d.addUserFromLoad(new User(array[0], array[1],
                  array[2], array[3], array[4], 
                  Integer.parseInt(array[5]), array[6],
                  Integer.parseInt(array[7]))); 
        }
      }

      br.close();

    } catch (Exception ex) { 
      ex.printStackTrace(); 
    }
  }


  /*****************************************************************
   Exits the program when the exit menu item is selected.
   *****************************************************************/
  public void exitButton() {
    System.exit(0); 
  }


  /*****************************************************************
   Initializes the table to be displayed.
   @param url FX url.
   @param resourceBundle FX resource bundle.
   *****************************************************************/
  @Override
  public void initialize(final URL url, final ResourceBundle resourceBundle) {
    // Sets up the Columns in the table
    assert comboBox != null : "fx:id=\"comboBox\" was not injected:"
            + " check your FXML file 'TableView.fxml'.";
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


  /*****************************************************************
   Creates a list of users for the database.
   *****************************************************************/
  public ObservableList<User> getUsers() {
    users = FXCollections.observableArrayList();
    d.addUser(new User("Steven", "6168342729",
            "villarst@mail.gvsu.edu", 1, 
            "villarst", "03/27/00")); 
    users.add(new User("Steven", "6168342729",
            "villarst@mail.gvsu.edu", 1,
            d.viewRoom(0), "villarst",
            d.getUser(0).getPassword(), "03/27/00")); 
    d.addUser(new User("Corey R", "6168342729",
            "ricecore@mail.gvsu.edu", 2,
            "riceco", "03/27/00"));
    users.add(new User("Corey R", "6165583079",
            "ricecore@mail.gvsu.edu", 2, 
            d.viewRoom(1), "riceco",
            d.getUser(1).getPassword(), "03/27/00")); 
    d.addUser(new User("Corey S", "6168342729",
            "sutterco@mail.gvsu.edu", 2,
            "sutterco", "03/27/00"));
    users.add(new User("Corey S", "6165583079",
            "cutterco@mail.gvsu.edu", 2,
            d.viewRoom(2), "sutterco",
            d.getUser(2).getPassword(), "03/27/00")); 
    d.addUser(new User("Jason", "6168342729",
            "kaipjaso@mail.gvsu.edu", 3,
            "kaipja", "03/27/00"));
    users.add(new User("Jason", "6165583079",
            "kaipjaso@mail.gvsu.edu", 3,
            d.viewRoom(3), "kaipja",
            d.getUser(3).getPassword(), "03/27/00")); 
    d.addUser(new User("Bobby V", "6168342729",
            "vuerbobb@mail.gvsu.edu", 1,
            "VBobby", "03/27/00"));
    users.add(new User("Bobby V", "6165583079",
            "vuerbobb@mail.gvsu.edu", 1,
            d.viewRoom(4), "VBobby",
            d.getUser(4).getPassword(), "03/27/00")); 
    d.addUser(new User("Mike J", "6168342729",
            "johnmike@mail.gvsu.edu", 3,
            "JMike", "03/27/00"));
    users.add(new User("Mike J", "6165583079",
            "johnmike@mail.gvsu.edu", 3,
            d.viewRoom(5), "JMike",
            d.getUser(5).getPassword(), "03/27/00")); 
    d.addAdmin(new User("ADMIN", "9999999999", "admin@login.com",
            "ADMIN", "jscc1234",  0, "04/23/29"));
    users.add(new User("ADMIN", "9999999999", "admin@login.com",
            "ADMIN", d.getUserSecondaryDb(0).getPassword(),
            0, "04/23/29"));

    return users;
  }
}