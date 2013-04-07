package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This class requires a creature to have a specific feat (ex: Mobility requires Dodge).
 */
public class FeatPrerequisite extends Prerequisite<Creature>
{
  
  protected String featName;
  
  public FeatPrerequisite(String featName)
  {
    this.featName = featName;
  }

  @Override
  public boolean isFilled(Creature creature)
  {
    /*Feat feat = creature.getFeat(featName);
    if(feat != null)
      return true;
    else*/
      return false;
  }

}
