package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.FeatType;
import com.pathfindersdk.prerequisites.Prerequisite;

/**
 * This class represents feats. 
 */
final public class Feat extends Feature<Creature>
{
  final private FeatType type;
  
  public Feat(String name, FeatType type, SortedSet<Prerequisite<Creature>> prerequisites, SortedSet<Bonus> bonuses)
  {
    super(name, prerequisites, bonuses);
    
    if(type == null)
      throw new IllegalArgumentException("type can't be null");
    this.type = type;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
}
