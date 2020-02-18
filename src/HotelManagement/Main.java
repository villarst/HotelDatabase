package HotelManagement;
import java.util.*;

public class Main {
    public static void main (String [] args){
        User u = new User ("Steve", "6168342729", "villarst@mail.gvsu.edu", 0, 5, "villarst", "1iEC5yTT", 0, "03/27/00");
        u.getAccountBalance();
        u.getEmail();
        u.getTier();
        u.toString();
    }
}