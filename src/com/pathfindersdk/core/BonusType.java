package com.pathfindersdk.core;

public enum BonusType
{
  MORALE ("Morale"),
  LUCK ("Luck"),
  RACIAL ("Racial"),
  UNTYPED ("Untyped");
  
  private final String name;
  
  private BonusType(String name)
  {
    this.name = name;
  }
  
  @Override public String toString()
  {
    return name;
  }
}
