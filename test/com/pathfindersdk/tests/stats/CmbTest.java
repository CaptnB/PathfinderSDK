package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.creatures.BaseAttackBonus;
import com.pathfindersdk.creatures.HitPoints;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.Cmb;
import com.pathfindersdk.stats.Dice;
import com.pathfindersdk.stats.Size;

public class CmbTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testCmbNullAbilityScoreBaseAttackBonusSize()
  {
    new Cmb(null, new AbilityScore(), new BaseAttackBonus(), new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCmbAbilityScoreNullBaseAttackBonusSize()
  {
    new Cmb(new AbilityScore(), null, new BaseAttackBonus(), new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCmbAbilityScoreAbilityScoreNullSize()
  {
    new Cmb(new AbilityScore(), new AbilityScore(), null, new Size(SizeType.MEDIUM));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCmbAbilityScoreAbilityScoreBaseAttackBonusNull()
  {
    new Cmb(new AbilityScore(), new AbilityScore(), new BaseAttackBonus(), null);
  }
  
  @Test
  public void testGetScoreWithBab()
  {
    Cmb cmb = new Cmb(new AbilityScore(14), new AbilityScore(8), new BaseAttackBonus(3), new Size(SizeType.MEDIUM));

    assertEquals(5, cmb.getScore());
  }
  
  @Test
  public void testGetScoreWithHitDice()
  {
    Cmb cmb = new Cmb(new AbilityScore(14), new AbilityScore(8), new BaseAttackBonus(3), new Size(SizeType.MEDIUM));
    
    HitPoints hitDice = new HitPoints(new AbilityScore());
    hitDice.addDice(new Dice(1, 8));
    
    cmb.setHitDice(hitDice);

    assertEquals(3, cmb.getScore());
  }
  
  @Test
  public void testGetScoreTinySize()
  {
    Cmb cmb = new Cmb(new AbilityScore(14), new AbilityScore(8), new BaseAttackBonus(3), new Size(SizeType.TINY));

    assertEquals(0, cmb.getScore());
    
  }
  
  @Test
  public void testGetScoreLargeSize()
  {
    Cmb cmb = new Cmb(new AbilityScore(14), new AbilityScore(8), new BaseAttackBonus(3), new Size(SizeType.LARGE));

    assertEquals(6, cmb.getScore());
    
  }

  @Test
  public void testRoll()
  {
    Cmb cmb = new Cmb(new AbilityScore(14), new AbilityScore(8), new BaseAttackBonus(3), new Size(SizeType.MEDIUM));
    
    boolean checkRange = true;
    for(int i = 0; i < 100; i++)
    {
      int roll = cmb.roll();
      
      if(roll < 6 || roll > 25)
        checkRange = false;
    }
    
    assertTrue(checkRange);
  }

}
