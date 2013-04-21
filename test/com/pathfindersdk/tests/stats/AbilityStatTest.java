package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.AbilityStat;

public class AbilityStatTest
{

  @Test
  public void testGetScore()
  {
    AbilityScore score = new AbilityScore(14);
    AbilityStat stat = new AbilityStat(score);
    stat.setBaseScore(3);
    
    assertEquals(5, stat.getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityStatNull()
  {
    new AbilityStat(null);
  }

  @Test
  public void testRoll()
  {
    AbilityScore score = new AbilityScore(7);
    AbilityStat stat = new AbilityStat(score);

    boolean checkRange = true;
    for(int i = 0; i < 100; i++)
    {
      int roll = stat.roll();
      
      if(roll < -1 || roll > 18)
        checkRange = false;
    }
    
    assertTrue(checkRange);
  }

}
