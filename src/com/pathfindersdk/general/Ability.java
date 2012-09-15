package com.pathfindersdk.general;

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
  
  @Override public String toString()
  {
    return name;
  }
}
