package HotelManagement;

import java .util.*;



public class Database{

    private ArrayList <User> MainDb;
    private ArrayList <User> SecondaryDb;

    public Database(){
        MainDb = new ArrayList<User>();
        SecondaryDb = new ArrayList<User>();
        populateList();

    }

    public void addUser(User u){
        MainDb.add(u);
        u.BasicInfo();
    }

    public void populateList(){
        User user1 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
        600, 5, "villarst", "1iEC5yTT", 215, "03/27/2000");

        MainDb.add(user1);
        user1.BasicInfo();

    }

}