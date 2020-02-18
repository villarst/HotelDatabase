import java.util.*;




public class Customer{
    private String Name;
    private String PhoneNum;
    private String Email;
    private int accountBalance;
    private String username;
    private String password;
    private int roomNum;
    private int tier;
    private String dob;

    public Customer(String name, String phoneNum, String email,
                    int accountBalance, String username, String password,
                    int roomNum, int tier, String dob) {
        Tier t = new Tier(tier);
        Name = name;
        PhoneNum = phoneNum;
        Email = email;
        this.accountBalance = accountBalance;
        this.username = username;
        this.password = password;
        this.roomNum = roomNum;
        this.tier = tier;
        this.dob = dob;
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
}