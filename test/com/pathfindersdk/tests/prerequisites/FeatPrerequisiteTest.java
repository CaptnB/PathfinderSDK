package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.books.items.FeatItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.FeatPrerequisite;
import com.pathfindersdk.prerequisites.Prerequisite;

public class FeatPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testFeatPrerequisite()
  {
    new FeatPrerequisite(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite prereq = new FeatPrerequisite("Test Feat");
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    Creature creature = new Character();
    FeatItem testFeat = new FeatItem("Test Feat");
    creature.addFeat(testFeat);
    
    Prerequisite prereq = new FeatPrerequisite("Test Feat");
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail()
  {
    Creature creature = new Character();
    FeatItem testFeat = new FeatItem("Test Feat");
    creature.addFeat(testFeat);
    
    Prerequisite prereq = new FeatPrerequisite("Test Feat 2");
    assertFalse(prereq.isFilled(creature));
  }

}
