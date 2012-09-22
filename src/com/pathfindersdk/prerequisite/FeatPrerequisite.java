package com.pathfindersdk.prerequisite;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.creatures.Feat;

/**
 * The Class FeatPrerequisite.
 */
public class FeatPrerequisite extends Prerequisite
{
  
  private String featName;
  
  public FeatPrerequisite(String featName)
  {
    this.featName = featName;
  }

  @Override
  public Boolean check(Creature creature)
  {
    Feat feat = creature.getFeat(featName);
    if(feat == null)
      return false;
    else
      return true;
  }

}
