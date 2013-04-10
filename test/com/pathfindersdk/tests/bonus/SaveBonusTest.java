package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SaveType;

public class SaveBonusTest
{

  @Test (expected = IllegalArgumentException.class) 
  public void testSaveBonusIntBonusTypeNull()
  {
    new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), null);
  }

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), SaveType.FORT);
    bonus.applyTo(character);

    assertEquals(2, character.getFortitude().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), SaveType.FORT);
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(0, character.getFortitude().getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), SaveType.FORT);
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), SaveType.FORT);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new SaveBonus(2, BonusTypeRegister.getInstance().get("Armor"), SaveType.FORT);
    bonus.removeFrom(null);
  }

}
