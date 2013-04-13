package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

public class NullPrerequisite<T extends Creature> implements Prerequisite<T>
{

  @Override
  public boolean isFilled(T target)
  {
    ArgChecker.checkNotNull(target);

    return true;
  }

}
