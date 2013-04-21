package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.utils.ArgChecker;

final public class AlignmentPrerequisite implements Prerequisite
{
  final private AlignmentType alignment;
  
  public AlignmentPrerequisite(AlignmentType alignment)
  {
    ArgChecker.checkNotNull(alignment);
    
    this.alignment = alignment;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    ArgChecker.checkNotNull(target);

    return target.getAlignment().equals(alignment);
  }

}
