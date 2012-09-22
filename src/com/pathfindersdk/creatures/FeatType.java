package com.pathfindersdk.creatures;

/**
 * The Enum FeatType.
 */
public enum FeatType
{
  
  /** Combat feat. */
  COMBAT ("Combat"),
  
  /** Critical feat. */
  CRITICAL ("Critical"),
  
  /** Item Creation feat. */
  ITEM_CREATION ("Item Creation"),
  
  /** Metamagic feat. */
  METAMAGIC ("Metamagic"),
  
  /** Teamwork feat. */
  TEAMWORK ("Teamwork"),
  
  /** Grit feat. */
  GRIT ("Grit"),
  
  /** Performance feat. */
  PERFORMANCE ("Performance"),
  
  /** Style feat. */
  STYLE ("Style"),
  
  /** Untyped feat. */
  UNTYPED ("");
  
  /** Feat type name. */
  private final String name;
  
  /**
   * Instantiates a new feat type.
   *
   * @param name Feat type name
   */
  private FeatType(String name)
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
