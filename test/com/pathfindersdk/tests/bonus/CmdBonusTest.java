package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.CmdBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class CmdBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));

    Bonus bonus = new CmdBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);

    assertEquals(12, character.getCmd().getScore());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));

    Bonus bonus = new CmdBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    bonus.removeFrom(character);

    assertEquals(10, character.getCmd().getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new CmdBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new CmdBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new CmdBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.removeFrom(null);
  }

}
