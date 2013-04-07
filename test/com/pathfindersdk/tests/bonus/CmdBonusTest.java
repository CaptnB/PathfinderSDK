package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.CmdBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class CmdBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new CmdBonus(2, BonusType.ARMOR);
    bonus.applyTo(character);

    assertEquals(12, character.getCmd().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new CmdBonus(2, BonusType.ARMOR);
    bonus.removeFrom(character);

    assertEquals(10, character.getCmd().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new CmdBonus(2, BonusType.ARMOR);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new CmdBonus(2, BonusType.ARMOR);
    bonus.removeFrom(null);
  }

}
