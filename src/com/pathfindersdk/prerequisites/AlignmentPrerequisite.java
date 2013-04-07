package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AlignmentType;

final public class AlignmentPrerequisite implements Prerequisite<Creature>
{
  final private AlignmentType alignment;
  
  public AlignmentPrerequisite(AlignmentType alignment)
  {
    if(alignment == null)
      throw new IllegalArgumentException("alignment can't be null");
    
    this.alignment = alignment;
  }

  @Override
  public boolean isFilled(Creature target)
  {
    if(target == null)
      throw new IllegalArgumentException("target can't be null!");

    return target.getAlignment().equals(alignment);
  }

}
