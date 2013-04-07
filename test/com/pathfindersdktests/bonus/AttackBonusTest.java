package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AttackBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class AttackBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new AttackBonus(2, BonusType.ENHANCEMENT);
    bonus.applyTo(character);

    assertEquals(2, character.getAttack().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new AttackBonus(2, BonusType.ENHANCEMENT);
    bonus.removeFrom(character);

    assertEquals(0, character.getAttack().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new AttackBonus(2, BonusType.ENHANCEMENT);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new AttackBonus(2, BonusType.ENHANCEMENT);
    bonus.removeFrom(null);
  }

}
