package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.features.Feature;
import com.pathfindersdk.features.Race;

/**
 * This class requires a race to have a specific racial trait.
 */
final public class RacialTraitPrerequisite extends Prerequisite<Race>
{
  final private String traitName;
  
  public RacialTraitPrerequisite(String traitName)
  {
    if(traitName == null)
      throw new IllegalArgumentException("traitName can't be null!");
    
    this.traitName = traitName;
  }
  
  @Override
  public boolean isFilled(Race target)
  {
    if(target == null)
      throw new IllegalArgumentException("race can't be null!");

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
