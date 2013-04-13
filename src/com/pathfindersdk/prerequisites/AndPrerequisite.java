package com.pathfindersdk.prerequisites;

import java.util.Arrays;
import java.util.List;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

final public class AndPrerequisite<T extends Creature> implements Prerequisite<T>
{
  final private List<Prerequisite<T>> prerequisites;
  
  public AndPrerequisite(Prerequisite<T> ... prerequisites)
  {
    ArgChecker.checkNotNull(prerequisites);
    for(Prerequisite<T> prereq : prerequisites)
      ArgChecker.checkNotNull(prereq);
    
    this.prerequisites = Arrays.asList(prerequisites);
  }

  @Override
  public boolean isFilled(T target)
  {
    ArgChecker.checkNotNull(target);
    
    // All prerequisites need to be true
    for(Prerequisite<T> prereq : prerequisites)
    {
      if(!prereq.isFilled(target))
        return false;
    }

    return true;
  }

}
