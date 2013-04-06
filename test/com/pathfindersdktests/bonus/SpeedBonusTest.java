package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SpeedBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Stat;

public class SpeedBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    character.addSpeed(SpeedType.BASE, new Stat(30));
    bonus = new SpeedBonus(10, BonusType.ARMOR, SpeedType.BASE);
  }


  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(40, character.getSpeed(SpeedType.BASE).getScore().intValue());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(30, character.getSpeed(SpeedType.BASE).getScore().intValue());
  }

}
