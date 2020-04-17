package hotelmanagement;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void constructor1(){
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
    }

    @Test
    public void constructor2(){
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3,"sftwreEgr", "10/05/1999");
    }

    @Test
    public void constructor3(){
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", "sftwreEgr",3, "10/05/1999");
    }

    @Test
    public void constructor4(){
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", "unsecurepassword", "unsecurepassword", 3, "10/05/1999");
    }

    @Test
    public void constructor5(){
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", "unsecurepassword", "unsecurepassword", 3, "10/05/1999", 548);
    }

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
    public void getNameFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getName().equals("Kippy"));
    }

    @Test
    public void setName() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setName("Ned");
        assertTrue(user1.getName().equals("Ned"));
    }

    @Test
    public void setNameFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setName("Ned");
        assertFalse(user1.getName().equals("Noryb"));
    }

    @Test
    public void getPhoneNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getPhoneNum().equals("2487199888"));
    }

    @Test
    public void getPhoneNumFalse() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getPhoneNum().equals("5482175907"));
    }

    @Test
    public void setPhoneNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPhoneNum("5482542767");
        assertTrue(user1.getPhoneNum().equals("5482542767"));
    }

    @Test
    public void setPhoneNumFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPhoneNum("5482542767");
        assertFalse(user1.getPhoneNum().equals("2487199888"));
    }

    @Test
    public void setPhoneNumFail2() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.setPhoneNum("email@internet.com"));
    }

    @Test
    public void getEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getEmail().equals("Noryb@gvsu.edu"));
    }

    @Test
    public void getEmailFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getEmail().equals("kaip@kaip.com"));
    }

    @Test
    public void setEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setEmail("nico@dema.org");
        assertTrue(user1.getEmail().equals("nico@dema.org"));
    }

    @Test
    public void setEmailFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setEmail("nico@dema.org");
        assertFalse(user1.getEmail().equals("Noryb@gvsu.edu"));
    }

    @Test
    public void setEmailFail2() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.setEmail("2487199888"));
    }

    @Test
    public void getUsername() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getUsername().equals("sftwreEgr"));
    }

    @Test
    public void getUsernameFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getUsername().equals("help"));
    }

    @Test
    public void setUsername() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setUsername("jasonstatham");
        assertTrue(user1.getUsername().equals("jasonstatham"));
    }

    @Test
    public void setUsernameFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setUsername("jasonstatham");
        assertFalse(user1.getUsername().equals("cosmostropharmutarianism"));
    }

    @Test
    public void getPassword() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getPassword().equals("unsecurepassword"));
    }

    @Test
    public void getPasswordFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getPassword().equals("securepassword"));
    }

    @Test
    public void setPassword() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPassword("fpe");
        assertTrue(user1.getPassword().equals("fpe"));
    }

    @Test
    public void setPasswordFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setPassword("fpe");
        assertFalse(user1.getPassword().equals("password"));
    }

    @Test
    public void getRoomNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getRoomNum() == 548);
    }

    @Test
    public void getRoomNumFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getRoomNum() == 118);
    }

    @Test
    public void setRoomNum() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setRoomNum(503);
        assertTrue(user1.getRoomNum() == 503);
    }

    @Test
    public void setRoomNumFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setRoomNum(503);
        assertFalse(user1.getRoomNum() == 548);
    }

    @Test
    public void getTier() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getTier() == 3);
    }

    @Test
    public void getTier2() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 0, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getTier() == 0);
    }

    @Test
    public void getTierFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getTier() == 2);
    }

    @Test
    public void setTier() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setTier(2);
        assertTrue(user1.getTier() == 2);
    }

    @Test
    public void setTierFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setTier(2);
        assertFalse(user1.getTier() == 3);
    }

    @Test
    public void getDob() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.getDob() == "10/05/1999");
    }

    @Test
    public void getDobFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.getDob() == "10/05/2018");
    }

    @Test
    public void setDob() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setDob("10/05/2018");
        assertTrue(user1.getDob() == "10/05/2018");
    }

    @Test
    public void setDobFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        user1.setDob("10/05/2018");
        assertFalse(user1.getDob() == "10/05/1999");
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
    public void verifyDateBlank() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyDate(""));
    }

    @Test
    public void verifyDateFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.verifyDate("10051999"));
    }

    @Test
    public void verifyPhoneNumber() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyPhoneNumber(user1.getPhoneNum()));
    }

    @Test
    public void verifyPhoneNumberFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.verifyPhoneNumber("two four eight seven one nine nine eight eight eight"));
    }

    @Test
    public void verifyEmail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyEmail(user1.getEmail()));
    }

    @Test
    public void verifyEmailFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.verifyEmail("10/05/1999"));
    }

    @Test
    public void verifyAll() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.verifyAll(user1.getEmail(), user1.getPhoneNum(), user1.getDob()));
    }

    @Test
    public void verifyAllFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.verifyAll("jason@kaip", "2487199888", "10/05/1999"));
    }

    @Test
    public void testToString() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.toString().equals(user1.getName() + "," + user1.getPhoneNum() + "," + user1.getEmail() + "," + user1.getUsername() + ","
                + user1.getPassword() + "," + user1.getTier() + "," + user1.getDob() + "," + user1.getRoomNum()));
    }

    @Test
    public void testToStringFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.toString().equals(user1.getName() + "," + user1.getName() + "," + user1.getName() + "," + user1.getName() + ","
                + user1.getName() + "," + user1.getName() + "," + user1.getName() + "," + user1.getName()));
    }

    @Test
    public void returnPermissions0() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 0, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.returnPermissions(user1.getTier()).equals("Pool Access: YES" + "\n" +
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

    @Test
    public void returnPermissions1() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 1, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.returnPermissions(user1.getTier()).equals("Pool Access: YES" + "\n" +
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

    @Test
    public void returnPermissions2() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 2, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertTrue(user1.returnPermissions(user1.getTier()).equals("Pool Access: YES" + "\n" +
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

    @Test
    public void returnPermissions3() {
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

    @Test
    public void returnPermissionsFail() {
        User user1 = new User("Noryb", "2487199888", "Noryb@gvsu.edu", 3, 548, "sftwreEgr", "unsecurepassword", "10/05/1999");
        assertFalse(user1.returnPermissions(user1.getTier()).equals("Pool Access: YES" + "\n" +
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