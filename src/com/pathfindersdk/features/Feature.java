package com.pathfindersdk.features;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.Prerequisite;

public class Feature<T extends Creature> implements Applicable<T>, Comparable<Feature<T>>
{
  protected String name;
  protected Set<Prerequisite> prerequisites;
  protected SortedSet<Applicable<T>> applicables;
  
  public Feature(String name)
  {
    this.name = name;
  }
  
  public SortedSet<Applicable<T>> getApplicables()
  {
    return Collections.unmodifiableSortedSet(applicables);
  }
  
  public void addApplicable(Applicable<T> applicable)
  {
    if(applicable != null)
    {
      if(applicables == null)
        applicables = new TreeSet<Applicable<T>>();
      
      applicables.add(applicable);
    }
  }
  
  protected Boolean fillsPrerequisites(T target)
  {
    Boolean filled = true;

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
      if(applicables != null)
      {
        for(Applicable<T> applicable : applicables)
        {
          applicable.applyTo(target);
        }
      }
    }
  }
  
  @Override
  public void removeFrom(T target)
  {
    if(applicables != null)
    {
      for(Applicable<T> applicable : applicables)
      {
        applicable.removeFrom(target);
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
