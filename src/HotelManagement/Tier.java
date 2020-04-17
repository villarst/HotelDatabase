package HotelManagement;

import java.io.Serializable;


/*****************************************************************
 This class sets and returns the permissions of a user based on
 the users tier (0-3).
 @author Steven Villarreal, Corey Rice, Corey Sutter, Jason Kaip
 @version 1.0
 *****************************************************************/


public class Tier implements Serializable { //NOPMD
//
//  /** Determines if the user has pool access. */
//  private boolean poolAccess;
//
//  /** Determines if the user has gym access. */
//  private boolean gymAccess;
//
//  /** Determines if the user has PC access. */
//  private boolean pcAccess;
//
//  /** Determines if the user has buffet access. */
//  private boolean buffetAccess;
//
//  /** Determines if the user has bar access. */
//  private boolean barAccess;
//
//  /** Determines if the user has hot tub access. */
//  private boolean hotTubAccess;
//
//  /** Determines if the user has casino access. */
//  private boolean casinoAccess;
//
//  /** Determines if the user has arcade access. */
//  private boolean arcadeAccess;
//
//  /** Determines if the user has hotel room access. */
//  private boolean roomAccess;
//
//  /** Determines if the user has admin access. */
//  private boolean adminAccess;
//
//  /** Determines if the user has all rooms access. */
//  private boolean allRoomAccess;
//
//  /** Value of the users tier (0-3). */
//  private int tier; //NOPMD
//
//
//  /*****************************************************************
//  Constructor that sets the tier and permissions for a user.
//   @param tierLevel the tier level to set for a user (0-3).
//  *****************************************************************/
//  public Tier(final int tierLevel) {
//    tier = tierLevel;
//    checkPermissions(); //NOPMD
//  }
//
//
//  /*****************************************************************
//  Sets the permissions for the user based on their tier.
//  *****************************************************************/
//  public void checkPermissions() {
//    switch (tier) {
//      case 1: // pool, pc, hot tub access
//        poolAccess = true;
//        pcAccess = true;
//        hotTubAccess = true;
//        gymAccess = false;
//        barAccess = false;
//        casinoAccess = false;
//        buffetAccess = false;
//        arcadeAccess = false;
//        break;
//      case 2: // pool, pc, hot tub, gym, buffet access
//        poolAccess = true;
//        pcAccess = true;
//        hotTubAccess = true;
//        gymAccess = true;
//        barAccess = false;
//        casinoAccess = false;
//        buffetAccess = true;
//        arcadeAccess = false;
//        break;
//      case 3: // pool, pc, hot tub, gym, bar, casino, buffet, arcade access.
//        poolAccess = true;
//        pcAccess = true;
//        hotTubAccess = true;
//        gymAccess = true;
//        barAccess = true;
//        casinoAccess = true;
//        buffetAccess = true;
//        arcadeAccess = true;
//        break;
//      case 0: // admin access.
//        poolAccess = true;
//        pcAccess = true;
//        hotTubAccess = true;
//        gymAccess = true;
//        barAccess = true;
//        casinoAccess = true;
//        buffetAccess = true;
//        arcadeAccess = true;
//        adminAccess = true;
//        roomAccess = true;
//        allRoomAccess = true;
//        break;
//      default:
//        System.out.println("You have chosen no tier level.."); //NOPMD
//        break;
//    }
//  }
//
//
//  /*****************************************************************
//   Checks if the user has pool permissions.
//   @return poolAccess a boolean value that states if the user has
//   pool access.
//   *****************************************************************/
//  public boolean isPoolAccess() {
//    return poolAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have pool permissions.
//  @param  poolAccess a boolean value that states if the user has
//  pool access.
//  *****************************************************************/
//  public void setPoolAccess(final boolean poolAccess) {
//    this.poolAccess = poolAccess;
//  }
//
//
//  /*****************************************************************
//   Checks if the user has all room permissions.
//   @return allRoomAccess a boolean value that states if the user has
//   all room permissions.
//  *****************************************************************/
//  public boolean isAllRoomAccess() {
//    return allRoomAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have all room permissions.
//  @param  allRoomAccess a boolean value that states if the user has
//  all room access.
//  *****************************************************************/
//  public void setAllRoomAccess(final boolean allRoomAccess) {
//    this.allRoomAccess = allRoomAccess;
//  }
//
//
//  /*****************************************************************
//   Checks if the user has gym permissions.
//   @return gymAccess a boolean value that states if the user has
//   gym access.
//   *****************************************************************/
//  public boolean isGymAccess() {
//    return gymAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have gym permissions.
//  @param  gymAccess a boolean value that states if the user has
//  gym access.
//  *****************************************************************/
//  public void setGymAccess(final boolean gymAccess) {
//    this.gymAccess = gymAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has PC permissions.
//  @return pcAccess a boolean value that states if the user has
//  PC access.
//  *****************************************************************/
//  public boolean isPcAccess() {
//    return pcAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have PC permissions.
//  @param  pcAccess a boolean value that states if the user has
//  PC access.
//  *****************************************************************/
//  public void setPcAccess(final boolean pcAccess) {
//    this.pcAccess = pcAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has buffet permissions.
//  @return buffetAccess a boolean value that states if the user has
//  buffet access.
//  *****************************************************************/
//  public boolean isBuffetAccess() {
//    return buffetAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have buffet permissions.
//  @param  buffetAccess a boolean value that states if the user has
//  buffet access.
//  *****************************************************************/
//  public void setBuffetAccess(final boolean buffetAccess) {
//    this.buffetAccess = buffetAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has bar permissions.
//  @return barAccess a boolean value that states if the user has
//  bar access.
//  *****************************************************************/
//  public boolean isBarAccess() {
//    return barAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have bar permissions.
//  @param  barAccess a boolean value that states if the user has
//  bar access.
//  *****************************************************************/
//  public void setBarAccess(final boolean barAccess) {
//    this.barAccess = barAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has hot tub permissions.
//  @return hotTubAccess a boolean value that states if the user has
//  hot tub access.
//  *****************************************************************/
//  public boolean isHotTubAccess() {
//    return hotTubAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have hot tub permissions.
//  @param hotTubAccess a boolean value that states if the user has
//  hot tub access.
//  *****************************************************************/
//  public void setHotTubAccess(final boolean hotTubAccess) {
//    this.hotTubAccess = hotTubAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has casino permissions.
//  @return casinoAccess a boolean value that states if the user has
//  casino access.
//  *****************************************************************/
//  public boolean isCasinoAccess() {
//    return casinoAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have casino permissions.
//  @param  casinoAccess a boolean value that states if the user has
//  casino access.
//  *****************************************************************/
//  public void setCasinoAccess(final boolean casinoAccess) {
//    this.casinoAccess = casinoAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has arcade permissions.
//  @return arcadeAccess a boolean value that states if the user has
//  arcade access.
//  *****************************************************************/
//  public boolean isArcadeAccess() {
//    return arcadeAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have arcade permissions.
//  @param  arcadeAccess a boolean value that states if the user has
//  arcade access.
//  *****************************************************************/
//  public void setArcadeAccess(final boolean arcadeAccess) {
//    this.arcadeAccess = arcadeAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has hotel room permissions.
//  @return roomAccess a boolean value that states if the user has
//  hotel room access.
//  *****************************************************************/
//  public boolean isRoomAccess() {
//    return roomAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have hotel room permissions.
//  @param  roomAccess a boolean value that states if the user has
//  room access
//  *****************************************************************/
//  public void setRoomAccess(final boolean roomAccess) {
//    this.roomAccess = roomAccess;
//  }
//
//
//  /*****************************************************************
//  Checks if the user has admin permissions.
//  @return adminAccess a boolean value that states if the user has
//  admin access.
//  *****************************************************************/
//  public boolean isAdminAccess() {
//    return adminAccess;
//  }
//
//
//  /*****************************************************************
//  Sets the user to have admin permissions.
//  @param  adminAccess a boolean value that states if the user has
//  admin access
//  *****************************************************************/
//  public void setAdminAccess(final boolean adminAccess) {
//    this.adminAccess = adminAccess;
//  }
//
//
//  /*****************************************************************
//  Returns the tier of the user.
//  @return getTier the tier of the user.
//*****************************************************************/
//  public int getTier() {
//    return tier;
//  }
//
//
//  /*****************************************************************
//  Sets the users tier.
//  @param  tier an integer value that sets the tier of the user
//  (0-3).
//  *****************************************************************/
//  public void setTier(final int tier) {
//    this.tier = tier;
//  }
//
//
//  /*****************************************************************
//  Returns a string that displays the permissions of the user.
//  @return a string to display the permissions of the user.
//  *****************************************************************/
//  public String displayPermissions() {
//    return "Pool Access: " + isPoolAccess() + "\n"
//            + "Gym Access: " + isGymAccess() + "\n"
//            + "PC Room Access: " + isPcAccess() + "\n"
//            + "Bar Access: " + isBarAccess() + "\n"
//            + "Casino Access: " + isCasinoAccess() + "\n"
//            + "Buffet Access: " + isBuffetAccess() + "\n"
//            + "Hot Tub Access: " + isHotTubAccess() + "\n"
//            + "Arcade Room Access: " + isArcadeAccess() + "\n"
//            + "Admin Access: " + isAdminAccess() + "\n"
//            + "All Room Access: " + isAllRoomAccess() + "\n";
//  }
}