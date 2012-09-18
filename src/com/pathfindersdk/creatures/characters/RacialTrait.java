package com.pathfindersdk.creatures.characters;

import java.util.HashSet;

import com.pathfindersdk.general.Bonus;

public class RacialTrait
{
  private String name;
  private HashSet<Bonus> bonuses = new HashSet<Bonus>();
  
  public RacialTrait(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public HashSet<Bonus> getBonuses()
  {
    return bonuses;
  }
}
