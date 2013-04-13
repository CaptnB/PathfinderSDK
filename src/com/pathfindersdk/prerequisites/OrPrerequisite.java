package com.pathfindersdk.prerequisites;

import java.util.Arrays;
import java.util.List;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

final public class OrPrerequisite<T extends Creature> implements Prerequisite<T>
{
  final private List<Prerequisite<T>> prerequisites;
  
  public OrPrerequisite(Prerequisite<T> ... prerequisites)
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
    
    // Just one prerequisite need to be true
    for(Prerequisite<T> prereq : prerequisites)
    {
      if(prereq.isFilled(target))
        return true;
    }

    return false;
  }

}
