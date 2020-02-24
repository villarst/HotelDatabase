package HotelManagement;

import java.lang.reflect.Array;
import java.util.*;


public class Database{

    private ArrayList <User> MainDb;
    private ArrayList <User> SecondaryDb;

    private ArrayList <Integer> tier1Rooms;
    private ArrayList <Integer> tier2Rooms;
    private ArrayList <Integer> tier3Rooms;
    private ArrayList <Integer> tier4Rooms;
    private ArrayList <Integer> tier5Rooms;



    public Database(){
        MainDb = new ArrayList<User>();
        SecondaryDb = new ArrayList<User>();
        tier1Rooms = new ArrayList<Integer>();
        tier2Rooms = new ArrayList<Integer>();
        tier3Rooms = new ArrayList<Integer>();
        tier4Rooms = new ArrayList<Integer>();
        tier5Rooms = new ArrayList<Integer>();

        populateList();
    }

    public void addUser(User u){
        MainDb.add(u);
        assignRoom(u);
    }


    public void assignRoom(User u) {
        // The tier level is 1.
        if(u.getTier() == 1){
            // Case 1: No rooms have been assigned.
            if(tier1Rooms.isEmpty()){
                u.setRoomNum(100);
                tier1Rooms.add(100);
            }
            else{
                // Case 2: Rooms have been assigned already, not fully booked with rooms.
                if(tier1Rooms.size() <= 100 && tier1Rooms.get(tier1Rooms.size()-1) != 199) {
                    int count = 0;
                    while (tier1Rooms.size() > count) {
                        count++;
                    }
                    u.setRoomNum(count + 100);
                    tier1Rooms.add(count + 100);
                }
                // Case 3: Rooms have been assigned already and fully booked.
                else{
                    System.out.println("Sorry, but all rooms have been taken for the Tier 1 Package \n" +
                                        "Please select a Different Tier Package.");
                }
            }
        }
        if(u.getTier() == 2){
            // Case 4: No rooms have been assigned.
            if(tier2Rooms.isEmpty()){
                u.setRoomNum(200);
                tier2Rooms.add(200);
            }
            else{
                // Case 5: Rooms have been assigned already, not fully booked with rooms.
                if(tier2Rooms.size() <= 100 && tier2Rooms.get(tier2Rooms.size()-1) != 299) {
                    int count = 0;
                    while (tier2Rooms.size() > count) {
                        count++;
                    }
                    u.setRoomNum(count + 200);
                    tier2Rooms.add(count + 200);
                }
                // Case 6: Rooms have been assigned already and fully booked.
                else{
                    System.out.println("Sorry, but all rooms have been taken for the Tier 1 Package \n" +
                            "Please select a Different Tier Package.");
                }
            }
        }
        if(u.getTier() == 3){
            // Case 7: No rooms have been assigned.
            if(tier3Rooms.isEmpty()){
                u.setRoomNum(300);
                tier3Rooms.add(300);
            }
            else{
                // Case 8: Rooms have been assigned already, not fully booked with rooms.
                if(tier3Rooms.size() <= 100 && tier3Rooms.get(tier3Rooms.size()-1) != 399) {
                    int count = 0;
                    while (tier3Rooms.size() > count) {
                        count++;
                    }
                    u.setRoomNum(count + 300);
                    tier3Rooms.add(count + 300);
                }
                // Case 9: Rooms have been assigned already and fully booked.
                else{
                    System.out.println("Sorry, but all rooms have been taken for the Tier 1 Package \n" +
                            "Please select a Different Tier Package.");
                }
            }
        }
        if(u.getTier() == 4){
            // Case 10: No rooms have been assigned.
            if(tier4Rooms.isEmpty()){
                u.setRoomNum(400);
                tier4Rooms.add(400);
            }
            else{
                // Case 11: Rooms have been assigned already, not fully booked with rooms.
                if(tier4Rooms.size() <= 100 && tier4Rooms.get(tier4Rooms.size()-1) != 499) {
                    int count = 0;
                    while (tier4Rooms.size() > count) {
                        count++;
                    }
                    u.setRoomNum(count + 400);
                    tier4Rooms.add(count + 400);
                }
                // Case 12: Rooms have been assigned already and fully booked.
                else{
                    System.out.println("Sorry, but all rooms have been taken for the Tier 1 Package \n" +
                            "Please select a Different Tier Package.");
                }
            }
        }
        if(u.getTier() == 5){
            // Case 13: No rooms have been assigned.
            if(tier5Rooms.isEmpty()){
                u.setRoomNum(500);
                tier5Rooms.add(500);
            }
            else{
                // Case 14: Rooms have been assigned already, not fully booked with rooms.
                if(tier5Rooms.size() <= 100 && tier5Rooms.get(tier5Rooms.size()-1) != 599) {
                    int count = 0;
                    while (tier5Rooms.size() > count) {
                        count++;
                    }
                    u.setRoomNum(count + 500);
                    tier5Rooms.add(count + 500);
                }
                // Case 15: Rooms have been assigned already and fully booked.
                else{
                    System.out.println("Sorry, but all rooms have been taken for the Tier 1 Package \n" +
                            "Please select a Different Tier Package.");
                }
            }
        }
    }

    public void populateList(){
        User user1 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user2 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user3 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user4 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user5 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user6 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user7 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user8 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user9 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user10 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user11 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");
        User user12 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 5, "villarst", "edI3n5u0", "03/27/2000");



        addUser(user1);
        addUser(user2);
        addUser(user3);
        addUser(user4);
        addUser(user5);
        addUser(user6);
        addUser(user7);
        addUser(user8);
        addUser(user9);
        addUser(user10);
        addUser(user11);
        addUser(user12);

        user1.BasicInfo();
        user2.BasicInfo();
        user3.BasicInfo();
        user4.BasicInfo();
        user5.BasicInfo();
        user6.BasicInfo();
        user7.BasicInfo();
        user8.BasicInfo();
        user9.BasicInfo();
        user10.BasicInfo();
        user11.BasicInfo();
        user12.BasicInfo();
    }

}
