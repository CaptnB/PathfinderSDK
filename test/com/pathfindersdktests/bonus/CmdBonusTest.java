package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.CmdBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class CmdBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    bonus = new CmdBonus(2, BonusType.ARMOR);
  }


  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(12, character.getCmd().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(10, character.getCmd().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    bonus.removeFrom(null);
  }

}
