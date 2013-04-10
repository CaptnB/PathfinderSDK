package com.pathfindersdk.tests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.BonusBlock;
import com.pathfindersdk.enums.BonusTypeRegister;

public class BonusBlockTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testAddBonusNull()
  {
    BonusBlock block = new BonusBlock();
    block.addBonus(null);
  }

  @Test
  public void testAddBonusBase()
  {
    BonusBlock block = new BonusBlock();
    block.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    
    assertEquals(1, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testAddBonusBaseTwice()
  {
    // First bonus forces the creation of a BonusGroup, 2nd reuses it
    BonusBlock block = new BonusBlock();
    block.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor")));
    block.addBonus(new AcBonus(3, BonusTypeRegister.getInstance().get("Armor")));
    
    // Only the biggest one is applicable
    assertEquals(1, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testAddBonusCircumstantial()
  {
    BonusBlock block = new BonusBlock();
    block.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when x happens"));
    
    assertEquals(1, block.getApplicableCircumstantialBonus().size());
  }

  @Test
  public void testAddBonusCircumstantialTwice()
  {
    BonusBlock block = new BonusBlock();
    block.addBonus(new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when x happens"));
    block.addBonus(new AcBonus(3, BonusTypeRegister.getInstance().get("Armor"), "when y happens"));
    
    assertEquals(2, block.getApplicableCircumstantialBonus().size());
  }

  @Test
  public void testRemoveBonusBase()
  {
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));

    BonusBlock block = new BonusBlock();
    block.addBonus(bonus);
    block.removeBonus(bonus);
    
    assertEquals(0, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testRemoveBonusBaseTwice()
  {
    Bonus bonus1 = new AcBonus(1, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));

    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);
    block.removeBonus(bonus1);
    block.removeBonus(bonus2);
    
    assertEquals(0, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testRemoveBonusCircumstantial()
  {
    Bonus bonus = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when x happens");

    BonusBlock block = new BonusBlock();
    block.addBonus(bonus);
    block.removeBonus(bonus);
    
    assertEquals(0, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testRemoveBonusCircumstantialTwice()
  {
    Bonus bonus1 = new AcBonus(1, BonusTypeRegister.getInstance().get("Armor"), "when x happens");
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when x happens");

    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);
    block.removeBonus(bonus1);
    block.removeBonus(bonus2);
    
    assertEquals(0, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testGetApplicableBaseBonus()
  {
    Bonus bonus1 = new AcBonus(1, BonusTypeRegister.getInstance().get("Untyped"));
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Untyped"));
    Bonus bonus3 = new AcBonus(1, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus4 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));       // Superseeds bonus3
    Bonus bonus5 = new AcBonus(1, BonusTypeRegister.getInstance().get("Deflection"));
    Bonus bonus6 = new AcBonus(2, BonusTypeRegister.getInstance().get("Deflection"));  // Superseeds bonus5
    Bonus bonus7 = new AcBonus(1, BonusTypeRegister.getInstance().get("Dodge"), "not a base bonus");   // Dodge group exists without any base bonus
    
    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);
    block.addBonus(bonus3);
    block.addBonus(bonus4);
    block.addBonus(bonus5);
    block.addBonus(bonus6);
    block.addBonus(bonus7);
    
    assertEquals(4, block.getApplicableBaseBonus().size());
  }

  @Test
  public void testGetApplicableCircumstantialBonus()
  {
    Bonus bonus1 = new AcBonus(1, BonusTypeRegister.getInstance().get("Untyped"), "when x happens");
    Bonus bonus2 = new AcBonus(2, BonusTypeRegister.getInstance().get("Untyped"), "when y happens");
    Bonus bonus3 = new AcBonus(1, BonusTypeRegister.getInstance().get("Armor"), "when x happens");
    Bonus bonus4 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when y happens");
    Bonus bonus5 = new AcBonus(1, BonusTypeRegister.getInstance().get("Deflection"), "when x happens");
    Bonus bonus6 = new AcBonus(2, BonusTypeRegister.getInstance().get("Deflection"), "when y happens");
    
    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);
    block.addBonus(bonus3);
    block.addBonus(bonus4);
    block.addBonus(bonus5);
    block.addBonus(bonus6);

    assertEquals(6, block.getApplicableCircumstantialBonus().size());
  }

  @Test
  public void testGetApplicableCircumstantialBonusOffset1()
  {
    Bonus bonus1 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new AcBonus(1, BonusTypeRegister.getInstance().get("Armor"), "when x happens");   // Smaller than base bonus => not applicable
    Bonus bonus3 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"), "when y happens");   // Equal to base bonus => not applicable
    Bonus bonus4 = new AcBonus(3, BonusTypeRegister.getInstance().get("Armor"), "when z happens");   // Bigger than base bonus => applicable
    
    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);
    block.addBonus(bonus3);
    block.addBonus(bonus4);

    assertEquals(1, block.getApplicableCircumstantialBonus().size());
  }


  @Test
  public void testGetApplicableCircumstantialBonusOffset2()
  {
    Bonus bonus1 = new AcBonus(2, BonusTypeRegister.getInstance().get("Armor"));
    Bonus bonus2 = new AcBonus(3, BonusTypeRegister.getInstance().get("Armor"), "when x happens");   // Bigger than base bonus by 1 => +1
    
    BonusBlock block = new BonusBlock();
    block.addBonus(bonus1);
    block.addBonus(bonus2);

    Bonus bonus = block.getApplicableCircumstantialBonus().first();
    assertEquals("+1 Armor (when x happens)", bonus.toString());
  }
}
