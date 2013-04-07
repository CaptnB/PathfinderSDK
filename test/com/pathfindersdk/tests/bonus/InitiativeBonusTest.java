package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.InitiativeBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class InitiativeBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();

    Bonus bonus = new InitiativeBonus(2, BonusType.LUCK);
    bonus.applyTo(character);

    assertEquals(2, character.getInitiative().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();

    Bonus bonus = new InitiativeBonus(2, BonusType.LUCK);
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(0, character.getInitiative().getScore());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new InitiativeBonus(2, BonusType.LUCK);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new InitiativeBonus(2, BonusType.LUCK);
    bonus.removeFrom(null);
  }

}
