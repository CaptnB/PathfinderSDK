package com.pathfindersdk.core;

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
  NONE ("None");
  
  private final String name;
  
  FeatType(String name)
  {
    this.name = name;
  }
  
  @Override public String toString()
  {
    return name;
  }
}
