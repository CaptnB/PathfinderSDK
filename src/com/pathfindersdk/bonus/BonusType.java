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
  
  /** Bonus type name. */
  private final String name;
  
  /**
   * Instantiates a new bonus type.
   *
   * @param name Bonus type name
   */
  private BonusType(String name)
  {
    this.name = name;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override public String toString()
  {
    return name;
  }
}
