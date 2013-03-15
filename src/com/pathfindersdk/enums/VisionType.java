package com.pathfindersdk.enums;

/**
 * This enum lists all available vision types.
 */
public enum VisionType
{
  // Natural order to make sure the best vision is always the 1st item in a TreeSet
  DARKVISION_120 ("Darkvision 120 ft"),
  DARKVISION_60 ("Darkvision 60 ft"),
  LOW_LIGHT ("Low-Light"),
  NORMAL ("Normal");
  
  private final String name;
  
  private VisionType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
  
}
