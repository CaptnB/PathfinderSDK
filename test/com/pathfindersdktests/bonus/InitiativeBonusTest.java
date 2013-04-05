package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.InitiativeBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;

public class InitiativeBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    bonus = new InitiativeBonus(2, BonusType.LUCK);
  }

  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(2, character.getInitiative().getScore().intValue());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(0, character.getInitiative().getScore().intValue());
  }

}
