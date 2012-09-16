package com.pathfindersdk.feats;

import com.pathfindersdk.creatures.characters.Character;
import com.pathfindersdk.general.Prerequisite;

public class FeatPrerequisite extends Prerequisite
{
  private String featName;
  
  public FeatPrerequisite(String featName)
  {
    this.featName = featName;
  }

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
