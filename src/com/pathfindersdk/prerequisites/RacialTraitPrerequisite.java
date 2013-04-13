package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.features.RacialTrait;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class requires a race to have a specific racial trait.
 */
final public class RacialTraitPrerequisite implements Prerequisite<Character>
{
  final private String traitName;
  
  public RacialTraitPrerequisite(String traitName)
  {
    ArgChecker.checkNotNull(traitName);
    ArgChecker.checkNotEmpty(traitName);
    
    this.traitName = traitName;
  }
  
  @Override
  public boolean isFilled(Character target)
  {
    ArgChecker.checkNotNull(target);
    ArgChecker.checkNotNull(target.getRace());

    for(RacialTrait racialTrait : target.getRace().getRacialTraits())
    {
      if(racialTrait.toString().equals(traitName))
      {
        return true;
      }
    }
    
    return false;
  }

}
