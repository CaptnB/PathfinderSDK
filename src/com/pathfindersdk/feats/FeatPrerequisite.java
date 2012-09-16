package com.pathfindersdk.feats;

import com.pathfindersdk.creatures.characters.Character;
import com.pathfindersdk.general.Prerequisite;

/**
 * The Class FeatPrerequisite.
 */
public class FeatPrerequisite extends Prerequisite
{
  
  /** The feat name. */
  private String featName;
  
  /**
   * Instantiates a new feat prerequisite.
   *
   * @param featName the feat name
   */
  public FeatPrerequisite(String featName)
  {
    this.featName = featName;
  }

  /* (non-Javadoc)
   * @see com.pathfindersdk.general.Prerequisite#check(com.pathfindersdk.creatures.characters.Character)
   */
  @Override
  public Boolean check(Character character)
  {
    Feat feat = character.getFeat(featName);
    if(feat == null)
      return false;
    else
      return true;
  }

}
