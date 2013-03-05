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
  RING ("Ring"),
  SHIELD ("Shield"),
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
