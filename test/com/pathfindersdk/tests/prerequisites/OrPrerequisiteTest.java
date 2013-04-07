package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.prerequisites.AbilityPrerequisite;
import com.pathfindersdk.prerequisites.AlignmentPrerequisite;
import com.pathfindersdk.prerequisites.OrPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class OrPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testOrPrerequisite()
  {
    new OrPrerequisite<Creature>(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(new ArrayList<Prerequisite<Creature>>());
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass1()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    List<Prerequisite<Creature>> listPrereqs = new ArrayList<Prerequisite<Creature>>();
    Prerequisite<Creature> prereq1 = new AbilityPrerequisite(11, AbilityType.CHA);
    Prerequisite<Creature> prereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_EVIL);
    listPrereqs.add(prereq1);
    listPrereqs.add(prereq2);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(listPrereqs);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledPass2()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    List<Prerequisite<Creature>> listPrereqs = new ArrayList<Prerequisite<Creature>>();
    Prerequisite<Creature> prereq1 = new AbilityPrerequisite(10, AbilityType.CHA);
    Prerequisite<Creature> prereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_GOOD);
    listPrereqs.add(prereq1);
    listPrereqs.add(prereq2);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(listPrereqs);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail()
  {
    Creature creature = new Character();
    creature.setAlignment(AlignmentType.CHAOTIC_EVIL);
    
    List<Prerequisite<Creature>> listPrereqs = new ArrayList<Prerequisite<Creature>>();
    Prerequisite<Creature> prereq1 = new AbilityPrerequisite(11, AbilityType.CHA);
    Prerequisite<Creature> prereq2 = new AlignmentPrerequisite(AlignmentType.CHAOTIC_GOOD);
    listPrereqs.add(prereq1);
    listPrereqs.add(prereq2);
    Prerequisite<Creature> prereq = new OrPrerequisite<Creature>(listPrereqs);
    
    assertFalse(prereq.isFilled(creature));
  }

}
