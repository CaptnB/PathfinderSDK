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
import com.pathfindersdk.prerequisites.NullPrerequisite;
import com.pathfindersdk.prerequisites.OrPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class OrPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testOrPrerequisite()
  {
    Prerequisite<Creature>[] prereqs = null;
    new OrPrerequisite<Creature>(prereqs);
  }

  @Test (expected = IllegalArgumentException.class)
  @SuppressWarnings ({"unchecked"})
  public void testIsFilledNull()
  {
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(new NullPrerequisite<Creature>());
    prereq.isFilled(null);
  }

  @Test
  @SuppressWarnings ({"unchecked"})
  public void testIsFilledPass1()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite<Creature> subPrereq1 = new AbilityPrerequisite(11, AbilityType.CHA);
    Prerequisite<Creature> subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(subPrereq1, subPrereq2);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  @SuppressWarnings ({"unchecked"})
  public void testIsFilledPass2()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite<Creature> subPrereq1 = new AbilityPrerequisite(10, AbilityType.CHA);
    Prerequisite<Creature> subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_GOOD);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(subPrereq1, subPrereq2);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  @SuppressWarnings ({"unchecked"})
  public void testIsFilledFail()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    Prerequisite<Creature> subPrereq1 = new AbilityPrerequisite(11, AbilityType.CHA);
    Prerequisite<Creature> subPrereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_GOOD);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(subPrereq1, subPrereq2);
    
    assertFalse(prereq.isFilled(creature));
  }

}
