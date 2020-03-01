package HotelManagement;

import java.util.*;


public class Database{

    private ArrayList <User> MainDb;
    boolean rooms [];


    public Database(){
        MainDb = new ArrayList<User>();
        rooms = new boolean[500];
        for(int i = 0; i < 500; i++){
            rooms[i] = false;
        }
        populateList();
    }

    public void addUser(User u){
        if(!checkTierFull(u.getTier() - 1)){
            MainDb.add(u);
            assignRoom(u);
        }
        else{
            System.out.println("Sorry rooms are full.");
        }
    }

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

    public void removeUser(User u){
        if(u.getRoomNum() != -1) {
            rooms[u.getRoomNum()] = false;
        }
        MainDb.remove(u);
    }

    public void populateList(){
        User user1 = new User("Bobby", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user2 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user3 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user4 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user5 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user6 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user7 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user8 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user9 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user10 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user11 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user12 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");



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

    }

}
