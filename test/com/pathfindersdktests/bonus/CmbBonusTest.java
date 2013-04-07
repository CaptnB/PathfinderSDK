package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.CmbBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class CmbBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new CmbBonus(2, BonusType.ARMOR);
    bonus.applyTo(character);

    assertEquals(2, character.getCmb().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new CmbBonus(2, BonusType.ARMOR);
    bonus.removeFrom(character);
    
    assertEquals(0, character.getCmb().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new CmbBonus(2, BonusType.ARMOR);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new CmbBonus(2, BonusType.ARMOR);
    bonus.removeFrom(null);
  }

}
