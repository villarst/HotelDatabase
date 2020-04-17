package hotelmanagement;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable{
    private transient SimpleStringProperty Name;
    private transient SimpleStringProperty PhoneNum;
    private transient SimpleStringProperty Email;
    private transient SimpleStringProperty username;
    private transient SimpleStringProperty password;
    private int roomNum;
    private int tier;
    private transient SimpleStringProperty dob;

//    public Tier t;

    // Used to add a user to the ObservableList<User> users array list for viewing in the table.
    public User(String name, String phoneNum, String email, int tier, String username, String dobirth) throws IllegalArgumentException{
        this.Name = new SimpleStringProperty(name);
        this.username = new SimpleStringProperty(username);
        this.tier = tier;
//        t = new Tier(tier);
        this.password = new SimpleStringProperty(generatePassWApache());

        //Verification here is redundant and causes message to popup twice.
        //if(verifyPhoneNumber(phoneNum)){
            this.PhoneNum = new SimpleStringProperty(phoneNum);
        //}
        //if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        //}
        //if(verifyDate(dobirth)){
            this.dob = new SimpleStringProperty(dobirth);
        //}
    }

    // Used to add a user to the ObservableList<User> users array list with roomNum.
    public User(String name, String phoneNum, String email, int tier, int room, String username, String pass, String dobirth) throws IllegalArgumentException{
        this.Name = new SimpleStringProperty(name);
        this.username = new SimpleStringProperty(username);
        this.tier = tier;
        this.roomNum = room;
        this.tier = tier;
        this.password = new SimpleStringProperty(pass);
        if(verifyPhoneNumber(phoneNum)){
            this.PhoneNum = new SimpleStringProperty(phoneNum);
        }
        if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        }
        if(verifyDate(dobirth)){
            this.dob = new SimpleStringProperty(dobirth);
        }
    }

    // Used to add admin to the SecondaryDb.
    public User(String n, String num, String email, String username, int tier, String dob){
        this.Name = new SimpleStringProperty(n);
        if(verifyPhoneNumber(num)){
            this.PhoneNum = new SimpleStringProperty(num);
        }
        if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        }
        this.username = new SimpleStringProperty((username));
        this.password = new SimpleStringProperty(generatePassWApache());
        this.roomNum = -1;

        if(tier == 0) {
            this.tier = 0;
        }
        if(verifyDate(dob)){
            this.dob = new SimpleStringProperty(dob);
        }
    }


    // Used to add admin to the users <ObservableList>.
    public User(String n, String num, String email, String username, String pass, int tier, String dob){
        this.Name = new SimpleStringProperty(n);
        if(verifyPhoneNumber(num)){
            this.PhoneNum = new SimpleStringProperty(num);
        }
        if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        }
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(pass);
        this.roomNum = -1;

        if(tier == 0) {
            this.tier = 0;
        }
        if(verifyDate(dob)){
            this.dob = new SimpleStringProperty(dob);
        }
    }


    // Used to load in admin to the Db
    public User(String n, String num, String email, String username, String pass, int tier, String dob, int roomNum){
        this.Name = new SimpleStringProperty(n);
        if(verifyPhoneNumber(num)){
            this.PhoneNum = new SimpleStringProperty(num);
        }
        if(verifyEmail(email)){
            this.Email = new SimpleStringProperty(email);
        }
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(pass);

        if(tier == 0) {
            this.tier = 0;
        }
        else{
            this.tier = tier;
        }
        if(verifyDate(dob)){
            this.dob = new SimpleStringProperty(dob);
        }
        this.roomNum = roomNum;
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

    public void setName(String name) {
        Name = new SimpleStringProperty(name);
    }

    public String getPhoneNum() {
        return PhoneNum.get();
    }

    // changed to boolean for tableViewController edit columns
    public boolean setPhoneNum(String phoneNum){
        if(verifyPhoneNumber(phoneNum)) {
            this.PhoneNum = new SimpleStringProperty(phoneNum);
            return true;
        }
        return false;
    }

    public String getEmail() {
        return Email.get();
    }

    // changed to boolean for tableViewController edit columns
    public boolean setEmail(String email){
        if(verifyEmail(email)) {
            this.Email = new SimpleStringProperty(email);
            return true;
        }
        return false;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username = new SimpleStringProperty(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
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
//                System.out.println("Verified: " + date);
            }
            catch (ParseException e) {
                try{
                    Date javaDate = simpleDateFormatShort.parse(date);
//                    System.out.println("Verified: " + date);
                }
                catch (ParseException e1){
                    System.out.println(date + " is not a valid date. DOB not updated.");
                    new Alert(Alert.AlertType.ERROR, "Please enter a valid date of birth").showAndWait();
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean verifyPhoneNumber(String newNumber){
        newNumber = newNumber.replaceAll("[\\s\\-()]", "");
        if (newNumber.matches("\\d{10}")) {
//            System.out.println("Verified: " + newNumber);
            return true;
        }
        else{
            // Need to have the User type in a different or valid phone number.
            System.out.println(newNumber + " is invalid. Phone number not updated.");
            new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number").showAndWait();
            return false;
        }
    }

    public static boolean verifyEmail(String email){
        if(email.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")) {
//            System.out.println("Verified: " + email);
            return true;
        }
        else {
            // Need to have the User type in a different or valid email.
            System.out.println(email + " is invalid. E-Mail address not updated.");
            new Alert(Alert.AlertType.ERROR, "Please enter a valid email").showAndWait();
            return false;
        }
    }

    // Verifies all fields are bad or good.
    public static boolean verifyAll(String email, String newNumber, String date){
        if(verifyDate(date) && verifyEmail(email) && verifyPhoneNumber(newNumber) == true){
            return true;
        }
        return false;
    }

    // To string to print the User from its memory address.
    @Override
    public String toString(){
        // all the getters were just the variable names so getName() was Name, getPhoneNum() was PhoneNum, ETC
        return getName() + "," + getPhoneNum() + "," + getEmail() + "," + getUsername() + ","
                + getPassword() + "," + getTier() + "," + getDob() + "," + getRoomNum();
    }
    

    public String returnPermissions(int tier){
        String permissions = "";
        switch (tier){
            case 1: // pool, pc, hot tub access
                permissions =("Pool Access: YES" + "\n" +
                        "Gym Access: NO" + "\n" +
                        "PC Room Access: YES" + "\n" +
                        "Bar Access: NO" + "\n" +
                        "Casino Access: NO" + "\n" +
                        "Buffet Access: NO" + "\n" +
                        "Hot Tub Access: YES" + "\n" +
                        "Arcade Room Access: NO" + "\n" +
                        "Admin Access: NO" + "\n" +
                        "Room Access: YES" + "\n" +
                        "All Room Access: NO" + "\n" );
                break;
            case 2: // pool, pc, hot tub, gym, buffet access
                permissions =("Pool Access: YES" + "\n" +
                        "Gym Access: YES" + "\n" +
                        "PC Room Access: YES" + "\n" +
                        "Bar Access: NO" + "\n" +
                        "Casino Access: NO" + "\n" +
                        "Buffet Access: YES" + "\n" +
                        "Hot Tub Access: YES" + "\n" +
                        "Arcade Room Access: NO" + "\n" +
                        "Admin Access: NO" + "\n" +
                        "Room Access: YES" + "\n" +
                        "All Room Access: NO" + "\n" );
                break;
            case 3: // pool, pc, hot tub, gym, bar, casino, buffet, arcade access.
                permissions =("Pool Access: YES" + "\n" +
                        "Gym Access: YES" + "\n" +
                        "PC Room Access: YES" + "\n" +
                        "Bar Access: YES" + "\n" +
                        "Casino Access: YES" + "\n" +
                        "Buffet Access: YES" + "\n" +
                        "Hot Tub Access: YES" + "\n" +
                        "Arcade Room Access: YES" + "\n" +
                        "Admin Access: NO" + "\n" +
                        "Room Access: YES" + "\n" +
                        "All Room Access: NO" + "\n" );
                break;
            case 0: // admin access.
                permissions =("Pool Access: YES" + "\n" +
                        "Gym Access: YES" + "\n" +
                        "PC Room Access: YES" + "\n" +
                        "Bar Access: YES" + "\n" +
                        "Casino Access: YES" + "\n" +
                        "Buffet Access: YES" + "\n" +
                        "Hot Tub Access: YES" + "\n" +
                        "Arcade Room Access: YES" + "\n" +
                        "Admin Access: YES" + "\n" +
                        "Room Access: YES" + "\n" +
                        "All Room Access: YES" + "\n" );
                break;
            default:
                System.out.println("No Tier inputted.");
        }
        return permissions;
    }
}