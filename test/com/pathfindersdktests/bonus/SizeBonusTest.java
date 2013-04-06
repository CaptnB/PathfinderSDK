package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SizeBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class SizeBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    bonus = new SizeBonus(2, BonusType.ARMOR);
  }

  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(SizeType.HUGE, character.getSize().getSize());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(SizeType.MEDIUM, character.getSize().getSize());
  }

}
