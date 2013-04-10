package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.features.Race;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class requires a race to have a specific racial trait.
 */
final public class RacialTraitPrerequisite implements Prerequisite<Race>
{
  final private String traitName;
  
  public RacialTraitPrerequisite(String traitName)
  {
    ArgChecker.checkNotNull(traitName);
    ArgChecker.checkNotEmpty(traitName);
    
    this.traitName = traitName;
  }
  
  @Override
  public boolean isFilled(Race target)
  {
    ArgChecker.checkNotNull(target);

    for(Feature<Character> racialTrait : target.getRacialTraits())
    {
      if(racialTrait.toString().equals(traitName))
      {
        return true;
      }
    }
    
    return false;
  }

}
