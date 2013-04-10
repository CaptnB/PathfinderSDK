package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class AcBonusTest
{

  @Test
  public void testApplyToAc()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    
    assertEquals(12, character.getArmorClass().getScore());
  }

  @Test
  public void testRemoveFromAc()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    bonus.removeFrom(character);
    
    assertEquals(10, character.getArmorClass().getScore());
  }

  @Test
  public void testApplyToCmd1()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    
    // ARMOR bonus does not add to CMD
    assertEquals(10, character.getCmd().getScore());
  }

  @Test
  public void testRemoveFromCmd1()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    bonus.removeFrom(character);
    
    // ARMOR bonus does not add to CMD
    assertEquals(10, character.getCmd().getScore());
  }

  @Test
  public void testApplyToCmd2()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Dodge"));
    bonus.applyTo(character);
    
    // DODGE bonus add to CMD
    assertEquals(12, character.getCmd().getScore());
  }

  @Test
  public void testRemoveFromCmd2()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));
    
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
    bonus.removeFrom(character);
    
    // DODGE bonus add to CMD
    assertEquals(10, character.getCmd().getScore());
  }
  
  @Test
  public void testNewBonus()
  {
    Bonus bonus1 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = bonus1.newBonus(1);
    
    assertEquals("+1 Armor", bonus2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.removeFrom(null);
  }

}
