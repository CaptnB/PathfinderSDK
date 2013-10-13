package com.pathfindersdk.prerequisites;

import com.pathfindersdk.applicables.Feature;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class requires a race to have a specific racial trait.
 */
final public class FeaturePrerequisite implements Prerequisite
{
  final private String traitName;
  
  public FeaturePrerequisite(String traitName)
  {
    ArgChecker.checkNotNull(traitName);
    ArgChecker.checkNotEmpty(traitName);
    
    this.traitName = traitName;
  }
  
  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);

    for(Feature feature : target.getFeatures())
    {
      if(feature.toString().equals(traitName))
      {
        return true;
      }
    }
    
    return false;
  }

}
