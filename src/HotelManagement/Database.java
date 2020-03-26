package HotelManagement;

import java.util.*;

/*****************************************************************
 This class consists of the database that will be used to store,
 remove, and assign rooms to the users (Guests).
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/
public class Database{
    /** Arraylist that stores the Users */
    private ArrayList <User> MainDb;
    /** Boolean Array that stores values for the rooms. */
    boolean rooms [];

    /*****************************************************************
     Constructor that creates a Database to use to store Users and
     assign rooms.
     *****************************************************************/
    public Database(){
        // initialize the Arraylist to hold the users and initialize the rooms Array.
        MainDb = new ArrayList<User>();
        rooms = new boolean[300];
        for(int i = 0; i < 300; i++){
            rooms[i] = false;
        }
    }

    /*****************************************************************
     Adds the user to the Arraylist.
     @param u the User that is passed into
            the method that will be added.
     *****************************************************************/
    public void addUser(User u){
        if(!checkTierFull(u.getTier() - 1)){
            MainDb.add(u);
            assignRoom(u);
        }
        else{
            System.out.println("Sorry rooms are full.");
        }
    }

    /*****************************************************************
     Assigns the room to the user that was just added to the Arraylist.
     @param u the User that is passed into
            the method that was just added.
     *****************************************************************/
    public void assignRoom(User u){
        int room = (u.getTier() - 1) * 100;
        if(!checkTierFull(u.getTier() - 1)) {
            for (int i = 0; i <= 99; i++) { // was 99
                if (!rooms[room + i]) {
                    rooms[room + i] = true;
                    u.setRoomNum(room + i);
                    System.out.println(u.getRoomNum());
                    break;
                }
            }
        }
    }

    public int viewRoom(int i){
        return MainDb.get(i).getRoomNum();
    }

    public User getUser(int i){
        return MainDb.get(i);
    }

    public User findUser(User u){
        User found = null;
        for(int i = 0; i < MainDb.size(); i++){
            if(u.getRoomNum() == MainDb.get(i).getRoomNum()){
                found = MainDb.get(i);
            }
        }
        return found;
    }

    /*****************************************************************
     Checks if the room is occupied if so returns a boolean of true
     or false.
     @param t the tier that of the User that was passed into the
            the method.
     *****************************************************************/
    public boolean checkTierFull(int t){
        int tier = t * 100;
        for(int i = tier; i <= tier + 99; i++){  // was 99
            // This checks if any room is empty. If yes then returns false.
            // Otherwise returns true.
            if(!rooms[i])
                return false;
        }
        return true;
    }

    /*****************************************************************
     Removes the User from the Arraylist MainDb.
     @param u the User that is wanting to be removed.
     *****************************************************************/
    public void removeUser(User u){
        if(u.getRoomNum() != -1) {
            rooms[u.getRoomNum()] = false;
        }
        MainDb.remove(u);
    }

    /*****************************************************************
     Creates Users and adds them to the database MainDb.
     *****************************************************************/
//    public void populateList(){
//        User user1 = new User("Bobby", "616-834-2729", "villarst@mail.gvsu.edu", 2,
//                "villarst", "03/27/2000");
//        User user2 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
//                2, "villarst", "03/27/2000");
//        User user3 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user4 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user5 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user6 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user7 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 1, "villarst", "03/27/2000");
//        User user8 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user9 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user10 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user11 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 2, "villarst", "03/27/2000");
//        User user12 = new User("Steven Villarreal", "616-834-2729",
//                "villarst@mail.gvsu.edu", 3, "villarst", "03/27/2000");
//
//
//        // Adds the just created Users to the database.
//        addUser(user1);
//        addUser(user2);
//        addUser(user3);
//        addUser(user4);
//        addUser(user5);
//        addUser(user6);
//        addUser(user7);
//        addUser(user8);
//        addUser(user9);
//        addUser(user10);
//        addUser(user11);
//        addUser(user12);
//
//    }

}
