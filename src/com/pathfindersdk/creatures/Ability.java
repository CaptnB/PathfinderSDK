package com.pathfindersdk.creatures;

/**
 * The Enum Ability.
 */
public enum Ability
{
  
  /** Strenght. */
  STR ("Strenght"),
  
  /** Dexterity. */
  DEX ("Dexterity"),
  
  /** Constitution. */
  CON ("Constitution"),
  
  /** Intelligence. */
  INT ("Intelligence"),
  
  /** Wisdom. */
  WIS ("Wisdom"),
  
  /** Charisma. */
  CHA ("Charisma"),
  
  /** Any. */
  ANY ("Any");
  
  /** Ability name. */
  private final String name;
  
  /**
   * Instantiates a new ability.
   *
   * @param name Ability name
   */
  private Ability(String name)
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
