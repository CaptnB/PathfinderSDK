package com.pathfindersdk.enums;

/**
 * This enum lists all 6 ability scores and also ANY for races with a floating bonus.
 */
public enum AbilityType
{
  STR ("Strenght"),
  DEX ("Dexterity"),
  CON ("Constitution"),
  INT ("Intelligence"),
  WIS ("Wisdom"),
  CHA ("Charisma"),
  ANY ("Any");
  
  private final String name;
  
  private AbilityType(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
