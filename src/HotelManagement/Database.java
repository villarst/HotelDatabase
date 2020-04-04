package HotelManagement;


import java.util.*;
import java.io.Serializable;
/*****************************************************************
 This class consists of the database that will be used to store,
 remove, and assign rooms to the users (Guests).
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/
public class Database implements Serializable{
    /** Arraylist that stores the Users */
    private ArrayList <User> MainDb;
    /** Boolean Array that stores values for the rooms. */
    boolean rooms [];

    private ArrayList <User> SecondaryDb;

    /*****************************************************************
     Constructor that creates a Database to use to store Users and
     assign rooms.
     *****************************************************************/
    public Database(){
        // initialize the Arraylist to hold the users and initialize the rooms Array.
        MainDb = new ArrayList<User>();
        SecondaryDb = new ArrayList<User>();
        rooms = new boolean[300];
        for(int i = 0; i < 300; i++){
            rooms[i] = false;
        }
    }

    /*****************************************************************
     Adds the user to the Arraylist.
     @param u the User that is passed into
     the method that will be added.
     *****************************************************************/
    public void addUser(User u){
        if(!checkTierFull(u.getTier() - 1)){
            MainDb.add(u);
            assignRoom(u);
        }
        else{
            System.out.println("Sorry rooms are full.");
        }
    }

    public void addAdmin(User u){
        if(u.getTier() == 0){
            SecondaryDb.add(u);
        }
    }

    // This method clears the Database, (MainDb, SecondaryDb, rooms[]
    public void clearDb(){
       MainDb.clear();
       SecondaryDb.clear();
       for(int i = 0; i < 300; i++){
           rooms[i] = false;
       }
    }

    // This method returns MainDb
    public ArrayList<User> getMainDb() {
        return MainDb;
    }

    /*****************************************************************
     Assigns the room to the user that was just added to the Arraylist.
     @param u the User that is passed into
     the method that was just added.
     *****************************************************************/
    public void assignRoom(User u){
        int room = (u.getTier() - 1) * 100;
        if(u.getTier() == 4){
            u.setRoomNum(-1);
        }
        else {
            if (!checkTierFull(u.getTier() - 1)) {
                for (int i = 0; i <= 99; i++) { // was 99
                    if (!rooms[room + i]) {
                        rooms[room + i] = true;
                        u.setRoomNum(room + i);
                        System.out.println(u.getRoomNum());
                        break;
                    }
                }
            }
        }
    }

    public int viewRoom(int i){
        return MainDb.get(i).getRoomNum();
    }

    public User getUser(int i){
        return MainDb.get(i);
    }

    public User findUser(User u){
        User found = null;
        for(int i = 0; i < MainDb.size(); i++){
            if(u.getRoomNum() == MainDb.get(i).getRoomNum()){
                found = MainDb.get(i);
            }
        }
        return found;
    }

    /*****************************************************************
     Checks if the room is occupied if so returns a boolean of true
     or false.
     @param t the tier that of the User that was passed into the
     the method.
     *****************************************************************/
    public boolean checkTierFull(int t){
        int tier = t * 100;
        for(int i = tier; i <= tier + 99; i++){  // was 99
            // This checks if any room is empty. If yes then returns false.
            // Otherwise returns true.
            if(!rooms[i])
                return false;
        }
        return true;
    }

    /*****************************************************************
     Removes the User from the Arraylist MainDb.
     @param u the User that is wanting to be removed.
     *****************************************************************/
    public void removeUser(User u){
        if(u.getRoomNum() != -1) {
            rooms[u.getRoomNum()] = false;
        }
        MainDb.remove(u);
    }

    // this is used to delete a user from the delete button in tableView
    public void searchUser(User u){
        for(int i = 0; i < MainDb.size(); i++){
            if(MainDb.get(i).getPassword() == u.getPassword()){
                rooms[u.getRoomNum()] = false;
                MainDb.remove(MainDb.get(i));
            }
        }
    }

    // this is used to search for a user in SecondaryDb
    public boolean searchSecondary(String pass){
        boolean found = true;
        for(int i = 0; i < SecondaryDb.size(); i++){
            if(pass.equals(SecondaryDb.get(i).getPassword())){
                found = true;
            }
            else{
                found = false;
            }
        }
        return found;
    }

    public User getUserSecondaryDb(int i){
        return SecondaryDb.get(i);
    }

    // returns size of the SecondaryDb
    public int secondaryDbSize(){
        return SecondaryDb.size();
    }

    public int mainDbSize(){
        return MainDb.size();
    }

    // To string for the Database
    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < MainDb.size(); i++){
            result += MainDb.get(i).getName() + " , " + MainDb.get(i).getPhoneNum() +
                    " , " + MainDb.get(i).getEmail() + " , " + MainDb.get(i).getUsername() +
                    " , " + MainDb.get(i).getPassword() + " , " + MainDb.get(i).getTier() +
                    " , " + MainDb.get(i).getDob() + " , " + MainDb.get(i).getRoomNum() + "\n";
        }
        for(int j = 0; j < SecondaryDb.size(); j++){
            result += MainDb.get(j).getName() + " , " + MainDb.get(j).getPhoneNum() +
                    " , " + MainDb.get(j).getEmail() + " , " + MainDb.get(j).getUsername() +
                    " , " + MainDb.get(j).getPassword() + " , " + MainDb.get(j).getTier() +
                    " , " + MainDb.get(j).getDob() + " , " + MainDb.get(j).getRoomNum() + "\n";
        }
        return result;
    }

}