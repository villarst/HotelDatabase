package HotelManagement;

public class Admin {

    private String username;
    private String password;
    private String workphone;
    private int tier;

    public Admin(String username, String password, String workphone) {
        Tier t = new Tier(tier);
        this.tier = tier;
        this.username = username;
        this.password = password;
        this.workphone = workphone;
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

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}