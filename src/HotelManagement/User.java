package HotelManagement;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;



public class User {
    private String Name;
    private String PhoneNum;
    private String Email;
    private int accountBalance;
    private String username;
    private String password;
    private int roomNum;
    private int tier;
    private String dob;



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

    public User(){
        Name = null;
        PhoneNum = null;
        Email = null;
        this.accountBalance = 0;
        this.username = null;
        this.password = null;
        this.roomNum = -1;
        this.tier = 0;
        this.dob = null;
        Tier t = new Tier(0);
    }

    public String resetAll(){
        Name = null;
        PhoneNum = null;
        Email = null;
        accountBalance = 0;
        username = null;
        password = null;
        roomNum = -1;
        tier = 0;
        dob = null;
        return "Name: null, Phone Number: 0, Email: null, Account Balance: 0, Username: null" +
                "Password: null, Room Number: null, Tier: null, Date of Birth: null";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

}