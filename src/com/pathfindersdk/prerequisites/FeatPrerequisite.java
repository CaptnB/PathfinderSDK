package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a creature to have a specific feat (ex: Mobility requires Dodge).
 */
final public class FeatPrerequisite implements Prerequisite<Creature>
{
  final private String featName;
  
  public FeatPrerequisite(String featName)
  {
    if(featName == null)
      throw new IllegalArgumentException("featName can't be null!");
    
    this.featName = featName;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null!");
    
    // Check if target has the feat
    return target.getFeat(featName) != null;
  }

}
