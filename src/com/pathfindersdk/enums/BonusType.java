package com.pathfindersdk.enums;

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
  SIZE ("Size"),
  ARMOR ("Armor"),
  SHIELD ("Shield"),
  NATURAL_ARMOR ("Natural Armor"),
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
