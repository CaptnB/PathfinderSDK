package com.pathfindersdk.basics;

/**
 * This enum lists all 6 ability scores and also ANY for races with a floating bonus.
 */
public enum Ability
{
  STR ("Strenght"),
  DEX ("Dexterity"),
  CON ("Constitution"),
  INT ("Intelligence"),
  WIS ("Wisdom"),
  CHA ("Charisma"),
  ANY ("Any");
  
  private final String name;
  
  private Ability(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
}
