package com.pathfindersdk.basics;

import java.util.HashSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;

public class RacialTrait implements Feature
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

  @Override
  public void apply(Character character)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void remove(Character character)
  {
    // TODO Auto-generated method stub
    
  }
}
