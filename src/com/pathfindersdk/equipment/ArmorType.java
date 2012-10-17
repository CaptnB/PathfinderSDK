package com.pathfindersdk.equipment;

public enum ArmorType
{
  LIGHT ("Light"),
  MEDIUM ("Medium"),
  HEAVY ("Heavy");
  
  private final String name;
  
  private ArmorType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
