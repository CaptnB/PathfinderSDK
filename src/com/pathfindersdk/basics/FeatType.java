package com.pathfindersdk.basics;

/**
 * This enum lists all feat types.
 */
public enum FeatType
{
  COMBAT ("Combat"),
  CRITICAL ("Critical"),
  ITEM_CREATION ("Item Creation"),
  METAMAGIC ("Metamagic"),
  TEAMWORK ("Teamwork"),
  GRIT ("Grit"),
  PERFORMANCE ("Performance"),
  STYLE ("Style"),
  UNTYPED ("");
  
  private final String name;
  
  private FeatType(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return name;
  }
}
