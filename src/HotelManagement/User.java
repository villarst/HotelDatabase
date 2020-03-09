package HotelManagement;

import org.apache.commons.lang3.RandomStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*****************************************************************
 User creates all of the information that needs to be filled in by
 the user of the hotel such as their name, phone number, email, ect.
 This is the information that will be stored on the users hotel card.

 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/


public class User {
    /** The users name */
    private String Name;

    /** The users phone number */
    private String PhoneNum;

    /** The users email */
    private String Email;

    /** The users account balance */
    private int accountBalance;

    /** The username of the user */
    private String username;

    /** The users password */
    private String password;

    /** The users room number */
    private int roomNum;

    /** The users tier */
    private int tier;

    /** The users date of birth */
    private String dob;


    /*****************************************************************
     Constructor that sets all of the users personal information such as
     the users name as a string and the account balance as an int as an
     example.

     @param name users name
     @param phoneNum users phone number
     @param email users email
     @param accountBalance users account balance
     @param tier users tier
     @param username users username
     @param password users password
     @param dob users date of birth
     *****************************************************************/
    public User(String name, String phoneNum, String email,
                int accountBalance, int tier, String username, String password, String dob) {

        Name = name;
        PhoneNum = phoneNum;
        Email = email;
        this.accountBalance = accountBalance;
        this.username = username;
        this.password = password;
        this.tier = tier;
        this.dob = dob;
        Tier t = new Tier(tier);
        this.password = generatePassWApache();
    }

    /*****************************************************************
     This constructor sets all of the actual values
     *****************************************************************/
    public User(){
        Name = null;
        PhoneNum = null;
        Email = null;
        this.accountBalance = 0;
        this.username = null;
        this.password = null;
        this.roomNum = 0;
        this.tier = 0;
        this.dob = null;
        Tier t = new Tier(0);
    }
    /*****************************************************************
     Constructor that resets all of the users personal information
     *****************************************************************/
    public String resetAll(){
        Name = null;
        PhoneNum = null;
        Email = null;
        accountBalance = 0;
        username = null;
        password = null;
        roomNum = 0;
        tier = 0;
        dob = null;
        return "Name: null, Phone Number: 0, Email: null, Account Balance: 0, Username: null" +
                "Password: null, Room Number: null, Tier: null, Date of Birth: null";
    }

    /*****************************************************************
     gets the name of the user
     @return Name returns the users name
     *****************************************************************/
    public String getName() {
        return Name;
    }

    /*****************************************************************
     sets the users name
     @param name the users name
     *****************************************************************/
    public void setName(String name) {
        Name = name;
    }

    /*****************************************************************
     gets the users phone number
     @return PhoneNum returns the users phone number
     *****************************************************************/
    public String getPhoneNum() {
        return PhoneNum;
    }

    /*****************************************************************
     sets the users phone number also verifys the
     phone number and makes sure it is valid
     @param phoneNum the users phone number
     *****************************************************************/
    public void setPhoneNum(String phoneNum){
        if(verifyPhoneNumber(phoneNum))
            PhoneNum = phoneNum;
    }

    /*****************************************************************
     gets the users email
     @return Email return the users email
     *****************************************************************/
    public String getEmail() {
        return Email;
    }

    /*****************************************************************
     sets the users email and verifys if it is a
     valid email
     @param email the users email
     *****************************************************************/
    public void setEmail(String email){
        if(verifyEmail(email))
            Email = email;
    }

    /*****************************************************************
     gets the account balance of the user
     @return accountBalance return the account balance
     *****************************************************************/
    public int getAccountBalance() {
        return accountBalance;
    }

    /*****************************************************************
     Constructor that sets the account balance
     @param accountBalance the users account balance
     *****************************************************************/
    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    /*****************************************************************
     gets the username of the user
     @return username return the users username
     *****************************************************************/
    public String getUsername() {
        return username;
    }

    /*****************************************************************
     sets the users username
     @param username the users username
     *****************************************************************/
    public void setUsername(String username) {
        this.username = username;
    }

    /*****************************************************************
     gets the users password
     @return password return the users password
     *****************************************************************/
    public String getPassword() {
        return password;
    }

    /*****************************************************************
     sets the users password
     @param password
     *****************************************************************/
    public void setPassword(String password) {
        this.password = password;
    }

    /*****************************************************************
     gets the users room number
     @return roomNum return the users room number
     *****************************************************************/
    public int getRoomNum() {
        return roomNum;
    }

    /*****************************************************************
     sets the users room number
     @param roomNum the users room number
     *****************************************************************/
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    /*****************************************************************
     gets the users hotel tier
     @return tier returns the users tier
     *****************************************************************/
    public int getTier() {
        return tier;
    }

    /*****************************************************************
     sets the users tier
     @param tier the users tier
     *****************************************************************/
    public void setTier(int tier) {
        this.tier = tier;
    }

    /*****************************************************************
     gets the users date of birth
     @return dob returns the users date of birth
     *****************************************************************/
    public String getDob() {
        return dob;
    }

    /*****************************************************************
     sets the users date of birth and checks if the users date of birth
     is valid
     @param dob the users date of birth
     *****************************************************************/
    public void setDob(String dob){
        if(verifyDate(dob))
            this.dob = dob;
    }

    /*****************************************************************
     This method generates a random password for the user to get into
     their hotel accounts. This was done by importing an apache random
     string util
     @return generateString This returns the random string
     *****************************************************************/
    public String generatePassWApache() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        return generatedString;
    }

    /*****************************************************************
     This method prints out all of the basic user info
     *****************************************************************/
    public void BasicInfo(){
        System.out.println("Name: " + Name);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Tier Level: " + tier);
        System.out.println("Room Number: " + roomNum);
    }

    /*****************************************************************
     This method verifys the date that is entered by the user. To be
     a valid date it must follow the format of MM/DD/YYYY. If anything
     else is entered it will throw an error
     @param date the date that the user enters for the date of birth
     *****************************************************************/
    public static boolean verifyDate(String date) {
        if (date.trim().equals("")) {
            return true;
        }
        else {
            SimpleDateFormat simpleDateFormatLong = new SimpleDateFormat("MM/dd/yyyy");
            simpleDateFormatLong.setLenient(false);
            SimpleDateFormat simpleDateFormatShort = new SimpleDateFormat("MM/dd/yy");
            simpleDateFormatShort.setLenient(false);
            try {
                Date javaDate = simpleDateFormatLong.parse(date);
                System.out.println("Verified: " + date);
            }
            catch (ParseException e) {
                try{
                    Date javaDate = simpleDateFormatShort.parse(date);
                    System.out.println("Verified: " + date);
                }
                catch (ParseException e1){
                    System.out.println(date + " is not a valid date. DOB not updated.");
                    return false;
                }
            }
            return true;
        }
    }

    /*****************************************************************
     This method verifies the users phone number and makes sure it is
     valid. If it is a valid verified number it will print out that it
     is verified. If it is not a valid number it will say the number is
     invalid and the number was not updates

     @param newNumber the number the user puts in
     *****************************************************************/
    public static boolean verifyPhoneNumber(String newNumber){
        newNumber = newNumber.replaceAll("[\\s\\-()]", "");
        if (newNumber.matches("\\d{10}")) {
            System.out.println("Verified: " + newNumber);
            return true;
        }
        else{
            System.out.println(newNumber + " is invalid. Phone number not updated.");
            return false;
        }
    }

    /*****************************************************************
     This method verifies if the users email is a valid email. This
     requires some type of letters on one side of the @ then and @ sign
     followed by other letters after the @. If it is not a valid email
     then it prints that it is invalid and the email is not updated

     @param email this is the users email.
     *****************************************************************/
    public static boolean verifyEmail(String email){
        if(email.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
            System.out.println("Verified: " + email);
            return true;
        }
        else {
            System.out.println(email + " is invalid. E-Mail address not updated.");
            return false;
        }
    }
}