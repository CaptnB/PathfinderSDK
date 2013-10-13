package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.prerequisites.AbilityPrerequisite;
import com.pathfindersdk.prerequisites.AlignmentPrerequisite;
import com.pathfindersdk.prerequisites.AndPrerequisite;
import com.pathfindersdk.prerequisites.NullPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class AndPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testAndPrerequisite()
  {
    Prerequisite[] prereqs = null;
    new AndPrerequisite(prereqs);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite prereq = new AndPrerequisite(new NullPrerequisite());
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite subPrereq1 = new AbilityPrerequisite(10, AbilityType.CHA);
    Prerequisite subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    Prerequisite prereq = new AndPrerequisite(subPrereq1, subPrereq2);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail1()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite subPrereq1 = new AbilityPrerequisite(11, AbilityType.CHA);
    Prerequisite subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    Prerequisite prereq = new AndPrerequisite(subPrereq1, subPrereq2);
    
    assertFalse(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail2()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite subPrereq1 = new AbilityPrerequisite(10, AbilityType.CHA);
    Prerequisite subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_GOOD);
    Prerequisite prereq = new AndPrerequisite(subPrereq1, subPrereq2);
    
    assertFalse(prereq.isFilled(creature));
  }

}
