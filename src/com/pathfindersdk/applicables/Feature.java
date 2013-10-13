package com.pathfindersdk.applicables;

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
public class Feature implements Applicable, Comparable<Feature>
{
  final private String name;
  final private Prerequisite prerequisite;
  final private List<Applicable> applicables;
  
  public Feature(String name, Applicable ... applicables)
  {
    this(name, new NullPrerequisite(), applicables);
  }
  
  public Feature(String name, Prerequisite prerequisite, Applicable ... applicables)
  {
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);
    ArgChecker.checkNotNull(prerequisite);
    ArgChecker.checkNotNull(applicables);
    for(Applicable applicable : applicables)
      ArgChecker.checkNotNull(applicable);
    
    this.name = name;
    this.prerequisite = prerequisite;
    this.applicables = Arrays.asList(applicables);
  }
  
  public String getName()
  {
    return name;
  }
  
  @Override
  public void applyTo(Creature target)
  {
    if(prerequisite.isFilled(target))
    {
      for(Applicable applicable : applicables)
      {
        applicable.applyTo(target);
      }
    }
  }
  
  @Override
  public void removeFrom(Creature target)
  {
    for(Applicable applicable : applicables)
    {
      applicable.removeFrom(target);
    }
  }

  @Override
  public int compareTo(Feature feature)
  {
    return toString().compareTo(feature.toString());
  }
  
  @Override
  public String toString()
  {
    return name;
  }
}
