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
  private ArrayList<User> mainDb; //NOPMD

  /** Boolean Array that stores values for the rooms. */
  boolean[] rooms; //NOPMD

  /** Arraylist that stores the admins. */
  private ArrayList<User> secondaryDb; //NOPMD


  /*****************************************************************
   Constructor that creates a Database to use to store Users and
   assign rooms.
   *****************************************************************/
  public Database() {
    mainDb = new ArrayList<>();
    secondaryDb = new ArrayList<>();
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
  public void addUser(User u) { //NOPMD
    if (!checkTierFull(u.getTier() - 1)) { //NOPMD
      mainDb.add(u);
      assignRoom(u);
    } else {
      System.out.println("The tier is full, please select a different tier."); //NOPMD
    }
  }


  /*****************************************************************
   Adds the user to the Arraylist of users via the load menu option.
   @param u the User that is passed into
   the method that will be added.
   *****************************************************************/
  public void addUserFromLoad(User u) { //NOPMD
    mainDb.add(u);
    u.setRoomNum(u.getRoomNum());
    rooms[u.getRoomNum()] = true; //NOPMD
  }


  /*****************************************************************
   Adds the Admin to the Arraylist of admins.
   @param u the User that is passed into
   the method that will be added.
   *****************************************************************/
  public void addAdmin(User u) { //NOPMD
    if (u.getTier() == 0) {
      secondaryDb.add(u);
      assignRoom(u);
    }
  }


  /*****************************************************************
   Clears the Database consisting of MainDb, SecondaryDb and
   rooms[].
   *****************************************************************/
  public void clearDb() {
    mainDb.clear();
    secondaryDb.clear();
    for (int i = 0; i < 300; i++) {
      rooms[i] = false;
    }
  }


  /*****************************************************************
   Returns true or false depending on if the room is occupied.
   @return boolean for if the room is occupied.
   *****************************************************************/
  public boolean getRooms(final int num) {
    return rooms[num];
  }


  /*****************************************************************
   Assigns the room to the user that was just added to the Arraylist.
   @param u the User that is passed into
   the method that was just added.
   *****************************************************************/
  public void assignRoom(User u) { //NOPMD
    final int room = (u.getTier() - 1) * 100; //NOPMD
    if (u.getTier() == 0) {
      u.setRoomNum(-1);
    } else {
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
  public int viewRoom(int i) { //NOPMD
    return mainDb.get(i).getRoomNum(); //NOPMD
  }

  /*****************************************************************
   Returns the user at index i in MainDb.
   @param i the index passed to return MainDb(i).
   @return User the user to be returned from MainDb.
   *****************************************************************/
  public User getUser(int i) { //NOPMD
    return mainDb.get(i);
  }


  /*****************************************************************
   Returns the user at i from MainDb (used to change the user
   credentials when added already).
   @param u the user passed to check if the user exists.
   @return User the user to be returned from MainDb.
   *****************************************************************/
  public User findUser(User u) { //NOPMD
    User found = null; //NOPMD
    for (final User user : mainDb) {
      if (u.getRoomNum() == user.getRoomNum()) {
        found = user; //NOPMD
      }
    }
    return found;
  }


  /*****************************************************************
   Checks if the room is occupied if so returns a boolean of true
   or false.
   @param t the tier that of the User
   @return boolean for if tier is full.
   *****************************************************************/
  public boolean checkTierFull(int t) { //NOPMD
    final int tier = t * 100;
    boolean isFull = true; //NOPMD

    for (int i = tier; i <= tier + 99; i++) {
      if (!rooms[i]) {
        isFull = false; //NOPMD
      }
    }
    return isFull;
  }


  /*****************************************************************
   Removes the User from the Arraylist MainDb.
   @param u the User that is wanting to be removed.
   *****************************************************************/
  public void removeUser(User u) { //NOPMD
    if (u.getRoomNum() != -1) {
      rooms[u.getRoomNum()] = false; //NOPMD
    }
    mainDb.remove(u);
  }


  /*****************************************************************
   Removes the User from the Arraylist MainDb by checking password.
   @param u the User that is wanting to be removed.
   *****************************************************************/
  public void searchUser(User u) { //NOPMD
    for (int i = 0; i < mainDb.size(); i++) { //NOPMD
      if (mainDb.get(i).getPassword() == u.getPassword()) { //NOPMD
        rooms[u.getRoomNum()] = false; //NOPMD
        mainDb.remove(mainDb.get(i));
      }
    }
  }


  /*****************************************************************
   Checks if the password passed is present in SecondaryDb.
   @param pass the password that is used to check for if Admin exists.
   @return returns if the Admin exists in SecondaryDb or not.
   *****************************************************************/
  public boolean searchSecondary(String pass) { //NOPMD
    boolean found = true; //NOPMD
    for (final User user : secondaryDb) {
      if (!pass.equals(user.getPassword())) {
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
  public User getUserSecondaryDb(int i) { //NOPMD
    return secondaryDb.get(i);
  }


  /*****************************************************************
   Returns the size of the SecondaryDb.
   @return the size of SecondaryDb
   *****************************************************************/
  public int secondaryDbSize() {
    return secondaryDb.size();
  }


  /*****************************************************************
   Returns a string that has each field seperated by a ",".
   @return the string of each User or Admin
   *****************************************************************/
  @Override
  public String toString() {
    String result = "";
    for (final User user : mainDb) {
      result += user.getName() //NOPMD
              + " , " + user.getPhoneNum() //NOPMD
              + " , " + user.getEmail() + " , " + user.getUsername()
              + " , " + user.getPassword() + " , " + user.getTier()
              + " , " + user.getDob() + " , " + user.getRoomNum()
              + "\n";
    }
    for (final User user : secondaryDb) {
      result += user.getName() //NOPMD
              + " , " + user.getPhoneNum()
              + " , " + user.getEmail() + " , " + user.getUsername()
              + " , " + user.getPassword() + " , " + user.getTier()
              + " , " + user.getDob() + " , " + user.getRoomNum()
              + "\n";
    }
    return result;
  }
}