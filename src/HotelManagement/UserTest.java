package HotelManagement;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {

    @Test (expected = NullPointerException.class)
    public void resetAll() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.resetAll();
        user1.getName();
    }

    @Test
    public void getName() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getName().equals("Noryb"));
    }

    @Test
    public void setName() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setName("Ned");
        assertTrue(user1.getName().equals("Ned"));
    }

    @Test
    public void getPhoneNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getPhoneNum().equals("2487199888"));
    }

    @Test
    public void setPhoneNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPhoneNum("5482542767");
        assertTrue(user1.getPhoneNum().equals("5482542767"));
    }

    @Test
    public void getEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getEmail().equals("Noryb@gvsu.edu"));
    }

    @Test
    public void setEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setEmail("nico@dema.org");
        assertTrue(user1.getEmail().equals("nico@dema.org"));
    }

    @Test
    public void getUsername() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getUsername().equals("sftwreEgr"));
    }

    @Test
    public void setUsername() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setUsername("jasonstatham");
        assertTrue(user1.getUsername().equals("jasonstatham"));
    }

    @Test
    public void getPassword() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getPassword().equals("unsecurepassword"));
    }

    @Test
    public void setPassword() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPassword("fpe");
        assertTrue(user1.getPassword().equals("fpe"));
    }

    @Test
    public void getRoomNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getRoomNum() == 548);
    }

    @Test
    public void setRoomNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setRoomNum(503);
        assertTrue(user1.getRoomNum() == 503);
    }

    @Test
    public void getTier() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getTier() == 3);
    }

    @Test
    public void setTier() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setTier(2);
        assertTrue(user1.getTier() == 2);
    }

    @Test
    public void getDob() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getDob() == "10/05/1999");
    }

    @Test
    public void setDob() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setDob("10/05/2018");
        assertTrue(user1.getDob() == "10/05/2018");
    }

    @Test
    public void generatePassWApache(){
        Boolean result = true;
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
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

    @Test
    public void verifyDate() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyDate(user1.getDob()));
    }

    @Test
    public void verifyPhoneNumber() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyPhoneNumber(user1.getPhoneNum()));
    }

    @Test
    public void verifyEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyEmail(user1.getEmail()));
    }

    @Test
    public void verifyAll() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyAll(user1.getEmail(), user1.getPhoneNum(), user1.getDob()));
    }

    @Test
    public void testToString() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.toString().equals(user1.getName() + "," + user1.getPhoneNum() + "," + user1.getEmail() + "," + user1.getUsername() + ","
                + user1.getPassword() + "," + user1.getTier() + "," + user1.getDob() + "," + user1.getRoomNum()));
    }

    @Test
    public void returnPermissions() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.returnPermissions(user1.getTier()).equals("Pool Access: YES" + "\n" +
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
}