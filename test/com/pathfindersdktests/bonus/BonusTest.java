package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class BonusTest
{
  // This is just a basic implementation of abstract class Bonus.
  private class BasicBonus extends Bonus
  {

    public BasicBonus(Integer value, BonusType type)
    {
      super(value, type);
    }

    public BasicBonus(Integer value, BonusType type, String circumstance)
    {
      super(value, type, circumstance);
    }

    @Override
    public void applyTo(Creature target)
    {
      // No need to test this here.
    }

    @Override
    public void removeFrom(Creature target)
    {
      // No need to test this here.
    }
    
  }

  @Test
  public void testBonusIntegerBonusType()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR);
    assertNotNull(bonus);
  }

  @Test
  public void testBonusIntegerBonusTypeString()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR, "a string");
    assertNotNull(bonus);
  }

  @Test (expected = IllegalArgumentException.class)  
  public void testInitiativeBonusNullBonusType()
  {
    new BasicBonus(null, BonusType.ARMOR);
  }

  @Test (expected = IllegalArgumentException.class)  
  public void testInitiativeBonusIntNull()
  {
    new BasicBonus(2, null);
  }

  @Test  
  public void testInitiativeBonusIntBonusTypeNull()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR, null);
    assertFalse(bonus.isCircumstantial());
  }

  @Test
  public void testGetValue()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR);
    assertEquals(2, bonus.getValue().intValue());
  }

  @Test
  public void testGetType()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR);
    assertEquals(BonusType.ARMOR, bonus.getType());
  }

  @Test
  public void testGetCircumstance()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR, "a string");
    assertEquals("a string", bonus.getCircumstance());
  }

  @Test
  public void testGetCircumstanceNull()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR);
    assertNull(bonus.getCircumstance());
  }
  
  @Test
  public void testIsCircumstantial()
  {
    Bonus bonus = new BasicBonus(2, BonusType.ARMOR, "a string");
    assertTrue(bonus.isCircumstantial());
  }
}
