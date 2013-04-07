package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SaveType;

public class SaveBonusTest
{

  @Test (expected = IllegalArgumentException.class) 
  public void testSaveBonusIntBonusTypeNull()
  {
    new SaveBonus(2, BonusType.ARMOR, null);
  }

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new SaveBonus(2, BonusType.ARMOR, SaveType.FORT);
    bonus.applyTo(character);

    assertEquals(2, character.getFortitude().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new SaveBonus(2, BonusType.ARMOR, SaveType.FORT);
    bonus.removeFrom(character);

    assertEquals(0, character.getFortitude().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new SaveBonus(2, BonusType.ARMOR, SaveType.FORT);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new SaveBonus(2, BonusType.ARMOR, SaveType.FORT);
    bonus.removeFrom(null);
  }

}
