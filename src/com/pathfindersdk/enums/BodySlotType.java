package com.pathfindersdk.enums;

public enum BodySlotType
{
  ARMOR ("Armor"),
  BELT ("Belt"),
  BODY ("Body"),
  CHEST ("Chest"),
  EYES ("Eyes"),
  FEET ("Feet"),
  HANDS ("Hands"),
  HEAD ("Head"),
  HEADBAND ("Headband"),
  NECK ("Neck"),
  RING_1 ("Ring 1"),
  RING_2 ("Ring 2"),
  PRIMARY_HAND ("Primary hand"),  // Weapon, Staff, ...
  OFF_HAND ("Off-hand"),          // Two-handed weapon, off-hand weapon, shield, rod, wand, ...
  SHOULDERS ("Shoulders"),
  WRIST ("Wrist");
  
  private final String name;
  
  private BodySlotType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
