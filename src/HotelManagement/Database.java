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
        MainDb.add(u);
        assignRoom(u);
    }

    public void assignRoom(User u){
        int room = (u.getTier() - 1) * 100;
        for(int i = 0; i <= 99; i++) {
            if (rooms[room + i] == false) {
                rooms[room + i] = true;
                u.setRoomNum(room + i);
                break;
            }
        }
    }

    public void removeUser(User u){
        rooms[u.getRoomNum()] = false;
        MainDb.remove(0);
    }

    public void populateList(){
        User user1 = new User("Bobby", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user2 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user3 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user4 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user5 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user6 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user7 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user8 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user9 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");
        User user10 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user11 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 2, "villarst", "edI3n5u0", "03/27/2000");
        User user12 = new User("Steven Villarreal", "616-834-2729", "villarst@mail.gvsu.edu",
                600, 1, "villarst", "edI3n5u0", "03/27/2000");



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
//        removeUser(user1);
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
