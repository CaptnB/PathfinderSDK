package com.pathfindersdk.basics;

/**
 * This enum lists all available speed types.
 */
public enum SpeedType
{
  BASE ("Base Speed"),
  ARMOR ("Armor Speed"),
  FLY ("Fly Speed"),
  SWIM ("Swim Speed"),
  CLIMB ("Climb Speed"),
  BURROW ("Burrow Speed");
  
  private final String name;
  
  private SpeedType(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
}
