package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AbilityBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;

public class AbilityBonusTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testAbilityBonusIntBonusTypeNull()
  {
    new AbilityBonus(2, BonusType.ARMOR, null);
  }

  @Test
  public void testApplyTo()
  {
    Creature creature = new Character();
    
    Bonus bonus = new AbilityBonus(2, BonusType.ARMOR, AbilityType.CHA);
    bonus.applyTo(creature);

    assertEquals(12, creature.getAbilityScore(AbilityType.CHA).getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Creature creature = new Character();
    
    Bonus bonus = new AbilityBonus(2, BonusType.ARMOR, AbilityType.CHA);
    bonus.applyTo(creature);
    bonus.removeFrom(creature);

    assertEquals(10, creature.getAbilityScore(AbilityType.CHA).getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new AbilityBonus(2, BonusType.ARMOR, AbilityType.CHA);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new AbilityBonus(2, BonusType.ARMOR, AbilityType.CHA);
    bonus.removeFrom(null);
  }

}
