package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.prerequisites.AbilityPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class AbilityPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityPrerequisite()
  {
    new AbilityPrerequisite(5, null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite prereq = new AbilityPrerequisite(10, AbilityType.CHA);
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    Creature creature = new Character();
    Prerequisite prereq = new AbilityPrerequisite(10, AbilityType.CHA);
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail()
  {
    Creature creature = new Character();
    Prerequisite prereq = new AbilityPrerequisite(11, AbilityType.CHA);
    
    assertFalse(prereq.isFilled(creature));
  }

}
