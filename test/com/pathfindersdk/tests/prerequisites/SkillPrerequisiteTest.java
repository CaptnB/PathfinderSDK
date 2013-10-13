package com.pathfindersdk.tests.prerequisites;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.prerequisites.SkillPrerequisite;

public class SkillPrerequisiteTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testSkillPrerequisite()
  {
    new SkillPrerequisite(5, null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testIsFilledNull()
  {
    Prerequisite prereq = new SkillPrerequisite(5, "Test skill");
    prereq.isFilled(null);
  }

  @Test
  public void testIsFilledPass()
  {
    SkillItem skillItem = new SkillItem("Test skill", AbilityType.CHA, false, false);
    Creature creature = new Character();
    creature.addSkill(skillItem);
    creature.getSkill("Test skill").setBaseScore(5);
    
    Prerequisite prereq = new SkillPrerequisite(5, "Test skill");
    
    assertTrue(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail1()
  {
    SkillItem skillItem = new SkillItem("Test skill", AbilityType.CHA, false, false);
    Creature creature = new Character();
    creature.addSkill(skillItem);
    creature.getSkill("Test skill").setBaseScore(5);
    
    Prerequisite prereq = new SkillPrerequisite(6, "Test skill");
    
    assertFalse(prereq.isFilled(creature));
  }

  @Test
  public void testIsFilledFail2()
  {
    SkillItem skillItem = new SkillItem("Test skill", AbilityType.CHA, false, false);
    Creature creature = new Character();
    creature.addSkill(skillItem);
    creature.getSkill("Test skill").setBaseScore(5);
    
    Prerequisite prereq = new SkillPrerequisite(6, "Test skill 2");
    
    assertFalse(prereq.isFilled(creature));
  }

}
