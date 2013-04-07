package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.prerequisites.AlignmentPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class AlignmentPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testAlignmentPrerequiste()
  {
    new AlignmentPrerequisite(null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite<Creature> prereq = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    Prerequisite<Creature> prereq = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_GOOD);
    Prerequisite<Creature> prereq = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    
    assertFalse(prereq.isFilled(creature));
  }

}
