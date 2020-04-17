package HotelManagement;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {


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

    @Test
    void addUser2() {
        Database d1 = new Database();
        for(int i = 0; i <= 99; i++){
            User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                    1, "villarst", "03/27/00");
            d1.addUser(u);
        }
        User u = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                1, "villarst", "03/27/00");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            d1.addUser(u);
        });
    }

    @Test
    void addUserFromLoad() {
    }

    @Test
    void addAdmin() {
    }

    @Test
    void clearDb() {
    }

    @Test
    void getMainDb() {
    }

    @Test
    void assignRoom() {
    }

    @Test
    void viewRoom() {
    }

    @Test
    void getUser() {
    }

    @Test
    void findUser() {
    }

    @Test
    void checkTierFull() {
    }

    @Test
    void removeUser() {
    }

    @Test
    void searchUser() {
    }

    @Test
    void searchSecondary() {
    }

    @Test
    void getUserSecondaryDb() {
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

        assertEquals("Steven Villarreal,6168342323,villarst@mail.com,villarst," + d1.getUser(0).getPassword() + ",1,03/27/00,0", u.toString());
    }
    @Test
    void testToString2() {
        Database d1 = new Database();
        User u2 = new User("Steven Villarreal", "6168342323", "villarst@mail.com",
                0, "villarst", "03/27/00");
        d1.addAdmin(u2);

        assertEquals("Steven Villarreal,6168342323,villarst@mail.com,villarst," + d1.getUserSecondaryDb(0).getPassword() + ",0,03/27/00,0", u2.toString());
    }
}