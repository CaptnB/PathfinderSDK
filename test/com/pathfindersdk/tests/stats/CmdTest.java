package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Cmd;
import com.pathfindersdk.stats.Size;

public class CmdTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testNullAbilityScoreBaseAttackBonusSize()
  {
    new Cmd(null, new AbilityScore(), new BaseAttackBonus(), new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityScoreNullBaseAttackBonusSize()
  {
    new Cmd(new AbilityScore(), null, new BaseAttackBonus(), new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityScoreAbilityScoreNullSize()
  {
    new Cmd(new AbilityScore(), new AbilityScore(), null, new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityScoreAbilityScoreBaseAttackBonusNull()
  {
    new Cmd(new AbilityScore(), new AbilityScore(), new BaseAttackBonus(), null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddAbilityNull()
  {
    Cmd cmd = new Cmd(new AbilityScore(), new AbilityScore(), new BaseAttackBonus(), new Size(SizeType.MEDIUM));
    cmd.addAbility(null);
  }

  @Test
  public void testAddAbility()
  {
    Cmd cmd = new Cmd(new AbilityScore(), new AbilityScore(), new BaseAttackBonus(), new Size(SizeType.MEDIUM));
    cmd.addAbility(new AbilityScore(12));
    
    assertEquals(11, cmd.getScore());
  }

  @Test
  public void testRemoveAbility()
  {
    Cmd cmd = new Cmd(new AbilityScore(), new AbilityScore(), new BaseAttackBonus(), new Size(SizeType.MEDIUM));
    AbilityScore ability = new AbilityScore(12);
    cmd.addAbility(ability);
    cmd.removeAbility(ability);
    
    assertEquals(10, cmd.getScore());
  }

  @Test
  public void testGetScore()
  {
    Cmd cmd = new Cmd(new AbilityScore(8), new AbilityScore(14), new BaseAttackBonus(3), new Size(SizeType.TINY));
    
    assertEquals(12, cmd.getScore());
  }

  @Test
  public void testGetFlatFooted()
  {
    Cmd cmd = new Cmd(new AbilityScore(8), new AbilityScore(14), new BaseAttackBonus(3), new Size(SizeType.TINY));
    
    assertEquals(10, cmd.getFlatFootedScore());
  }

}
