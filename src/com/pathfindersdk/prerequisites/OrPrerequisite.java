package com.pathfindersdk.prerequisites;

import java.util.List;

import com.pathfindersdk.utils.ArgChecker;

final public class OrPrerequisite<T> implements Prerequisite<T>
{
  final private List<Prerequisite<T>> prerequisites;
  
  public OrPrerequisite(List<Prerequisite<T>> prerequisites)
  {
    ArgChecker.checkNotNull(prerequisites);
    
    this.prerequisites = prerequisites;
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
