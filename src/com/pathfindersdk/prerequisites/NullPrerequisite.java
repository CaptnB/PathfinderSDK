package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

public class NullPrerequisite implements Prerequisite
{

  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);

    return true;
  }

}
