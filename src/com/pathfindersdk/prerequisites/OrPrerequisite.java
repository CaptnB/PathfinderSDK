package com.pathfindersdk.prerequisites;

import java.util.Arrays;
import java.util.List;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.utils.ArgChecker;

final public class OrPrerequisite implements Prerequisite
{
  final private List<Prerequisite> prerequisites;
  
  public OrPrerequisite(Prerequisite ... prerequisites)
  {
    ArgChecker.checkNotNull(prerequisites);
    for(Prerequisite prereq : prerequisites)
      ArgChecker.checkNotNull(prereq);
    
    this.prerequisites = Arrays.asList(prerequisites);
  }

  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);
    
    // Just one prerequisite need to be true
    for(Prerequisite prereq : prerequisites)
    {
      if(prereq.isFilled(target))
        return true;
    }

    return false;
  }

}
