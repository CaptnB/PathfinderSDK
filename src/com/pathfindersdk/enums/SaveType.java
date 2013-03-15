package com.pathfindersdk.enums;

/**
 * This enum lists all 3 saving throw types.
 */
public enum SaveType
{
  FORT ("Fortitude"),
  REF ("Reflex"),
  WILL ("Will"),
  ALL ("All");
  
  private final String name;
  
  private SaveType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
