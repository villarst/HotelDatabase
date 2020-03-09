package HotelManagement;
/*****************************************************************
 The tier program is to give access to users of the hotel different
activities such as the gym, hot tub, bar, ect. The tiers make it
 easy to recognize what the user is allowed to do such as tier 1
 being to most restrictive, up to tier 6 which is the admin tier
 who has access to everything.

 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/
public class Tier {

    /** Allows access to the pool */
    private boolean poolAccess;

    /** Allows access to the gym */
    private boolean gymAccess;

    /** Allows access to the pc */
    private boolean pcAccess;

    /** Allows access to the buffet */
    private boolean buffetAccess;

    /** Allows access to the bar */
    private boolean barAccess;

    /** Allows access to the hot tub */
    private boolean hotTubAccess;

    /** Allows access to the casino */
    private boolean casinoAccess;

    /** Allows access to the arcade */
    private boolean arcadeAccess;

    /** Allows access to room */
    private boolean roomAccess;

    /** Allows access to the janitor room */
    private boolean janitorRoomAccess;

    /** Gives a tier number */
    private int tier;

    /*****************************************************************
     Constructor that assigns the tier level and checks the permissions
     @param tierLevel gives the tier level number
     *****************************************************************/
    public Tier(int tierLevel){
        tier = tierLevel;
        checkPermissions();
    }
    /*****************************************************************
     Constructor that assigns a true or false value if the tier has
     access to that section of the hotel
     *****************************************************************/
    public void checkPermissions(){
        switch (tier){
            case 1:
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = false;
                gymAccess = false;
                barAccess = false;
                casinoAccess = false;
                buffetAccess = false;
                arcadeAccess = false;
                break;
            case 2:
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = false;
                barAccess = false;
                casinoAccess = false;
                buffetAccess = false;
                arcadeAccess = false;
                break;
            case 3:
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = false;
                casinoAccess = false;
                buffetAccess = false;
                arcadeAccess = false;
                break;
            case 4:
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = true;
                casinoAccess = true;
                buffetAccess = false;
                arcadeAccess = false;
                break;
            case 5:
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = true;
                casinoAccess = true;
                buffetAccess = true;
                arcadeAccess = true;
                break;
            case 6: // Admin Access
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = true;
                casinoAccess = true;
                buffetAccess = true;
                arcadeAccess = true;
                roomAccess = true;
                janitorRoomAccess = true;
            default:
                System.out.println("You have chosen no tier level..");
        }
    }

    /*****************************************************************
     tells the hotel if the user has access to the pool
     @return poolAccess returns if they are allowed to use the pool
     *****************************************************************/
    public boolean isPoolAccess() {
        return poolAccess;
    }

    /*****************************************************************
     sets the pool access.
     @param poolAccess
     *****************************************************************/
    public void setPoolAccess(boolean poolAccess) {
        this.poolAccess = poolAccess;
    }

    /*****************************************************************
     tells the hotel if the user has access to the gym
     @return gymAccess returns if they are allowed to use the gym
     *****************************************************************/
    public boolean isGymAccess() {
        return gymAccess;
    }

    /*****************************************************************
     sets the gym access.
     @param gymAccess
     *****************************************************************/
    public void setGymAccess(boolean gymAccess) {
        this.gymAccess = gymAccess;
    }

    /*****************************************************************
     tells the hotel if the user has access to the pc's
     @return pcAccess returns if they are allowed to use the pc's
     *****************************************************************/
    public boolean isPcAccess() {
        return pcAccess;
    }

    /*****************************************************************
     sets the pc access.
     @param pcAccess
     *****************************************************************/
    public void setPcAccess(boolean pcAccess) {
        this.pcAccess = pcAccess;
    }

    /*****************************************************************
     tells the hotel if the user has access to the buffet
     @return buffetAccess returns if they are allowed to use the buffet
     *****************************************************************/
    public boolean isBuffetAccess() {
        return buffetAccess;
    }

    /*****************************************************************
     sets the buffet access.
     @param buffetAccess
     *****************************************************************/
    public void setBuffetAccess(boolean buffetAccess) {
        this.buffetAccess = buffetAccess;
    }

    /*****************************************************************
     tells the hotel if the user has access to the bar
     @return barAccess returns if they are allowed to use the bar
     *****************************************************************/
    public boolean isBarAccess() {
        return barAccess;
    }

    /*****************************************************************
     sets the bar access.
     @param barAccess
     *****************************************************************/
    public void setBarAccess(boolean barAccess) {
        this.barAccess = barAccess;
    }

    /*****************************************************************
     Constructor that tells the hotel if the user has access to the hot tub
     @return hotTubAccess returns if they are allowed to use the hot tub
     *****************************************************************/
    public boolean isHotTubAccess() {
        return hotTubAccess;
    }

    /*****************************************************************
     Constructor that sets the hot tub access.
     @param hotTubAccess
     *****************************************************************/
    public void setHotTubAccess(boolean hotTubAccess) {
        this.hotTubAccess = hotTubAccess;
    }

    /*****************************************************************
     Constructor that tells the hotel if the user has access to the casino
     @return casinoAccess returns if they are allowed to use the casino
     *****************************************************************/
    public boolean isCasinoAccess() {
        return casinoAccess;
    }

    /*****************************************************************
     Constructor that sets the casino access.
     @param casinoAccess
     *****************************************************************/
    public void setCasinoAccess(boolean casinoAccess) {
        this.casinoAccess = casinoAccess;
    }

    /*****************************************************************
     Constructor that tells the hotel if the user has access to the arcade
     @return arcadeAccess returns if they are allowed to use the arcade
     *****************************************************************/
    public boolean isArcadeAccess() {
        return arcadeAccess;
    }

    /*****************************************************************
     Constructor that sets the arcade access.
     @param arcadeAccess
     *****************************************************************/
    public void setArcadeAccess(boolean arcadeAccess) {
        this.arcadeAccess = arcadeAccess;
    }

    /*****************************************************************
     Constructor that tells the hotel if the user has access to their room
     @return roomAccess returns if they are allowed to use their room
     *****************************************************************/
    public boolean isRoomAccess() {
        return roomAccess;
    }

    /*****************************************************************
     Constructor that sets the arcade access.
     @param roomAccess
     *****************************************************************/
    public void setRoomAccess(boolean roomAccess) {
        this.roomAccess = roomAccess;
    }

    /*****************************************************************
     Constructor that tells the hotel if the user has access to the janitor room
     @return janitorRoomAccess returns if they are allowed to use the janitor room
     *****************************************************************/
    public boolean isJanitorRoomAccess() {
        return janitorRoomAccess;
    }

    /*****************************************************************
     Constructor that sets the Janitor room access.
     @param janitorRoomAccess
     *****************************************************************/
    public void setJanitorRoomAccess(boolean janitorRoomAccess) {
        this.janitorRoomAccess = janitorRoomAccess;
    }

    /*****************************************************************
     Constructor that displays all of the hotel activites and if the
     user has access to them or not
     *****************************************************************/
    public void displayPermissions(){
        System.out.println("Pool Access: " + isPoolAccess());
        System.out.println("Gym Access: " + isGymAccess());
        System.out.println("Pc Room Access: " + isPcAccess());
        System.out.println("Bar Access: " + isBarAccess());
        System.out.println("Casino Access: " + isCasinoAccess());
        System.out.println("Buffet Access: " + isBuffetAccess());
        System.out.println("Hot Tub Access: " + isHotTubAccess());
        System.out.println("Arcade Room Access: " + isArcadeAccess());
        System.out.println("Janitors Room Access: " + isJanitorRoomAccess());
        System.out.println("All Room Access: " + isRoomAccess());
    }
}