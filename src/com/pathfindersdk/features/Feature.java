package com.pathfindersdk.features;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Template class that wraps a named feature giving out bonuses (with optional prerequisites).
 * Ex: Racial traits are Feature<Character> as they don't apply to Monster. Feats are Feature<Creature> as they can be given to Monster also,
 * Feats can also have prerequisites.
 */
public class Feature<T extends Creature> implements Applicable<T>, Comparable<Feature<T>>
{
  final private String name;
  final private SortedSet<Prerequisite<T>> prerequisites;
  final private SortedSet<Bonus> bonuses;
  
  public Feature(String name, SortedSet<Bonus> bonuses)
  {
    this(name, new TreeSet<Prerequisite<T>>(), bonuses);
  }  
  
  public Feature(String name, SortedSet<Prerequisite<T>> prerequisites, SortedSet<Bonus> bonuses)
  {
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);
    ArgChecker.checkNotNull(prerequisites);
    ArgChecker.checkNotNull(bonuses);
    
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
      for(Bonus bonus : bonuses)
      {
        bonus.applyTo(target);
      }
    }
  }
  
  @Override
  public void removeFrom(T target)
  {
    for(Bonus bonus : bonuses)
    {
      bonus.removeFrom(target);
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
