package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SkillBonus;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusType;

public class SkillBonusTest
{
  static Character character;
  static Bonus bonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    character.addSkill(new SkillItem("Acrobatics", AbilityType.CHA, false, false));
    bonus = new SkillBonus(2, BonusType.ARMOR, "Acrobatics");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSkillBonusIntBonusTypeNull()
  {
    new SkillBonus(2, BonusType.ARMOR, null);
  }

  @Test
  public void testApplyTo()
  {
    bonus.applyTo(character);
    assertEquals(2, character.getSkill("Acrobatics").getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    bonus.removeFrom(character);
    assertEquals(0, character.getSkill("Acrobatics").getScore());
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
