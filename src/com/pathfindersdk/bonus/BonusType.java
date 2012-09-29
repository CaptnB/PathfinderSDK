package com.pathfindersdk.bonus;

/**
 * This enum lists all bonus types. For a stackable bonus, use UNTYPED. All others are non-stackable.
 */
public enum BonusType
{
  MORALE ("Morale"),
  LUCK ("Luck"),
  RACIAL ("Racial"),
  DODGE ("Dodge"),
  DEFLECTION ("Deflection"),
  ENHANCEMENT ("Enhancement"),
  UNTYPED ("");
  
  private final String name;
  
  private BonusType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
