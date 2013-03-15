package com.pathfindersdk.creatures;

import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;

public class RacialTrait implements Feature<Character>, Comparable<RacialTrait>
{
  protected String name;
  protected TreeSet<Bonus> bonuses;

  public RacialTrait(String name)
  {
    this.name = name;
  }
  
  public void addBonus(Bonus bonus)
  {
    if(bonus != null)
    {
      if(bonuses == null)
        bonuses = new TreeSet<Bonus>();
      
      bonuses.add(bonus);
    }
  }
  
  public String getName()
  {
    return name;
  }
  
  @Override
  public void applyTo(Character character)
  {
    if(character != null)
    {
      for(Bonus bonus : bonuses)
      {
        bonus.applyTo(character);
      }
    }
  }

  @Override
  public void removeFrom(Character character)
  {
    if(character != null)
    {
      for(Bonus bonus : bonuses)
      {
        bonus.removeFrom(character);
      }
    }  }

  @Override
  public int compareTo(RacialTrait trait)
  {
    return getName().compareTo(trait.getName());
  }

}
