package hotelmanagement;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.RandomStringUtils;


/*****************************************************************
 This class consists of creating users and adding them to a
 database. The characteristics of a user can then be modified or
 viewed.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/


public class User implements Serializable { //NOPMD

  /** Name of user. */
  private transient SimpleStringProperty name;

  /** Phone number of user. */
  private transient SimpleStringProperty phoneNum;

  /** Email of user. */
  private transient SimpleStringProperty email;

  /** Username of user. */
  private transient SimpleStringProperty username;

  /** Password of user. */
  private transient SimpleStringProperty password;

  /** Room number of user. */
  private int roomNum;

  /** Tier of user. */
  private int tier;

  /** Date of birth of user. */
  private transient SimpleStringProperty dob;

  /*****************************************************************
   Constructor that creates a user to add to the database.
   @param name the name of the user.
   @param phoneNum the phone number of the user.
   @param email the email of the user.
   @param tier the tier of the user.
   @param username the username of the user.
   @param dobirth the date of birth of the user.
   @throws IllegalAccessException if an error occurs from given
   parameters.
   *****************************************************************/
  public User(final String name, final String phoneNum, final String email, final int tier,
              final String username, final String dobirth) throws IllegalArgumentException { //NOPMD
    this.name = new SimpleStringProperty(name);
    this.username = new SimpleStringProperty(username);
    this.tier = tier;
    this.password = new SimpleStringProperty(generatePassWApache()); //NOPMD

    this.phoneNum = new SimpleStringProperty(phoneNum);
    this.email = new SimpleStringProperty(email);
    this.dob = new SimpleStringProperty(dobirth);
  }


  /*****************************************************************
   Constructor that creates a user to add to the database.
   @param name the name of the user.
   @param phoneNum the phone number of the user.
   @param email the email of the user.
   @param tier the tier of the user.
   @param username the username of the user.
   @param dobirth the date of birth of the user.
   @throws IllegalAccessException if an error occurs from given
   parameters.
   *****************************************************************/
  public User(final String name, final String phoneNum, final String email, final int tier,
              final int room, final String username, final String pass,
              final String dobirth) throws IllegalArgumentException { //NOPMD
    this.name = new SimpleStringProperty(name);
    this.username = new SimpleStringProperty(username);
    this.tier = tier;
    this.roomNum = room;
    this.password = new SimpleStringProperty(pass);
    if (verifyPhoneNumber(phoneNum)) {
      this.phoneNum = new SimpleStringProperty(phoneNum);
    }
    if (verifyEmail(email)) {
      this.email = new SimpleStringProperty(email);
    }
    if (verifyDate(dobirth)) {
      this.dob = new SimpleStringProperty(dobirth);
    }
  }


  /*****************************************************************
   Constructor that creates a admin to add to the secondary
   database.
   @param name the name of the admin.
   @param num the phone number of the admin.
   @param email the email of the admin.
   @param tier the tier of the admin.
   @param username the username of the admin.
   @param dob the date of birth of the admin.
   *****************************************************************/
  public User(final String name, final String num, final String email,
              final String username, final int tier, final String dob) {
    this.name = new SimpleStringProperty(name);
    if (verifyPhoneNumber(num)) {
      this.phoneNum = new SimpleStringProperty(num);
    }
    if (verifyEmail(email)) {
      this.email = new SimpleStringProperty(email);
    }
    this.username = new SimpleStringProperty(username);
    this.password = new SimpleStringProperty(generatePassWApache()); //NOPMD
    this.roomNum = -1;

    if (tier == 0) {
      this.tier = 0;
    }
    if (verifyDate(dob)) {
      this.dob = new SimpleStringProperty(dob);
    }
  }



  /*****************************************************************
   Constructor that creates a user to add to the database.
   @param name the name of the user.
   @param num the phone number of the user.
   @param email the email of the user.
   @param tier the tier of the user.
   @param username the username of the user.
   @param dob the date of birth of the user.
   *****************************************************************/
  public User(final String name, final String num, final String email,
              final String username, final String pass, final int tier, final String dob) {
    this.name = new SimpleStringProperty(name);
    if (verifyPhoneNumber(num)) {
      this.phoneNum = new SimpleStringProperty(num);
    }
    if (verifyEmail(email)) {
      this.email = new SimpleStringProperty(email);
    }
    this.username = new SimpleStringProperty(username);
    this.password = new SimpleStringProperty(pass);
    this.roomNum = -1;

    if (tier == 0) {
      this.tier = 0;
    }
    if (verifyDate(dob)) {
      this.dob = new SimpleStringProperty(dob);
    }
  }


  /*****************************************************************
   Constructor that creates a user to add to the database.
   @param name the name of the user.
   @param num the phone number of the user.
   @param email the email of the user.
   @param tier the tier of the user.
   @param username the username of the user.
   @param dob the date of birth of the user.
   @throws IllegalAccessException if an error occurs from given
   parameters.
   *****************************************************************/
  public User(final String name, final String num, final String email,
              final String username, final String pass, final int tier,
              final String dob, final int roomNum) {
    this.name = new SimpleStringProperty(name);
    if (verifyPhoneNumber(num)) {
      this.phoneNum = new SimpleStringProperty(num);
    }
    if (verifyEmail(email)) {
      this.email = new SimpleStringProperty(email);
    }
    this.username = new SimpleStringProperty(username);
    this.password = new SimpleStringProperty(pass);
    this.tier = tier;

    if (verifyDate(dob)) {
      this.dob = new SimpleStringProperty(dob);
    }
    this.roomNum = roomNum;
  }


  /*****************************************************************
   Resets all values of a user.
   @return a verification string.
   *****************************************************************/
  public String resetAll() {
    name = null; //NOPMD
    phoneNum = null; //NOPMD
    email = null; //NOPMD
    username = null; //NOPMD
    password = null; //NOPMD
    roomNum = 0;
    tier = 0;
    dob = null; //NOPMD
    return "Name: null, Phone Number: 0, Email: null, Account Balance: 0, Username: null"
            + "Password: null, Room Number: null, Tier: null, Date of Birth: null";
  }


  /*****************************************************************
   Returns the name of the user.
   @return the name of the user.
   *****************************************************************/
  public String getName() {
    return name.get();
  }


  /*****************************************************************
   Sets the name of the user.
   @param name the name of the user.
   *****************************************************************/
  public void setName(final String name) {
    this.name = new SimpleStringProperty(name);
  }


  /*****************************************************************
   Returns the phone number of the user.
   @return the number of the user.
   *****************************************************************/
  public String getPhoneNum() {
    return phoneNum.get();
  }


  /*****************************************************************
   Sets the phone number of the user.
   @param phoneNum the phone number of the user.
   *****************************************************************/
  public boolean setPhoneNum(final String phoneNum) { //NOPMD
    boolean isValid = false; //NOPMD

    if (verifyPhoneNumber(phoneNum)) {
      this.phoneNum = new SimpleStringProperty(phoneNum);
      isValid = true;
    }
    return isValid;
  }


  /*****************************************************************
   Returns the email of the user.
   @return the email of the user.
   *****************************************************************/
  public String getEmail() {
    return email.get();
  }

  // changed to boolean for tableViewController edit columns
  public boolean setEmail(final String email) { //NOPMD
    boolean isValid = false; //NOPMD

    if (verifyEmail(email)) {
      this.email = new SimpleStringProperty(email);
      isValid = true;
    }
    return isValid;
  }


  /*****************************************************************
   Returns the username of the user.
   @return the username of the user.
   *****************************************************************/
  public String getUsername() {
    return username.get();
  }


  /*****************************************************************
   Sets the username of the user.
   @param username the username of the user.
   *****************************************************************/
  public void setUsername(final String username) {
    this.username = new SimpleStringProperty(username);
  }


  /*****************************************************************
   Returns the password of the user.
   @return the password of the user.
   *****************************************************************/
  public String getPassword() {
    return password.get();
  }


  /*****************************************************************
   Sets the password of the user.
   @param password the password of the user.
   *****************************************************************/
  public void setPassword(final String password) {
    this.password = new SimpleStringProperty(password);
  }


  /*****************************************************************
   Returns the room number of the user.
   @return the room number of the user.
   *****************************************************************/
  public int getRoomNum() {
    return roomNum;
  }


  /*****************************************************************
   Sets the room number of the user.
   @param roomNum the room number of the user.
   *****************************************************************/
  public void setRoomNum(final int roomNum) {
    this.roomNum = roomNum;
  }


  /*****************************************************************
   Returns the tier of the user.
   @return the tier of the user.
   *****************************************************************/
  public int getTier() {
    return tier;
  }


  /*****************************************************************
   Sets the tier of the user.
   @param tier the tier of the user.
   *****************************************************************/
  public void setTier(final int tier) {
    this.tier = tier;
  }


  /*****************************************************************
   Returns the date of birth of the user.
   @return the date of birth of the user.
   *****************************************************************/
  public String getDob() {
    return dob.get();
  }


  /*****************************************************************
   Sets the date of birth of the user.
   @param dateOfBirth the date of birth of the user.
   *****************************************************************/
  public void setDob(final String dateOfBirth) {
    if (verifyDate(dateOfBirth)) {
      this.dob = new SimpleStringProperty(dateOfBirth);
    }
  }


  /*****************************************************************
   Generates a random password for the user.
   @return a randomly generated password.
   *****************************************************************/
  public String generatePassWApache() {
    return RandomStringUtils.randomAlphanumeric(10);
  }


  /*****************************************************************
   Verifies the date given is correct.
   @param date the date to verify.
   @return a boolean value if the date is valid.
   *****************************************************************/
  public static boolean verifyDate(final String date) {
    // Needs to check if date is valid as in its the correct date,
    // and it is greater than or equal to 18, cant be 12 and get a
    // hotel room. (compares to today's date)
    boolean isValid = false; //NOPMD

    if (date.trim().equals("")) { //NOPMD
      isValid = true;
    } else {
      SimpleDateFormat simpleDateFormatLong = new SimpleDateFormat("MM/dd/yyyy"); //NOPMD
      simpleDateFormatLong.setLenient(false);
      SimpleDateFormat simpleDateFormatShort = new SimpleDateFormat("MM/dd/yy"); //NOPMD
      simpleDateFormatShort.setLenient(false);
      try {
        Date javaDate = simpleDateFormatLong.parse(date); //NOPMD
      } catch (ParseException e) {
        try {
          Date javaDate = simpleDateFormatShort.parse(date); //NOPMD
        } catch (ParseException e1) {
          try {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid date of birth").showAndWait();
          } catch (ExceptionInInitializerError i) { //NOPMD
            isValid = false;
          }
        }
      }
    }
    return isValid;
  }


  /*****************************************************************
   Verifies the phone number given is correct.
   @param newNumber the date to verify.
   @return a boolean value if the phone number is valid.
   *****************************************************************/
  public static boolean verifyPhoneNumber(String newNumber) {  //NOPMD
    newNumber = newNumber.replaceAll("[\\s\\-()]", ""); //NOPMD
    boolean isValid = false; //NOPMD

    if (newNumber.matches("\\d{10}")) { //NOPMD
      isValid = true;
    } else {
      try {
        new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number").showAndWait();
      } catch (NoClassDefFoundError e) {
        isValid = false;
      }
    }
    return  isValid;
  }


  /*****************************************************************
   Verifies the email given is correct.
   @param email the date to verify.
   @return a boolean value if the email is valid.
   *****************************************************************/
  public static boolean verifyEmail(final String email) {
    boolean isValid = false; //NOPMD

    if (email.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
      isValid = true;
    } else {
      try {
        new Alert(Alert.AlertType.ERROR, "Please enter a valid email").showAndWait();
      } catch (NoClassDefFoundError i) {
        isValid = false;
      }
    }
    return isValid;
  }


  /*****************************************************************
   Verifies all given fields are correct.
   @param email the email to verify.
   @param newNumber the phone number to verify.
   @param date the date to verify.
   @return a boolean value if all fields are valid.
   *****************************************************************/
  public static boolean verifyAll(final String email, final String newNumber, final String date) {
    boolean isValid = false; //NOPMD

    if (verifyDate(date) && verifyEmail(email) && verifyPhoneNumber(newNumber)) {
      isValid = true;
    }
    return isValid;
  }

  /*****************************************************************
   Returns a string of user information.
   @return a string with user characteristics.
   *****************************************************************/
  @Override
  public String toString() {
    return getName() + "," + getPhoneNum() + "," + getEmail() + "," + getUsername() + ","
            + getPassword() + "," + getTier() + "," + getDob() + "," + getRoomNum();
  }


  /*****************************************************************
   Returns a string of tier permissions.
   @param tier the tier to check permissions for.
   @return a string of all the permissions for a user.
   *****************************************************************/
  public String returnPermissions(final int tier) {
    String permissions = null; //NOPMD

    switch (tier) {
      case 1: // pool, pc, hot tub access
        permissions = "Pool Access: YES\n" //NOPMD
                + "Gym Access: NO\n"
                + "PC Room Access: YES\n" //NOPMD
                + "Bar Access: NO\n"
                + "Casino Access: NO\n"
                + "Buffet Access: NO\n"
                + "Hot Tub Access: YES\n" //NOPMD
                + "Arcade Room Access: NO\n"
                + "Admin Access: NO\n"
                + "Room Access: YES\n" //NOPMD
                + "All Room Access: NO\n";
        break;
      case 2: // pool, pc, hot tub, gym, buffet access
        permissions = "Pool Access: YES\n"
                + "Gym Access: YES\n"
                + "PC Room Access: YES\n"
                + "Bar Access: NO\n"
                + "Casino Access: NO\n"
                + "Buffet Access: YES\n"
                + "Hot Tub Access: YES\n"
                + "Arcade Room Access: NO\n"
                + "Admin Access: NO\n"
                + "Room Access: YES\n"
                + "All Room Access: NO\n";
        break;
      case 3: // pool, pc, hot tub, gym, bar, casino, buffet, arcade access.
        permissions = "Pool Access: YES\n"
                + "Gym Access: YES\n"
                + "PC Room Access: YES\n"
                + "Bar Access: YES\n"
                + "Casino Access: YES\n"
                + "Buffet Access: YES\n"
                + "Hot Tub Access: YES\n"
                + "Arcade Room Access: YES\n"
                + "Admin Access: NO\n"
                + "Room Access: YES\n"
                + "All Room Access: NO\n";
        break;
      case 0: // admin access.
        permissions = "Pool Access: YES\n"
                + "Gym Access: YES\n"
                + "PC Room Access: YES\n"
                + "Bar Access: YES\n"
                + "Casino Access: YES\n"
                + "Buffet Access: YES\n"
                + "Hot Tub Access: YES\n"
                + "Arcade Room Access: YES\n"
                + "Admin Access: YES\n"
                + "Room Access: YES\n"
                + "All Room Access: YES\n";
        break;
      default:
        break;
    }
    return permissions;
  }
}