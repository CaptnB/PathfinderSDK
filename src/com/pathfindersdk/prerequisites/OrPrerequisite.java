package com.pathfindersdk.prerequisites;

import java.util.List;

final public class OrPrerequisite<T> implements Prerequisite<T>
{
  final private List<Prerequisite<T>> prerequisites;
  
  public OrPrerequisite(List<Prerequisite<T>> prerequisites)
  {
    if(prerequisites == null)
      throw new IllegalArgumentException("prerequisites can't be null!");
    
    this.prerequisites = prerequisites;
  }

  @Override
  public boolean isFilled(T target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null!");
    
    // Just one prerequisite need to be true
    for(Prerequisite<T> prereq : prerequisites)
    {
      if(prereq.isFilled(target))
        return true;
    }

    return false;
  }

}
