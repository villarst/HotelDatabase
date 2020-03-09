package HotelManagement;

import javafx.event.ActionEvent;
/*****************************************************************
 The controller class assignes events to the buttons we place in
 JavaFX. These are set up for testing right now but there will be
 many more buttons on the final release.

 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/

/*****************************************************************
 Controller assigns all of the actions preformed by buttons
 *****************************************************************/
public class Controller {

    /*****************************************************************
     Just a regular button press
     @param event
     *****************************************************************/
    public void pressButton(ActionEvent event){
        System.out.println("Hello World");
    }

    /*****************************************************************
     this exits the code when the exit button is pressed
     @param event
     *****************************************************************/
    public void exitButton(ActionEvent event){
        System.exit(0);
    }

    /*****************************************************************
     loads in the database when the button is pressed
     @param event
     *****************************************************************/
    public void createDB(ActionEvent event){
        Database d = new Database();
    }

}
