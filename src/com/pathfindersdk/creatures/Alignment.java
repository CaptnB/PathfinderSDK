package com.pathfindersdk.creatures;

/**
 * The Enum Alignment.
 */
public enum Alignment
{
  
  /** The lawful good. */
  LAWFUL_GOOD ("Lawful Good"),
  
  /** The lawful neutral. */
  LAWFUL_NEUTRAL ("Lawful Neutral"),
  
  /** The lawful evil. */
  LAWFUL_EVIL ("Lawful Evil"),
  
  /** The neutral good. */
  NEUTRAL_GOOD ("Neutral Good"),
  
  /** The neutral. */
  NEUTRAL ("Neutral"),
  
  /** The neutral evil. */
  NEUTRAL_EVIL ("Neutral Evil"),
  
  /** The chaotic good. */
  CHAOTIC_GOOD ("Chaotic Good"),
  
  /** The chaotic neutral. */
  CHAOTIC_NEUTRAL ("Chaotic Neutral"),
  
  /** The chaotic evil. */
  CHAOTIC_EVIL ("Chaotic Evil");
  
  /** The name. */
  private final String name;
  
  /**
   * Instantiates a new alignment.
   *
   * @param name the name
   */
  private Alignment(String name)
  {
    this.name = name;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString()
  {
    return name;
  }
}
