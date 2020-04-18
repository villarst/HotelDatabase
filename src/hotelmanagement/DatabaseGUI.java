package hotelmanagement;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*****************************************************************
 DatabaseGUI is the code that runs the Java FX file so the gui can
 be displayed.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 ****************************************************************/


public class DatabaseGUI extends Application { //NOPMD

  /** Initializes the stage (window) for the GUI. */
  public static Stage table = new Stage();

  /** Root location for the TableView.fxml file. */
  public static Parent root1;

  /** Root location for the AdminLoginScene.fxml file. */
  public static Parent root2;

  /** Scene for the admin login. */
  public static Scene sceneAdmin;

  /** Scene for the table view. */
  public static Scene sceneTable;

  static {
    try {
      root1 = FXMLLoader.load(DatabaseGUI.class.getResource
              ("TableView.fxml"));
    } catch (IOException e) {
      e.printStackTrace();//NOPMD
    }
  }

  static {
    try {
      root2 = FXMLLoader.load(DatabaseGUI.class.getResource
              ("AdminLoginScene.fxml"));
    } catch (IOException e) {
      e.printStackTrace();//NOPMD
    }
  }


  /*****************************************************************
   Starts the GUI to be displayed to the screen.
   @param primaryStage the main stage (window) to be displayed.
   @throws Exception if an error occurs during stage setup.
  *****************************************************************/
  @Override
  public void start(final Stage primaryStage) throws Exception {
    sceneAdmin = new Scene(root2, 890, 540);
    sceneTable = new Scene(root1, 1210, 600);
    table.setTitle("Admin Login Screen");
    table.setScene(sceneAdmin);
    table.show();
  }

  /*****************************************************************
   Main method used to launch the GUI.
   *****************************************************************/
  public static void main(final String[] args) {
    launch(args);
  }
}