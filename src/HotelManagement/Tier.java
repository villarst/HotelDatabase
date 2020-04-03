package HotelManagement;

public class Tier {
    private boolean poolAccess; //1
    private boolean gymAccess;
    private boolean pcAccess;
    private boolean buffetAccess;
    private boolean barAccess;
    private boolean hotTubAccess;
    private boolean casinoAccess;
    private boolean arcadeAccess;
    private boolean roomAccess;
    private boolean adminAccess;
    private boolean allRoomAccess;
    private int tier;

    public Tier(int tierLevel){
        tier = tierLevel;
        checkPermissions();
    }

    public void checkPermissions(){
        switch (tier){
            case 1: // pool, pc, hot tub access
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = false;
                barAccess = false;
                casinoAccess = false;
                buffetAccess = false;
                arcadeAccess = false;
                break;
            case 2: // pool, pc, hot tub, gym, buffet access
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = false;
                casinoAccess = false;
                buffetAccess = true;
                arcadeAccess = false;
                break;
            case 3: // pool, pc, hot tub, gym, bar, casino, buffet, arcade access.
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = true;
                casinoAccess = true;
                buffetAccess = true;
                arcadeAccess = true;
                break;
            case 0: // admin access.
                poolAccess = true;
                pcAccess = true;
                hotTubAccess = true;
                gymAccess = true;
                barAccess = true;
                casinoAccess = true;
                buffetAccess = true;
                arcadeAccess = true;
                adminAccess = true;
                roomAccess = true;
                allRoomAccess = true;
                break;
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

    public boolean isAllRoomAccess() {
        return allRoomAccess;
    }

    public void setAllRoomAccess(boolean allRoomAccess) {
        this.allRoomAccess = allRoomAccess;
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

    public boolean isAdminAccess() {
        return adminAccess;
    }

    public void setAdminAccess(boolean adminAccess) {
        this.adminAccess = adminAccess;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String displayPermissions(){
        String permisions = ("Pool Access: " + isPoolAccess() + "\n" +
                "Gym Access: " + isGymAccess() + "\n" +
                "PC Room Access: " + isPcAccess() + "\n" +
                "Bar Access: " + isBarAccess() + "\n" +
                "Casino Access: " + isCasinoAccess() + "\n" +
                "Buffet Access: " + isBuffetAccess() + "\n" +
                "Hot Tub Access: " + isHotTubAccess() + "\n" +
                "Arcade Room Access: " + isArcadeAccess() + "\n" +
                "Admin Access: " + isAdminAccess() + "\n" +
                "All Room Access: " + isAllRoomAccess() + "\n" );
        return permisions;
    }
}