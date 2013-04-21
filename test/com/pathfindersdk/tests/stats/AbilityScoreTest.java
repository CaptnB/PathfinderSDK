package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Stat;

public class AbilityScoreTest
{

  @Test
  public void testToStringPositive()
  {
    Stat stat = new AbilityScore(15);
    
    assertEquals("15 (+2)", stat.toString());
  }

  @Test
  public void testToStringNegative()
  {
    Stat stat = new AbilityScore(5);
    
    assertEquals("5 (-3)", stat.toString());
  }

  @Test
  public void testAbilityScore()
  {
    Stat stat = new AbilityScore();
    
    assertEquals(10, stat.getScore());
  }

  @Test
  public void testAbilityScoreInt()
  {
    Stat stat = new AbilityScore(15);
    
    assertEquals(15, stat.getScore());
  }

  @Test
  public void testGetBaseModifier()
  {
    AbilityScore score = new AbilityScore(14);
    score.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    
    assertEquals(2, score.getBaseModifier());
  }

  @Test
  public void testGetModifier()
  {
    AbilityScore score = new AbilityScore(14);
    score.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    
    assertEquals(3, score.getModifier());
  }

  @Test
  public void testGetModifierAll()
  {
    int[] expected = {-2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4};
    int[] modifiers = new int[12];
    for(int i = 0; i < 12; i++)
    {
      AbilityScore score = new AbilityScore(i + 7);
      modifiers[i] = score.getModifier();
    }
    
    assertArrayEquals(expected, modifiers);
  }

  @Test
  public void testRoll()
  {
    boolean inRange = true;
    AbilityScore score = new AbilityScore(14);
    for(int i = 0; i < 100; i++)
    {
      int roll = score.roll();    // 1d20 + 2
      if(roll < 3 || roll > 22)
        inRange = false;
    }
    
    assertTrue(inRange);
  }

}
