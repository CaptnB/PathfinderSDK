package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SkillBonus;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusTypeRegister;

public class SkillBonusTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testSkillBonusIntBonusTypeNull()
  {
    new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), null);
  }

  @Test
  public void testApplyTo()
  {
    Character character = new Character();
    character.addSkill(new SkillItem("Acrobatics", AbilityType.CHA, true, false));

    Bonus bonus = new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), "Acrobatics");
    bonus.applyTo(character);

    assertEquals(2, character.getSkill("Acrobatics").getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();
    character.addSkill(new SkillItem("Acrobatics", AbilityType.CHA, true, false));

    Bonus bonus = new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), "Acrobatics");
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(0, character.getSkill("Acrobatics").getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), "Acrobatics");
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), "Acrobatics");
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new SkillBonus(2, BonusTypeRegister.getInstance().get("Armor"), "Acrobatics");
    bonus.removeFrom(null);
  }

}
