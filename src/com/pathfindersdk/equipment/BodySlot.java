package com.pathfindersdk.equipment;

public enum BodySlot
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
  
  private BodySlot(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
