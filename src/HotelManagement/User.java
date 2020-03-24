package HotelManagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class User {
    private SimpleStringProperty Name;
    private SimpleStringProperty PhoneNum;
    private SimpleStringProperty Email;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private int roomNum;
    private int tier;
    private SimpleStringProperty dob;


    public User(String name, String phoneNum, String email, int tier, String username, String dobirth) throws IllegalArgumentException{
        this.Name = new SimpleStringProperty(name);
        this.username = new SimpleStringProperty(username);
        this.tier = tier;
        Tier t = new Tier(tier);
        this.password = new SimpleStringProperty(generatePassWApache());
        if(verifyPhoneNumber(phoneNum)){
            this.PhoneNum = new SimpleStringProperty(phoneNum);
        }
        if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        }
        if(verifyDate(dobirth)){
            this.dob = new SimpleStringProperty(dobirth);
        }
//        Object d = dobirth;
//        SimpleStringProperty var = new SimpleStringProperty((String) d);
//        if(verifyDate(dobirth)){
//            this.setDob(var);
//            this.dob = var;
//        }
    }

    public User(){
        Name = null;
        PhoneNum = null;
        Email = null;
        this.username = null;
        this.password = null;
        this.roomNum = 0;
        this.tier = 0;
        this.dob = null;
        Tier t = new Tier(0);
    }

    public String resetAll(){
        Name = null;
        PhoneNum = null;
        Email = null;
        username = null;
        password = null;
        roomNum = 0;
        tier = 0;
        dob = null;
        return "Name: null, Phone Number: 0, Email: null, Account Balance: 0, Username: null" +
                "Password: null, Room Number: null, Tier: null, Date of Birth: null";
    }

    public String getName() {
        return Name.get();
    }

    public void setName(SimpleStringProperty name) {
        Name = name;
    }

    public String getPhoneNum() {
        return PhoneNum.get();
    }

    public void setPhoneNum(String phoneNum){
        if(verifyPhoneNumber(phoneNum))
            this.PhoneNum = new SimpleStringProperty(phoneNum);
    }

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String email){
        if(verifyEmail(email))
            this.Email = new SimpleStringProperty(email);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getDob() {
        return dob.get();
    }

    public void setDob(String dateOfBirth){
        if(verifyDate(dateOfBirth))
            this.dob = new SimpleStringProperty(dateOfBirth);
    }

    public String generatePassWApache() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        return generatedString;
    }

    public void BasicInfo(){
        System.out.println("Name: " + Name);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Tier Level: " + tier);
        System.out.println("Room Number: " + roomNum);
    }

    public static boolean verifyDate(String date) {
        // Needs to check if date is valid as in its the correct date,
        // and it is greater than or equal to 18, cant be 12 and get a
        // hotel room. (compares to today's date)
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

    public static boolean verifyPhoneNumber(String newNumber){
        newNumber = newNumber.replaceAll("[\\s\\-()]", "");
        if (newNumber.matches("\\d{10}")) {
            System.out.println("Verified: " + newNumber);
            return true;
        }
        else{
            // Need to have the User type in a different or valid phone number.
            System.out.println(newNumber + " is invalid. Phone number not updated.");
            return false;
        }
    }

    public static boolean verifyEmail(String email){
        if(email.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
            System.out.println("Verified: " + email);
            return true;
        }
        else {
            // Need to have the User type in a different or valid email.
            System.out.println(email + " is invalid. E-Mail address not updated.");
            return false;
        }
    }
}