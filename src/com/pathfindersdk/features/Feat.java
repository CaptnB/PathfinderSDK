package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.FeatType;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class represents feats. 
 */
final public class Feat extends Feature<Creature>
{
  final private FeatType type;
  
  public Feat(String name, FeatType type, Prerequisite<Creature> prerequisite, Applicable<Creature> ... applicables)
  {
    super(name, prerequisite, applicables);
    
    ArgChecker.checkNotNull(type);

    this.type = type;
  }
  
  public FeatType getFeatType()
  {
    return type;
  }
  
}
