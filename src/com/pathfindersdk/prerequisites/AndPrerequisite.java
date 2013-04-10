package com.pathfindersdk.prerequisites;

import java.util.List;

import com.pathfindersdk.utils.ArgChecker;

final public class AndPrerequisite<T> implements Prerequisite<T>
{
  final private List<Prerequisite<T>> prerequisites;
  
  public AndPrerequisite(List<Prerequisite<T>> prerequisites)
  {
    ArgChecker.checkNotNull(prerequisites);
    
    this.prerequisites = prerequisites;
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
