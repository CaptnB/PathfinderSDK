package com.pathfindersdk.features;

import java.util.Collections;
import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.Prerequisite;

public class Feature<T extends Creature> implements Applicable<T>, Comparable<Feature<T>>
{
  final private String name;
  final private SortedSet<Prerequisite<T>> prerequisites;
  final private SortedSet<Bonus> bonuses;
  
  public Feature(String name, SortedSet<Prerequisite<T>> prerequisites, SortedSet<Bonus> bonuses)
  {
    if(name == null)
      throw new IllegalArgumentException("name can't be null");
    
    if(prerequisites == null)
      throw new IllegalArgumentException("prerequisites can't be null");
    
    if(bonuses == null)
      throw new IllegalArgumentException("bonuses can't be null");
    
    this.name = name;
    this.prerequisites = prerequisites;
    this.bonuses = bonuses;
  }
  
  public SortedSet<Prerequisite<T>> getPrerequisites()
  {
    return Collections.unmodifiableSortedSet(prerequisites);
  }
  
  public SortedSet<Bonus> getBonuses()
  {
    return Collections.unmodifiableSortedSet(bonuses);
  }
  
  protected boolean fillsPrerequisites(T target)
  {
    boolean filled = true;

    for(Prerequisite<T> prereq : prerequisites)
    {
      if(!prereq.isFilled(target))
      {
        filled = false;
        break;
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
