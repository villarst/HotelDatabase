package HotelManagement;

public class Tier {
    private boolean poolAccess;
    private boolean gymAccess;
    private boolean pcAccess;
    private boolean buffetAccess;
    private boolean barAccess;
    private boolean hotTubAccess;
    private boolean casinoAccess;
    private boolean arcadeAccess;
    private boolean roomAccess;
    private boolean janitorRoomAccess;
    private int tier;

    public Tier(int tierLevel){
        tier = tierLevel;
        checkPermissions();
    }

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

    public boolean isPoolAccess() {
        return poolAccess;
    }

    public void setPoolAccess(boolean poolAccess) {
        this.poolAccess = poolAccess;
    }

    public boolean isGymAccess() {
        return gymAccess;
    }

    public void setGymAccess(boolean gymAccess) {
        this.gymAccess = gymAccess;
    }

    public boolean isPcAccess() {
        return pcAccess;
    }

    public void setPcAccess(boolean pcAccess) {
        this.pcAccess = pcAccess;
    }

    public boolean isBuffetAccess() {
        return buffetAccess;
    }

    public void setBuffetAccess(boolean buffetAccess) {
        this.buffetAccess = buffetAccess;
    }

    public boolean isBarAccess() {
        return barAccess;
    }

    public void setBarAccess(boolean barAccess) {
        this.barAccess = barAccess;
    }

    public boolean isHotTubAccess() {
        return hotTubAccess;
    }

    public void setHotTubAccess(boolean hotTubAccess) {
        this.hotTubAccess = hotTubAccess;
    }

    public boolean isCasinoAccess() {
        return casinoAccess;
    }

    public void setCasinoAccess(boolean casinoAccess) {
        this.casinoAccess = casinoAccess;
    }

    public boolean isArcadeAccess() {
        return arcadeAccess;
    }

    public void setArcadeAccess(boolean arcadeAccess) {
        this.arcadeAccess = arcadeAccess;
    }

    public boolean isRoomAccess() {
        return roomAccess;
    }

    public void setRoomAccess(boolean roomAccess) {
        this.roomAccess = roomAccess;
    }

    public boolean isJanitorRoomAccess() {
        return janitorRoomAccess;
    }

    public void setJanitorRoomAccess(boolean janitorRoomAccess) {
        this.janitorRoomAccess = janitorRoomAccess;
    }

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