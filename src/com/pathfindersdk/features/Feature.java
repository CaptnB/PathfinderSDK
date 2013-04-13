package com.pathfindersdk.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.NullPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Template class that wraps a named feature giving out bonuses (with optional prerequisites).
 * Feature can apply to a generic Creature (like Feats) or a specific target extending Creature (Race for Character, MonsterTemplate for Monster.
 */
public abstract class Feature<T extends Creature> implements Applicable<T>, Comparable<Feature<T>>
{
  protected String name;
  protected Prerequisite<Creature> prerequisite;
  protected List<Applicable<Creature>> applicables;
  
  public Feature(String name, Prerequisite<Creature> prerequisite, Applicable<Creature> ... applicables)
  {
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);
    ArgChecker.checkNotNull(prerequisite);
    ArgChecker.checkNotNull(applicables);
    for(Applicable<Creature> applicable : applicables)
      ArgChecker.checkNotNull(applicable);
    
    this.name = name;
    this.prerequisite = prerequisite;
    this.applicables = Arrays.asList(applicables);
  }
  
  protected Feature()
  {
    this.name = "New feature";
    this.prerequisite = new NullPrerequisite<Creature>();
    this.applicables = new ArrayList<Applicable<Creature>>();
  }
  
  @Override
  public void applyTo(T target)
  {
    if(prerequisite.isFilled(target))
    {
      for(Applicable<Creature> applicable : applicables)
      {
        applicable.applyTo(target);
      }
    }
  }
  
  @Override
  public void removeFrom(T target)
  {
    for(Applicable<Creature> applicable : applicables)
    {
      applicable.removeFrom(target);
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
