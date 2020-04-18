package hotelmanagement;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/*****************************************************************
 This class tests the functionality of the User class.
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/

public class userTest {
  /*****************************************************************
   Tests constructor containing all client info
   *****************************************************************/
  @Test
  public void constructor1(){
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
  }

  /*****************************************************************
   Tests constructor with no password or room number
   *****************************************************************/
  @Test
  public void constructor2(){
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3,"sftwreEgr",
            "10/05/1999");
  }


  /*****************************************************************
   Tests constructor for adding admin to SecondaryDB
   *****************************************************************/
  @Test
  public void constructor3(){
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", "sftwreEgr",3,
            "10/05/1999");
  }

  /*****************************************************************
   Tests constructor with no room number.
   *****************************************************************/
  @Test
  public void constructor4(){
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", "unsecurepassword",
            "unsecurepassword", 3, "10/05/1999");
  }

  /*****************************************************************
   Constructor containing all client info.
   *****************************************************************/
  @Test
  public void constructor5(){
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", "unsecurepassword",
            "unsecurepassword", 3, "10/05/1999", 548);
  }

  /*****************************************************************
   Verifies resetAll sets object info to null
   *****************************************************************/
  @Test (expected = NullPointerException.class)
  public void resetAll() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.resetAll();
    user1.getName();
  }

  /*****************************************************************
   Verifies getName returns name of user
   *****************************************************************/
  @Test
  public void getName() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getName().equals("Noryb"));
  }

  /*****************************************************************
   Verifies getName returns name of user.
   *****************************************************************/
  @Test
  public void getNameFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getName().equals("Kippy"));
  }

  /*****************************************************************
   Verifies setName changes name of user
   *****************************************************************/
  @Test
  public void setName() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setName("Ned");
    assertTrue(user1.getName().equals("Ned"));
  }

  /*****************************************************************
   Verifies name of user is changed by setName
   *****************************************************************/
  @Test
  public void setNameFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setName("Ned");
    assertFalse(user1.getName().equals("Noryb"));
  }

  /*****************************************************************
   Verifies getPhoneNum returns user phone number
   *****************************************************************/
  @Test
  public void getPhoneNum() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getPhoneNum().equals("2487199888"));
  }

  /*****************************************************************
   Verifies getPhoneNum returns user phone number
   *****************************************************************/
  @Test
  public void getPhoneNumFalse() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getPhoneNum().equals("5482175907"));
  }

  /*****************************************************************
   Verifies setPhoneNum changes user's phone number
   *****************************************************************/
  @Test
  public void setPhoneNum() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setPhoneNum("5482542767");
    assertTrue(user1.getPhoneNum().equals("5482542767"));
  }

  /*****************************************************************
   Verifies phone number is changed by setPhoneNum
   *****************************************************************/
  @Test
  public void setPhoneNumFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setPhoneNum("5482542767");
    assertFalse(user1.getPhoneNum().equals("2487199888"));
  }

  /*****************************************************************
   Verifies validation for phone numbers
   *****************************************************************/
  @Test
  public void setPhoneNumFail2() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.setPhoneNum("email@internet.com"));
  }

  /*****************************************************************
   Verifies getEmail returns user email
   *****************************************************************/
  @Test
  public void getEmail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getEmail().equals("Noryb@gvsu.edu"));
  }

  /*****************************************************************
   Verifies getEmail returns user email
   *****************************************************************/
  @Test
  public void getEmailFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getEmail().equals("kaip@kaip.com"));
  }

  /*****************************************************************
   Verifies setEmail changes user's email
   *****************************************************************/
  @Test
  public void setEmail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setEmail("nico@dema.org");
    assertTrue(user1.getEmail().equals("nico@dema.org"));
  }

  /*****************************************************************
   Verifies email is changed by setEmail
   *****************************************************************/
  @Test
  public void setEmailFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setEmail("nico@dema.org");
    assertFalse(user1.getEmail().equals("Noryb@gvsu.edu"));
  }

  /*****************************************************************
   Verifies validation for email
   *****************************************************************/
  @Test
  public void setEmailFail2() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.setEmail("2487199888"));
  }

  /*****************************************************************
   Verifies getUsername returns user's username
   *****************************************************************/
  @Test
  public void getUsername() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getUsername().equals("sftwreEgr"));
  }

  /*****************************************************************
   Verifies getUsername returns user's username
   *****************************************************************/
  @Test
  public void getUsernameFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getUsername().equals("help"));
  }

  /*****************************************************************
   Verifies setUsername changes user's username
   *****************************************************************/
  @Test
  public void setUsername() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setUsername("jasonstatham");
    assertTrue(user1.getUsername().equals("jasonstatham"));
  }

  /*****************************************************************
   Verifies username is changed by setUsername
   *****************************************************************/
  @Test
  public void setUsernameFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setUsername("jasonstatham");
    assertFalse(user1.getUsername().equals("cosmostropharmutarianism"));
  }

  /*****************************************************************
   Verifies getpassword returns user password
   *****************************************************************/
  @Test
  public void getPassword() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getPassword().equals("unsecurepassword"));
  }

  /*****************************************************************
   Verifies getpassword returns user password
   *****************************************************************/
  @Test
  public void getPasswordFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getPassword().equals("securepassword"));
  }

  /*****************************************************************
   Verifies setPassword changes user password
   *****************************************************************/
  @Test
  public void setPassword() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setPassword("fpe");
    assertTrue(user1.getPassword().equals("fpe"));
  }

  /*****************************************************************
   Verifies password is changed by setPassword
   *****************************************************************/
  @Test
  public void setPasswordFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setPassword("fpe");
    assertFalse(user1.getPassword().equals("password"));
  }

  /*****************************************************************
   Verifies getRoomNum returns room num
   *****************************************************************/
  @Test
  public void getRoomNum() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getRoomNum() == 548);
  }

  /*****************************************************************
   Verifies getRoomNum returns room num
   *****************************************************************/
  @Test
  public void getRoomNumFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getRoomNum() == 118);
  }

  /*****************************************************************
   Verifies setRoomNum changes user's room number
   *****************************************************************/
  @Test
  public void setRoomNum() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setRoomNum(503);
    assertTrue(user1.getRoomNum() == 503);
  }

  /*****************************************************************
   Verifies room number is changed by setRoomNum
   *****************************************************************/
  @Test
  public void setRoomNumFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setRoomNum(503);
    assertFalse(user1.getRoomNum() == 548);
  }

  /*****************************************************************
   Verifies getTier returns 3
   *****************************************************************/
  @Test
  public void getTier() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getTier() == 3);
  }

  /*****************************************************************
   Verifies getTier returns 0
   *****************************************************************/
  @Test
  public void getTier2() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 0, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getTier() == 0);
  }

  /*****************************************************************
   Verifies getTier returns correct tier
   *****************************************************************/
  @Test
  public void getTierFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getTier() == 2);
  }

  /*****************************************************************
   Verifies setTier changes user's tier
   *****************************************************************/
  @Test
  public void setTier() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setTier(2);
    assertTrue(user1.getTier() == 2);
  }

  /*****************************************************************
   Verifies tier is changed by setTier
   *****************************************************************/
  @Test
  public void setTierFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setTier(2);
    assertFalse(user1.getTier() == 3);
  }

  /*****************************************************************
   Verifies getDob returns user's date of birth
   *****************************************************************/
  @Test
  public void getDob() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.getDob() == "10/05/1999");
  }

  /*****************************************************************
   Verifies getDob returns user's date of birth
   *****************************************************************/
  @Test
  public void getDobFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.getDob() == "10/05/2018");
  }

  /*****************************************************************
   Verifies setDob changes user's date of birth
   *****************************************************************/
  @Test
  public void setDob() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setDob("10/05/2018");
    assertTrue(user1.getDob() == "10/05/2018");
  }

  /*****************************************************************
   Verifies user's date of birth is changed by setDob
   *****************************************************************/
  @Test
  public void setDobFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    user1.setDob("10/05/2018");
    assertFalse(user1.getDob() == "10/05/1999");
  }

  /*****************************************************************
   Verifies a sample of randomly generated passwords are not the same
   *****************************************************************/
  @Test
  public void generatePassWApache(){
    Boolean result = true;
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    String pass1 = user1.generatePassWApache();
    ArrayList<String> list = new ArrayList();
    for(int i = 0; i < 100; i++){
      String pass2 = user1.generatePassWApache();
      list.add(pass2);
    }
    for(String x : list){
      if(x.equals(pass1))
        result = false;
    }
    assertTrue(result);
  }

  /*****************************************************************
   Verifies date validation
   *****************************************************************/
  @Test
  public void verifyDate() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.verifyDate(user1.getDob()));
  }

  /*****************************************************************
   Verifies date validation with no date in field
   *****************************************************************/
  @Test
  public void verifyDateBlank() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.verifyDate(""));
  }

  /*****************************************************************
   Verifies date validation for string of numbers
   *****************************************************************/
  @Test
  public void verifyDateFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.verifyDate("10051999"));
  }

  /*****************************************************************
   Verifies phone number validation
   *****************************************************************/
  @Test
  public void verifyPhoneNumber() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.verifyPhoneNumber(user1.getPhoneNum()));
  }

  /*****************************************************************
   Verifies phone number validation doesn't accept words
   *****************************************************************/
  @Test
  public void verifyPhoneNumberFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.verifyPhoneNumber(
            "two four eight seven one nine nine eight eight eight"));
  }

  /*****************************************************************
   Verifies email validation
   *****************************************************************/
  @Test
  public void verifyEmail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.verifyEmail(user1.getEmail()));
  }

  /*****************************************************************
   Verifies email validation does not accept other info as an email
   *****************************************************************/
  @Test
  public void verifyEmailFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.verifyEmail("10/05/1999"));
  }

  /*****************************************************************
   Verifies verifyAll validates email, phone number, and date of
   birthall in one method
   *****************************************************************/
  @Test
  public void verifyAll() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.verifyAll(user1.getEmail(), user1.getPhoneNum(),
            user1.getDob()));
  }

  /*****************************************************************
   Verifies verifyAll validates correct email, phone number,
   and date of birth
   *****************************************************************/
  @Test
  public void verifyAllFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.verifyAll("jason@kaip", "2487199888",
            "10/05/1999"));
  }

  /*****************************************************************
   Verifies toString returns the correct info in the correct order
   *****************************************************************/
  @Test
  public void testToString() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertTrue(user1.toString().equals(user1.getName() + "," +
            user1.getPhoneNum() + "," + user1.getEmail() + "," +
            user1.getUsername() + "," + user1.getPassword() + "," +
            user1.getTier() + "," + user1.getDob() + "," + user1.getRoomNum()));
  }

  /*****************************************************************
   Verifies toString returns the correct info in the correct order
   *****************************************************************/
  @Test
  public void testToStringFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548, "sftwreEgr",
            "unsecurepassword", "10/05/1999");
    assertFalse(user1.toString().equals(user1.getName() + "," +
            user1.getName() + "," + user1.getName() + "," +
            user1.getName() + "," + user1.getName() + "," +
            user1.getName() + "," + user1.getName() + "," + user1.getName()));
  }

  /*****************************************************************
   Verifies returnPermissions returns correct permissions for tier 0
   *****************************************************************/
  @Test
  public void returnPermissions0() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 0, 548,
            "sftwreEgr", "unsecurepassword",
            "10/05/1999");
    assertTrue(user1.returnPermissions
            (user1.getTier()).equals("Pool Access: YES" + "\n" +
            "Gym Access: YES" + "\n" +
            "PC Room Access: YES" + "\n" +
            "Bar Access: YES" + "\n" +
            "Casino Access: YES" + "\n" +
            "Buffet Access: YES" + "\n" +
            "Hot Tub Access: YES" + "\n" +
            "Arcade Room Access: YES" + "\n" +
            "Admin Access: YES" + "\n" +
            "Room Access: YES" + "\n" +
            "All Room Access: YES" + "\n" ));
  }

  /*****************************************************************
   Verifies returnPermissions returns correct permissions for tier 1
   *****************************************************************/
  @Test
  public void returnPermissions1() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 1, 548,
            "sftwreEgr", "unsecurepassword",
            "10/05/1999");
    assertTrue(user1.returnPermissions
            (user1.getTier()).equals("Pool Access: YES" + "\n" +
            "Gym Access: NO" + "\n" +
            "PC Room Access: YES" + "\n" +
            "Bar Access: NO" + "\n" +
            "Casino Access: NO" + "\n" +
            "Buffet Access: NO" + "\n" +
            "Hot Tub Access: YES" + "\n" +
            "Arcade Room Access: NO" + "\n" +
            "Admin Access: NO" + "\n" +
            "Room Access: YES" + "\n" +
            "All Room Access: NO" + "\n" ));
  }

  /*****************************************************************
   Verifies returnPermissions returns correct permissions for tier 2
   *****************************************************************/
  @Test
  public void returnPermissions2() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 2, 548,
            "sftwreEgr", "unsecurepassword",
            "10/05/1999");
    assertTrue(user1.returnPermissions
            (user1.getTier()).equals("Pool Access: YES" + "\n" +
            "Gym Access: YES" + "\n" +
            "PC Room Access: YES" + "\n" +
            "Bar Access: NO" + "\n" +
            "Casino Access: NO" + "\n" +
            "Buffet Access: YES" + "\n" +
            "Hot Tub Access: YES" + "\n" +
            "Arcade Room Access: NO" + "\n" +
            "Admin Access: NO" + "\n" +
            "Room Access: YES" + "\n" +
            "All Room Access: NO" + "\n" ));
  }

  /*****************************************************************
   Verifies returnPermissions returns correct permissions for tier 3
   *****************************************************************/
  @Test
  public void returnPermissions3() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548,
            "sftwreEgr", "unsecurepassword",
            "10/05/1999");
    assertTrue(user1.returnPermissions
            (user1.getTier()).equals("Pool Access: YES" + "\n" +
            "Gym Access: YES" + "\n" +
            "PC Room Access: YES" + "\n" +
            "Bar Access: YES" + "\n" +
            "Casino Access: YES" + "\n" +
            "Buffet Access: YES" + "\n" +
            "Hot Tub Access: YES" + "\n" +
            "Arcade Room Access: YES" + "\n" +
            "Admin Access: NO" + "\n" +
            "Room Access: YES" + "\n" +
            "All Room Access: NO" + "\n" ));
  }

  /*****************************************************************
   Verifies returnPermissions returns correct permissions for tier 3
   *****************************************************************/
  @Test
  public void returnPermissionsFail() {
    User user1 = new User("Noryb", "2487199888",
            "Noryb@gvsu.edu", 3, 548,
            "sftwreEgr", "unsecurepassword",
            "10/05/1999");
    assertFalse(user1.returnPermissions
            (user1.getTier()).equals("Pool Access: YES" + "\n" +
            "Gym Access: NO" + "\n" +
            "PC Room Access: NO" + "\n" +
            "Bar Access: NO" + "\n" +
            "Casino Access: NO" + "\n" +
            "Buffet Access: NO" + "\n" +
            "Hot Tub Access: NO" + "\n" +
            "Arcade Room Access: NO" + "\n" +
            "Admin Access: YES" + "\n" +
            "Room Access: NO" + "\n" +
            "All Room Access: YES" + "\n" ));
  }
}