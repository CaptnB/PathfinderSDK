package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class requires a creature to have a specific feat (ex: Mobility requires Dodge).
 */
final public class FeatPrerequisite implements Prerequisite<Creature>
{
  final private String featName;
  
  public FeatPrerequisite(String featName)
  {
    ArgChecker.checkNotNull(featName);
    ArgChecker.checkNotEmpty(featName);
    
    this.featName = featName;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    // Check if target has the feat
    return target.getFeat(featName) != null;
  }

}
