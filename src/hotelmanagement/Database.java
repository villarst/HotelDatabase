package hotelmanagement;


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

  /** Arraylist that stores the admins. */
  private ArrayList <User> SecondaryDb;


  /*****************************************************************
   Constructor that creates a Database to use to store Users and
   assign rooms.
   *****************************************************************/
  public Database(){
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
    if (!checkTierFull(u.getTier() - 1)) {
      MainDb.add(u);
      assignRoom(u);
    }
    else{
      System.out.println("The tier is full, please select a different tier.");
    }
  }

  /*****************************************************************
   Adds the user to the Arraylist of users via the load menu option.
   @param u the User that is passed into
   the method that will be added.
   *****************************************************************/
  public void addUserFromLoad(User u){
    MainDb.add(u);
    u.setRoomNum(u.getRoomNum());
    rooms[u.getRoomNum()] = true;
  }

  /*****************************************************************
   Adds the Admin to the Arraylist of admins.
   @param u the User that is passed into
   the method that will be added.
   *****************************************************************/
  public void addAdmin(User u){
    if(u.getTier() == 0){
      SecondaryDb.add(u);
      assignRoom(u);
    }
  }

  /*****************************************************************
   Clears the Database consisting of MainDb, SecondaryDb and rooms[]
   *****************************************************************/
  public void clearDb(){
    MainDb.clear();
    SecondaryDb.clear();
    for(int i = 0; i < 300; i++){
      rooms[i] = false;
    }
  }

  /*****************************************************************
   Returns true or false depending on if the room is occupied.
   @return boolean for if the room is occupied.
   *****************************************************************/
  public boolean getRooms(int num) {
    return rooms[num];
  }

  /*****************************************************************
   Assigns the room to the user that was just added to the Arraylist.
   @param u the User that is passed into
   the method that was just added.
   *****************************************************************/
  public void assignRoom(User u){
    int room = (u.getTier() - 1) * 100;
    if(u.getTier() == 0){
      u.setRoomNum(-1);
    }
    else {
      if (!checkTierFull(u.getTier() - 1)) {
        for (int i = 0; i <= 99; i++) { // was 99
          if (!rooms[room + i]) {
            rooms[room + i] = true;
            u.setRoomNum(room + i);
            break;
          }
        }
      }
    }
  }

  /*****************************************************************
   Returns the room number at i from MainDb.
   @param i the index passed to return MainDb(i)'s room number.
   @return int the room number to be returned.
   *****************************************************************/
  public int viewRoom(int i){
    return MainDb.get(i).getRoomNum();
  }

  /*****************************************************************
   Returns the user at index i in MainDb.
   @param i the index passed to return MainDb(i).
   @return User the user to be returned from MainDb.
   *****************************************************************/
  public User getUser(int i){
    return MainDb.get(i);
  }

  /*****************************************************************
   Returns the user at i from MainDb (used to change the user
   credentials when added already).
   @param u the user passed to check if the user exists.
   @return User the user to be returned from MainDb.
   *****************************************************************/
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
   @return boolean for if tier is full.
   *****************************************************************/
  public boolean checkTierFull(int t){
    int tier = t * 100;
    for(int i = tier; i <= tier + 99; i++){
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

  /*****************************************************************
   Removes the User from the Arraylist MainDb by checking password.
   @param u the User that is wanting to be removed.
   *****************************************************************/
  public void searchUser(User u){
    for(int i = 0; i < MainDb.size(); i++){
      if(MainDb.get(i).getPassword() == u.getPassword()){
        rooms[u.getRoomNum()] = false;
        MainDb.remove(MainDb.get(i));
      }
    }
  }

  /*****************************************************************
   Checks if the password passed is present in SecondaryDb.
   @param pass the password that is used to check for if Admin exists.
   @return returns if the Admin exists in SecondaryDb or not.
   *****************************************************************/
  public boolean searchSecondary(String pass){
    boolean found = true;
    for(int i = 0; i < SecondaryDb.size(); i++){
      if(!pass.equals(SecondaryDb.get(i).getPassword())) {
        found = false;
        break;
      }
    }
    return found;
  }

  /*****************************************************************
   Removes the User from the Arraylist SecondaryDb.
   @param i the index specified.
   @return the user to be returned from SecondaryDb.
   *****************************************************************/
  public User getUserSecondaryDb(int i){
    return SecondaryDb.get(i);
  }

  /*****************************************************************
   Returns the size of the SecondaryDb.
   @return the size of SecondaryDb
   *****************************************************************/
  public int secondaryDbSize(){
    return SecondaryDb.size();
  }

  /*****************************************************************
   Returns a string that has each field seperated by a ",".
   @return the string of each User or Admin
   *****************************************************************/
  @Override
  public String toString(){
    String result = "";
    for(int i = 0; i < MainDb.size(); i++){
      result += MainDb.get(i).getName() +
              " , " + MainDb.get(i).getPhoneNum() +
              " , " + MainDb.get(i).getEmail() +
              " , " + MainDb.get(i).getUsername() +
              " , " + MainDb.get(i).getPassword() +
              " , " + MainDb.get(i).getTier() +
              " , " + MainDb.get(i).getDob() +
              " , " + MainDb.get(i).getRoomNum() + "\n";
    }
    for(int j = 0; j < SecondaryDb.size(); j++){
      result += SecondaryDb.get(j).getName() +
              " , " + SecondaryDb.get(j).getPhoneNum() +
              " , " + SecondaryDb.get(j).getEmail() +
              " , " + SecondaryDb.get(j).getUsername() +
              " , " + SecondaryDb.get(j).getPassword() +
              " , " + SecondaryDb.get(j).getTier() +
              " , " + SecondaryDb.get(j).getDob() +
              " , " + SecondaryDb.get(j).getRoomNum() + "\n";
    }
    return result;
  }
}