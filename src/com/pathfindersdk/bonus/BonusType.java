package com.pathfindersdk.bonus;

/**
 * This enum lists all bonus types. For a stackable bonus, use UNTYPED. All others are non-stackable.
 */
public enum BonusType
{
  MORALE ("Morale"),
  LUCK ("Luck"),
  RACIAL ("Racial"),
  ARMOR ("Armor"),
  SHIELD ("Shield"),
  NATURAL_ARMOR ("Natural Armor"),
  DEFLECTION ("Deflection"),
  ENHANCEMENT ("Enhancement"),
  UNTYPED ("Untyped");
  
  private final String name;
  
  private BonusType(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
}
