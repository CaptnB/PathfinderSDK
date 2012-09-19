package com.pathfindersdk.general;

/**
 * The Enum BonusType.
 */
public enum BonusType
{
  
  /** Morale bonus. */
  MORALE ("Morale"),
  
  /** Luck bonus. */
  LUCK ("Luck"),
  
  /** Racial bonus. */
  RACIAL ("Racial"),
  
  ARMOR ("Armor"),
  
  SHIELD ("Shield"),
  
  NATURAL_ARMOR ("Natural Armor"),
  
  DEFLECTION ("Deflection"),
  
  /** Untyped bonus. */
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
