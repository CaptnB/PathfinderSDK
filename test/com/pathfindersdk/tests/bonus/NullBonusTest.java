package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.NullBonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.creatures.Character;

public class NullBonusTest
{

  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new NullBonus();
    Bonus bonus2 = bonus1.newBonus(3);
    assertNotSame(bonus1, bonus2);
  }

  @Test
  public void testApplyTo()
  {
    Creature creature = new Character();
    Bonus bonus = new NullBonus();
    bonus.applyTo(creature);
  }

  @Test
  public void testRemoveFrom()
  {
    Creature creature = new Character();
    Bonus bonus = new NullBonus();
    bonus.removeFrom(creature);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new NullBonus();
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new NullBonus();
    bonus.removeFrom(null);
  }

}
