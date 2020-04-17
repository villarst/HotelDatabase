package hotelmanagement;

import java.io.Serializable;
import java.util.ArrayList;


/*****************************************************************
 This class consists of the database that will be used to store,
 remove, and assign rooms to the users (Guests).
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/


public class Database implements Serializable { //NOPMD

  /** Arraylist that stores the Users. */
  private ArrayList<User> MainDb; //NOPMD

  /** Boolean Array that stores values for the rooms. */
  boolean[] rooms; //NOPMD

  /** Arraylist that stores the admins. */
  private ArrayList<User> SecondaryDb; //NOPMD


  /*****************************************************************
   Constructor that creates a Database to use to store Users and
   assign rooms.
   *****************************************************************/
  public Database() {
    // initialize the Arraylist to hold the users and initialize the rooms Array.
    MainDb = new ArrayList<>();
    SecondaryDb = new ArrayList<>();
    rooms = new boolean[300];
    for (int i = 0; i < 300; i++) {
      rooms[i] = false;
    }
  }


  /*****************************************************************
   Adds the user to the Arraylist.
   @param u the User that is passed into
   the method that will be added.
   *****************************************************************/
  public void addUser(final User u) { //NOPMD
    if (!checkTierFull(u.getTier() - 1)) { //NOPMD
      MainDb.add(u);
      assignRoom(u);
    } else {
      System.out.println("Sorry rooms are full.");//NOPMD
    }
  }


  /*****************************************************************
   Adds the user to the Arraylist from the loaded file.
   @param u the User that is passed into the method that will be
   added.
   *****************************************************************/
  public void addUserFromLoad(final User u) { //NOPMD
    MainDb.add(u);
    u.setRoomNum(u.getRoomNum());
    rooms[u.getRoomNum()] = true; //NOPMD
  }


  /*****************************************************************
   Adds the admin to the Arraylist.
   @param u the admin user that is passed into the method that will
   be added.
   *****************************************************************/
  public void addAdmin(final User u) { //NOPMD
    if (u.getTier() == 0) {
      SecondaryDb.add(u);
    }
  }


  /*****************************************************************
   Clears the database and sets all rooms to empty.
   *****************************************************************/
  public void clearDb() {
    MainDb.clear();
    SecondaryDb.clear();
    for (int i = 0; i < 300; i++) {
      rooms[i] = false;
    }
  }


  /*****************************************************************
   Returns the database of users.
   @return MainDb the database of users.
   *****************************************************************/
  public ArrayList<User> getMainDb() { //NOPMD
    return MainDb;
  }


  /*****************************************************************
   Assigns the room to the user that was just added to the Arraylist.
   @param u the User that is passed into
   the method that was just added.
   *****************************************************************/
  public void assignRoom(final User u) { //NOPMD
    final int room = (u.getTier() - 1) * 100; //NOPMD
    if (u.getTier() == 0) {
      u.setRoomNum(-1);
    } else {
      if (!checkTierFull(u.getTier() - 1)) {
        for (int i = 0; i <= 99; i++) { // was 99
          if (!rooms[room + i]) {
            rooms[room + i] = true;
            u.setRoomNum(room + i);
            System.out.println(u.getRoomNum()); //NOPMD
            break;
          }
        }
      }
    }
  }


  /*****************************************************************
   Returns a specified room number given an index.
   @param i the room index.
   @return the room number given from specified index.
   *****************************************************************/
  public int viewRoom(int i) { //NOPMD
    return MainDb.get(i).getRoomNum(); //NOPMD
  }


  /*****************************************************************
   Returns the user index from the database.
   @param i the user index
   @return the user in the database from the specified
   index.
   *****************************************************************/
  public User getUser(int i) { //NOPMD
    return MainDb.get(i);
  }


  /*****************************************************************
   Returns the user from a database if they exist.
   @param u the user to find in the database.
   @return the user if they exist, otherwise null
   *****************************************************************/
  public User findUser(final User u) { //NOPMD
    User found = null; //NOPMD
    for (final User user : MainDb) {
      if (u.getRoomNum() == user.getRoomNum()) { //NOPMD
        found = user; //NOPMD
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
  public boolean checkTierFull(int t) { //NOPMD
    final int tier = t * 100;
    boolean isFull = true; //NOPMD
    for (int i = tier; i <= tier + 99; i++) {  // was 99
      // This checks if any room is empty. If yes then returns false.
      // Otherwise returns true.
      if (!rooms[i]) {
        isFull = false;//NOPMD
        break;
      }
    }

    return isFull;
  }


  /*****************************************************************
   Removes the User from the MainDb.
   @param u the User that is wanting to be removed.
   *****************************************************************/
  public void removeUser(final User u) { //NOPMD
    if (u.getRoomNum() != -1) {
      rooms[u.getRoomNum()] = false; //NOPMD
    }
    MainDb.remove(u);
  }


  /*****************************************************************
   Searches and removes a user selected from the GUI.
   @param u the User that is wanting to be removed.
   *****************************************************************/
  public void searchUser(final User u) { //NOPMD
    for (int i = 0; i < MainDb.size(); i++) { //NOPMD
      if (MainDb.get(i).getPassword().equals(u.getPassword())) { //NOPMD
        rooms[u.getRoomNum()] = false; //NOPMD
        MainDb.remove(MainDb.get(i));
      }
    }
  }


  /*****************************************************************
   Searches the secondary database for a user.
   @param pass the password to match.
   @return found the value that determines if the user was found in
   the secondary database.
   *****************************************************************/
  public boolean searchSecondary(final String pass) {
    boolean found = true; //NOPMD
    for (final User user : SecondaryDb) {
      if (pass.equals(user.getPassword())) { //NOPMD
        found = true; //NOPMD
      } else {
        found = false; //NOPMD
      }
    }
    return found;
  }


  /*****************************************************************
   Returns a user from the secondary database from the given index.
   @param i the index of the user to return.
   @return the user from the secondary database.
   *****************************************************************/
  public User getUserSecondaryDb(int i) { //NOPMD
    return SecondaryDb.get(i);
  }


  /*****************************************************************
   Returns the size of the secondary database.
   @return the size of the secondary database.
   *****************************************************************/
  public int secondaryDbSize() {
    return SecondaryDb.size();
  }


  /*****************************************************************
   Returns the size of the main database.
   @return the size of the main database.
   *****************************************************************/
  public int mainDbSize() {
    return MainDb.size();
  }


  /*****************************************************************
   Returns the string containing the details of a user.
   @return a string containing the details of a user.
   *****************************************************************/
  @Override
  public String toString() {
    String result = "";
    for (User user : MainDb) { //NOPMD
      result += user.getName() + " , " + user.getPhoneNum() + //NOPMD
              " , " + user.getEmail() + " , " + user.getUsername() + //NOPMD
              " , " + user.getPassword() + " , " + user.getTier() + //NOPMD
              " , " + user.getDob() + " , " + user.getRoomNum() + "\n"; //NOPMD
    }
    for (int j = 0; j < SecondaryDb.size(); j++) {
      result += MainDb.get(j).getName() + " , " + MainDb.get(j).getPhoneNum() + //NOPMD
              " , " + MainDb.get(j).getEmail() + " , " + MainDb.get(j).getUsername() + //NOPMD
              " , " + MainDb.get(j).getPassword() + " , " + MainDb.get(j).getTier() + //NOPMD
              " , " + MainDb.get(j).getDob() + " , " + MainDb.get(j).getRoomNum() + "\n"; //NOPMD
    }
    return result;
  }

}