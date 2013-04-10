package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;

public class BonusTest
{
  // This is just a basic implementation of abstract class Bonus.
  private static class BonusStub extends Bonus
  {

    public BonusStub(int value, BonusType type)
    {
      this(value, type, null);
    }

    public BonusStub(int value, BonusType type, String circumstance)
    {
      super(value, type, circumstance);
    }

    @Override
    public void applyTo(Creature target)
    {
      applyToStat(null);
    }

    @Override
    public void removeFrom(Creature target)
    {
      removeFromStat(null);
    }

    @Override
    public Bonus newBonus(int offset)
    {
      return new BonusStub(getValue() - offset, getType(), getCircumstance());
    }
    
  }

  @Test (expected = IllegalArgumentException.class)  
  public void testInitiativeBonusIntNull()
  {
    new BonusStub(2, null);
  }

  @Test
  public void testGetValue()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    assertEquals(2, bonus.getValue());
  }

  @Test
  public void testGetType()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    assertEquals(BonusTypeRegister.getInstance().get("Armor"), bonus.getType());
  }

  @Test
  public void testGetCircumstanceNull()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    assertNull(bonus.getCircumstance());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testGetCircumstanceEmpty()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"), "");
    assertNull(bonus.getCircumstance());
  }

  @Test
  public void testToString()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    assertEquals("+2 Armor", bonus.toString());
  }

  @Test
  public void testGetCircumstance()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"), "a string");
    assertEquals("a string", bonus.getCircumstance());
  }
  
  @Test
  public void testIsCircumstantial()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"), "a string");
    assertTrue(bonus.isCircumstantial());
  }
  
  @Test
  public void testToStringCircumstantial()
  {
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"), "a string");
    assertEquals("+2 Armor (a string)", bonus.toString());
  }
  
  @Test
  public void testToStringNegative()
  {
    Bonus bonus = new BonusStub(-2, BonusTypeRegister.getInstance().get("Armor"));
    assertEquals("-2 Armor", bonus.toString());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testApplyToStatNull()
  {
    Character character = new Character();
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.applyTo(character);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromStatNull()
  {
    Character character = new Character();
    Bonus bonus = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    bonus.removeFrom(character);
  }
  
  @Test
  public void testComparToGreater()
  {
    Bonus bonus1 = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new BonusStub(1, BonusTypeRegister.getInstance().get("Armor"));
    
    // Descending order -> biggest returns "smaller"
    assertEquals(-1, bonus1.compareTo(bonus2));
  }
  
  @Test
  public void testComparToEqual()
  {
    Bonus bonus1 = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));
    assertEquals(0, bonus1.compareTo(bonus2));
  }
  
  @Test
  public void testComparToLesser()
  {
    Bonus bonus1 = new BonusStub(1, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new BonusStub(2, BonusTypeRegister.getInstance().get("Armor"));

    // Descending order -> smallest returns "bigger"
    assertEquals(1, bonus1.compareTo(bonus2));
  }
  
}
