package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.stats.Stat;

public class StatTest
{
  private class StatStub extends Stat
  {
    public StatStub(int baseScore)
    {
      super(baseScore);
    }
  }

  @Test
  public void testGetBaseScore()
  {
    Stat stat = new Stat(10);
    assertEquals(10, stat.getBaseScore());
  }

  @Test
  public void testSetBaseScore()
  {
    Stat stat = new Stat(5);
    stat.setBaseScore(10);
    assertEquals(10, stat.getBaseScore());
  }

  @Test
  public void testGetScore()
  {
    Stat stat = new Stat(5);
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Dodge")));
    assertEquals(9, stat.getScore());
  }

  @Test
  public void testIncrementBaseScore()
  {
    Stat stat = new Stat(5);
    stat.incrementBaseScore(5);
    assertEquals(10, stat.getBaseScore());
  }
  
  @Test
  public void testAddBonus()
  {
    Bonus bonus1 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Dodge"), "when jumping");
    
    Stat stat = new StatStub(0);
    stat.addBonus(bonus1);
    stat.addBonus(bonus2);
    
    assertEquals("2 [+2 Dodge (when jumping)]", stat.toString());
  }
  
  @Test
  public void testRemoveBonus()
  {
    Bonus bonus1 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Dodge"), "when jumping");
    
    Stat stat = new StatStub(0);
    stat.addBonus(bonus1);
    stat.addBonus(bonus2);
    stat.removeBonus(bonus1);
    
    assertEquals("0 [+2 Dodge (when jumping)]", stat.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddBonusNull()
  {
    Stat stat = new Stat(5);
    stat.addBonus(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveBonusNull()
  {
    Stat stat = new Stat(5);
    stat.removeBonus(null);
  }

  @Test
  public void testToString()
  {
    Stat stat = new Stat(5);
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    assertEquals("7", stat.toString());
  }

  @Test
  public void testToStringCircumstantial()
  {
    Stat stat = new Stat(5);
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Dodge"), "when x happens"));
    stat.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Enhancement"), "when y happens"));
    
    assertEquals("7 [+2 Dodge (when x happens), +2 Enhancement (when y happens)]", stat.toString());
  }

}
