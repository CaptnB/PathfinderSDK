package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SaveType;

public class SaveBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    bonus = new SaveBonus(2, BonusType.ARMOR, SaveType.FORT);
  }

  @Test (expected = IllegalArgumentException.class) 
  public void testSaveBonusIntegerBonusTypeNull()
  {
    new SaveBonus(2, BonusType.ARMOR, null);
  }

  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(2, character.getFortitude().getScore().intValue());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(0, character.getFortitude().getScore().intValue());
  }

}
