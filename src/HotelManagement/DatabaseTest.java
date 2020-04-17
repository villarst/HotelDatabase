package HotelManagement;

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
    }

    @Test
    void testToString() {
    }
}
