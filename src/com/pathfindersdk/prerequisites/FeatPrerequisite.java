package com.pathfindersdk.prerequisites;

import com.pathfindersdk.basics.Feat;
import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a character to have a specific feat (ex: Mobility requires Dodge).
 */
public class FeatPrerequisite extends Prerequisite
{
  
  protected String featName;
  
  public FeatPrerequisite(String featName)
  {
    this.featName = featName;
  }

  @Override
  public Boolean isFilled(Creature creature)
  {
    Feat feat = creature.getFeat(featName);
    if(feat == null)
      return false;
    else
      return true;
  }

}
