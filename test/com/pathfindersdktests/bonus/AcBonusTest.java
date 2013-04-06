package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class AcBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    // armor class requires character to have a size
    character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));

    bonus = new AcBonus(2, BonusType.ARMOR);
  }

  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(12, character.getArmorClass().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(10, character.getArmorClass().getScore());
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
