package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AttackBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusTypeRegister;

public class AttackBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new AttackBonus(2, BonusTypeRegister.getInstance().get("Enhancement"));
    bonus.applyTo(character);

    assertEquals(2, character.getAttack().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new AttackBonus(2, BonusTypeRegister.getInstance().get("Enhancement"));
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(0, character.getAttack().getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new AttackBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new AttackBonus(2, BonusTypeRegister.getInstance().get("Enhancment"));
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new AttackBonus(2, BonusTypeRegister.getInstance().get("Enhancement"));
    bonus.removeFrom(null);
  }

}
