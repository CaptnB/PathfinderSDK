package com.pathfindersdk.core;

public enum Ability
{
  STR ("Strenght"),
  DEX ("Dexterity"),
  CON ("Constitution"),
  INT ("Intelligence"),
  WIS ("Wisdom"),
  CHA ("Charisma");
  
  private final String name;
  Ability(String name)
  {
    this.name = name;
  }
  
  @Override public String toString()
  {
    return name;
  }
}
