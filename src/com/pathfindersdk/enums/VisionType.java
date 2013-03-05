package com.pathfindersdk.enums;

/**
 * This enum lists all available vision types.
 */
public enum VisionType
{
  NORMAL ("Normal"),
  LOW_LIGHT ("Low-Light"),
  DARKVISION ("Darkvision");
  
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
