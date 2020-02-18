package HotelManagement;
import java.util.*;

public class Main {
    public static void main (String [] args){
        Customer c = new Customer ("Steve", "6168342729", "villarst@mail.gvsu.edu", 0, 5, "villarst", "1iEC5yTT", 0, "03/27/00");
        c.getAccountBalance();
        c.getEmail();
        c.getTier();
        c.toString();
    }
}