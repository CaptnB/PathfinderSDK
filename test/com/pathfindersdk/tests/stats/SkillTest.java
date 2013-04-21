package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Skill;

public class SkillTest
{
  @Test (expected = IllegalArgumentException.class)
  public void testSkillNull()
  {
    new Skill(null, new AbilityScore());
  }

  @Test
  public void testIsUsableUntrained()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, true, false), new AbilityScore());
    
    assertTrue(skill.isUsableUntrained());
  }

  @Test
  public void testIsArmorCheckPenalty()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, true), new AbilityScore());
    
    assertTrue(skill.isArmorCheckPenalty());
  }
  
  @Test
  public void testIsClassSkill()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, false), new AbilityScore());
    
    assertFalse(skill.isClassSkill());
  }
  
  @Test
  public void testSetClassSkill()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, false), new AbilityScore());
    skill.setClassSkill(true);
    
    assertTrue(skill.isClassSkill());
  }
  
  @Test
  public void testGetName()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, false), new AbilityScore(13));
    
    assertEquals("A skill", skill.getName());
  }
  
  @Test
  public void testGetScoreTrainedWithoutRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, false), new AbilityScore(13));
    
    assertEquals(0, skill.getScore());
  }
  
  @Test
  public void testGetScoreTrainedWithRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, false, false), new AbilityScore(13));
    skill.incrementBaseScore(1);
    
    assertEquals(2, skill.getScore());
  }
  
  @Test
  public void testGetScoreUntrainedWithoutRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, true, false), new AbilityScore(13));
    
    assertEquals(1, skill.getScore());
  }
  
  @Test
  public void testGetScoreUntrainedWithRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, true, false), new AbilityScore(13));
    skill.incrementBaseScore(1);
    
    assertEquals(2, skill.getScore());
  }
  
  @Test
  public void testGetScoreClassSkillWithoutRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, true, false), new AbilityScore(13));
    skill.setClassSkill(true);
    
    assertEquals(1, skill.getScore());
  }
  
  @Test
  public void testGetScoreClassSkillWithRanks()
  {
    Skill skill = new Skill(new SkillItem("A skill", AbilityType.CHA, true, false), new AbilityScore(13));
    skill.setClassSkill(true);
    skill.incrementBaseScore(1);
    
    assertEquals(5, skill.getScore());
  }

}
