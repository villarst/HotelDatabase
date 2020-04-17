package HotelManagement;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {


    // adds a user
    @Test
    void addUser1() {
        Database d1 = new Database();
        User u1 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u1);
        assertEquals(0, u1.getRoomNum());
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u2);
        assertEquals(1, u2.getRoomNum());
    }

    // adds a user that is overflown.
    @Test
    void addUser2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Database d1 = new Database();
        for(int i = 0; i <= 99; i++){
            User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                    1, "villarst", "03/27/00");
            d1.addUser(u);
        }
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);
        String output = new String(outContent.toByteArray());
        assertTrue(output.contains("The tier is full, please select a different tier."));
    }

    // adds an admin.
    @Test
    void addAdmin() {
        Database d1 = new Database();
        User a = new User("Bob Nichols", "7412345481", "bobn@att.com", "bobbyboi",
                0, "12/25/87");
        d1.addAdmin(a);
        Assert.assertEquals(-1, d1.getUserSecondaryDb(0).getRoomNum());
    }

    // clears the rooms maindb and secondarydb.
    @Test
    void clearDb() {
        Database d1 = new Database();
        for(int i = 0; i <= 99; i++){
            User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                    1, "villarst", "03/27/00");
            d1.addUser(u);
        }
        d1.clearDb();
        for(int i = 0; i < 300; i++){
            Assert.assertFalse(d1.getRooms(i));
        }

    }

    @Test
    void viewRoom() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);
        User u1 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                2, "villarst", "03/27/00");
        d1.addUser(u1);
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                3, "villarst", "03/27/00");
        d1.addUser(u2);
        Assert.assertEquals(0, d1.viewRoom(0));
        Assert.assertEquals(100, d1.viewRoom(1));
        Assert.assertEquals(200, d1.viewRoom(2));
    }

    @Test
    void getUser() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, 0, "villarst",  "1234", "03/27/00");
        d1.addUser(u);
        Assert.assertEquals(u, d1.getUser(0));
    }

    @Test
    void findUser() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);
        User u1 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                2, "villarst", "03/27/00");
        d1.addUser(u1);
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u2);
        Assert.assertEquals(u2, d1.findUser(u2));
    }

    @Test
    void removeUser() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);
        User u1 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                2, "villarst", "03/27/00");
        d1.addUser(u1);
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                3, "villarst", "03/27/00");
        d1.addUser(u2);

        d1.removeUser(u);
        d1.removeUser(u1);
        d1.removeUser(u2);
        Assert.assertEquals(false, d1.getRooms(0));
        Assert.assertEquals(false, d1.getRooms(100));
        Assert.assertEquals(false, d1.getRooms(200));

    }

    @Test
    void searchUser() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);
        User u1 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                2, "villarst", "03/27/00");
        d1.addUser(u1);
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                3, "villarst", "03/27/00");
        d1.addUser(u2);

        d1.searchUser(u);
        d1.searchUser(u1);
        d1.searchUser(u2);
        Assert.assertEquals(false, d1.getRooms(0));
        Assert.assertEquals(false, d1.getRooms(100));
        Assert.assertEquals(false, d1.getRooms(200));
    }

    @Test
    void searchSecondary1() {
        Database d1 = new Database();
        User a = new User("Bob Nichols", "7412345481", "bobn@att.com", "bobbyboi",
                0, "12/25/87");
        d1.addAdmin(a);
        Assert.assertEquals(true, d1.searchSecondary(a.getPassword()));
    }

    @Test
    void searchSecondary2() {
        Database d1 = new Database();
        User a = new User("Bob Nichols", "7412345481", "bobn@att.com", "bobbyboi",
                0, "12/25/87");
        d1.addAdmin(a);
        Assert.assertEquals(false, d1.searchSecondary("not right"));
    }

    @Test
    void getUserSecondaryDb() {
        Database d1 = new Database();
        User a = new User("Bob Nichols", "7412345481", "bobn@att.com", "bobbyboi",
                0, "12/25/87");
        d1.addAdmin(a);
        Assert.assertEquals(a, d1.getUserSecondaryDb(0));
    }

    @Test
    void addUserFromLoad() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, 0, "villarst",  "1234", "03/27/00");
        d1.addUserFromLoad(u);
        Assert.assertEquals(u, d1.getUser(0));
    }

    @Test
    void secondaryDbSize() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                0, "villarst", "03/27/00");
        d1.addAdmin(u);
        User u2 = new User("Corey R", "6168342729", "ricecore@mail.gvsu.edu", 0,
                "villarst", "03/27/00");
        d1.addAdmin(u2);
        User u3 = new User("Jason", "6168342729", "kaipjaso@mail.gvsu.edu", 0,
                "villarst", "03/27/00");
        d1.addAdmin(u3);

        Assert.assertEquals(3,d1.secondaryDbSize());
    }

    @Test
    void testToString1() {
        Database d1 = new Database();
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        d1.addUser(u);

        assertEquals("Steven Villarreal , 6168342323 , villarst@mail.com , villarst , " +
                        d1.getUser(0).getPassword() + " , 1 , 03/27/00 , " +
                        d1.getUser(0).getRoomNum() + "\n", d1.toString());
    }
    @Test
    void testToString2() {
        Database d1 = new Database();
        User a = new User("Bob Nichols", "7412345481", "bobn@att.com", "bobbyboi",
                0, "12/25/87");
        d1.addAdmin(a);
        assertEquals("Bob Nichols , 7412345481 , bobn@att.com , bobbyboi , " +
                d1.getUserSecondaryDb(0).getPassword() + " , 0 , 12/25/87 , " +
                d1.getUserSecondaryDb(0).getRoomNum() + "\n", d1.toString());
    }
}
