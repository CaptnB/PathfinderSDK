package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SpeedBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Stat;

public class SpeedBonusTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testBonusIntBonusTypeNull()
  {
    new SpeedBonus(10, BonusTypeRegister.getInstance().get("Armor"), null);
  }

  @Test
  public void testApplyTo()
  {
    Character character = new Character();
    character.addSpeed(SpeedType.BASE, new Stat(30));

    Bonus bonus = new SpeedBonus(10, BonusTypeRegister.getInstance().get("Armor"), SpeedType.BASE);
    bonus.applyTo(character);

    assertEquals(40, character.getSpeed(SpeedType.BASE).getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();
    character.addSpeed(SpeedType.BASE, new Stat(30));

    Bonus bonus = new SpeedBonus(10, BonusTypeRegister.getInstance().get("Armor"), SpeedType.BASE);
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(30, character.getSpeed(SpeedType.BASE).getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new SpeedBonus(2, BonusTypeRegister.getInstance().get("Armor"), SpeedType.BASE);
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new SpeedBonus(10, BonusTypeRegister.getInstance().get("Armor"), SpeedType.BASE);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new SpeedBonus(10, BonusTypeRegister.getInstance().get("Armor"), SpeedType.BASE);
    bonus.removeFrom(null);
  }

}
