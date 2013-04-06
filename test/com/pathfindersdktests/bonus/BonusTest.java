package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.enums.BonusType;

public class BonusTest
{
  // This is just a basic implementation of abstract class Bonus.
  private static class BasicBonus extends Bonus
  {

    public BasicBonus(int value, BonusType type)
    {
      this(value, type, null);
    }

    public BasicBonus(int value, BonusType type, String circumstance)
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
    
  }

  static Character character;
  static Bonus bonus;
  static Bonus negBonus;
  static Bonus circBonus;
  
  @BeforeClass
  public static void initTests()
  {
    character = new Character();
    bonus = new BasicBonus(2, BonusType.ARMOR);
    negBonus = new BasicBonus(-2, BonusType.ARMOR);
    circBonus = new BasicBonus(2, BonusType.ARMOR, "a string");
  }

  @Test (expected = IllegalArgumentException.class)  
  public void testInitiativeBonusIntNull()
  {
    new BasicBonus(2, null);
  }

  @Test
  public void testGetValue()
  {
    assertEquals(2, bonus.getValue());
  }

  @Test
  public void testGetType()
  {
    assertEquals(BonusType.ARMOR, bonus.getType());
  }

  @Test
  public void testGetCircumstanceNull()
  {
    assertNull(bonus.getCircumstance());
  }
  
  @Test
  public void testToString()
  {
    assertEquals("+2 Armor", bonus.toString());
  }

  @Test
  public void testGetCircumstance()
  {
    assertEquals("a string", circBonus.getCircumstance());
  }
  
  @Test
  public void testIsCircumstantial()
  {
    assertTrue(circBonus.isCircumstantial());
  }
  
  @Test
  public void testToStringCircumstantial()
  {
    assertEquals("+2 Armor (a string)", circBonus.toString());
  }
  
  @Test
  public void testToStringNegative()
  {
    assertEquals("-2 Armor", negBonus.toString());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    bonus.applyTo(character);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    bonus.removeFrom(character);
  }
  
}
