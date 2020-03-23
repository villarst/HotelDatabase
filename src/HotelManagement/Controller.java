package HotelManagement;

import javafx.event.ActionEvent;

public class Controller {

    public void pressButton(ActionEvent event){
        System.out.println("Hello World");
    }

    public void exitButton(ActionEvent event){
        System.exit(0);
    }

    public void createDB(ActionEvent event){
        Database d = new Database();
    }

}
