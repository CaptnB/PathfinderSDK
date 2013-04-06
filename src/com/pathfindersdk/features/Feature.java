package com.pathfindersdk.features;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.Prerequisite;

public class Feature<T extends Creature> implements Applicable<T>, Comparable<Feature<T>>
{
  protected String name;
  protected Set<Prerequisite> prerequisites;
  protected SortedSet<Bonus> bonuses;
  
  public Feature(String name)
  {
    this.name = name;
  }
  
  public SortedSet<Bonus> getBonuses()
  {
    if(bonuses != null)
      return Collections.unmodifiableSortedSet(bonuses);
    else
      return null;
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
  
  protected boolean fillsPrerequisites(T target)
  {
    boolean filled = true;

    if(prerequisites != null)
    {
      for(Prerequisite prereq : prerequisites)
      {
        if(!prereq.isFilled(target))
        {
          filled = false;
          break;
        }
      }
    }

    return filled;
  }
  
  @Override
  public void applyTo(T target)
  {
    if(fillsPrerequisites(target))
    {
      if(bonuses != null)
      {
        for(Bonus bonus : bonuses)
        {
          bonus.applyTo(target);
        }
      }
    }
  }
  
  @Override
  public void removeFrom(T target)
  {
    if(bonuses != null)
    {
      for(Bonus bonus : bonuses)
      {
        bonus.removeFrom(target);
      }
    }
  }

  @Override
  public int compareTo(Feature<T> feature)
  {
    return toString().compareTo(feature.toString());
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
