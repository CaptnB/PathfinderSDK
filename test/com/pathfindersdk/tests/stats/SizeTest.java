package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SizeBonus;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class SizeTest
{
  @Test (expected = IllegalArgumentException.class)
  public void testSizeNull()
  {
    new Size(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSizeNegativeLegs()
  {
    new Size(SizeType.COLOSSAL, -1);
  }
  
  @Test
  public void testGetBaseSize()
  {
    Size size = new Size(SizeType.COLOSSAL);
    
    assertEquals(SizeType.COLOSSAL, size.getBaseSize());
  }
  
  @Test
  public void testGetNumberOfLegs()
  {
    Size size = new Size(SizeType.COLOSSAL, 8);
    
    assertEquals(8, size.getNumberOfLegs());
  }
  
  @Test
  public void testSetBaseScore()
  {
    Size size = new Size(SizeType.COLOSSAL);
    size.setBaseScore(4);
    
    assertEquals(0, size.getBaseScore());
  }
  
  @Test
  public void testGetSize()
  {
    Size size = new Size(SizeType.MEDIUM);
    Bonus bonus = new SizeBonus(2, BonusTypeRegister.getInstance().get("Untyped")); // +2 bonus : MEDIUM -> LARGE -> HUGE
    size.addBonus(bonus);
    
    assertEquals(SizeType.HUGE, size.getSize());
  }
  
  @Test
  public void testGetSizeUpperLimit()
  {
    Size size = new Size(SizeType.MEDIUM);
    Bonus bonus = new SizeBonus(5, BonusTypeRegister.getInstance().get("Untyped")); // +5 bonus but only 4 size categories above MEDIUM
    size.addBonus(bonus);
    
    assertEquals(SizeType.COLOSSAL, size.getSize());
  }
  
  @Test
  public void testGetSizeLowerLimit()
  {
    Size size = new Size(SizeType.MEDIUM);
    Bonus bonus = new SizeBonus(-5, BonusTypeRegister.getInstance().get("Untyped"));  // -5 bonus but only 4 size categories below MEDIUM
    size.addBonus(bonus);
    
    assertEquals(SizeType.FINE, size.getSize());
  }
  
  @Test
  public void testGetModifier()
  {
    Integer[] expected = {8, 4, 2, 1, 0, -1, -2, -4, -8};
 
    List<Integer> resultList = new ArrayList<Integer>();
    for(SizeType sizeType : SizeType.values())
    {
      Size size = new Size(sizeType);
      resultList.add(size.getModifier());
    }
    
    assertArrayEquals(expected, resultList.toArray());
  }
  
  @Test
  public void testGetSkillModifier()
  {
    Integer[] expected = {8, 6, 4, 2, 0, -2, -4, -6, -8};
 
    List<Integer> resultList = new ArrayList<Integer>();
    for(SizeType sizeType : SizeType.values())
    {
      Size size = new Size(sizeType);
      resultList.add(size.getSkillModifier());
    }
    
    assertArrayEquals(expected, resultList.toArray());
  }
  
  @Test
  public void testGetSpace()
  {
    Double[] expected = {0.5, 1.0, 2.5, 5.0, 5.0, 10.0, 15.0, 20.0, 30.0};
 
    List<Double> resultList = new ArrayList<Double>();
    for(SizeType sizeType : SizeType.values())
    {
      Size size = new Size(sizeType);
      resultList.add(size.getSpace());
    }
    
    assertArrayEquals(expected, resultList.toArray());
  }
  
  @Test
  public void testGetReachTall()
  {
    Double[] expected = {0.0, 0.0, 0.0, 5.0, 5.0, 10.0, 15.0, 20.0, 30.0};
 
    List<Double> resultList = new ArrayList<Double>();
    for(SizeType sizeType : SizeType.values())
    {
      Size size = new Size(sizeType);
      resultList.add(size.getReach());
    }
    
    assertArrayEquals(expected, resultList.toArray());
  }
  
  @Test
  public void testGetReachLong()
  {
    Double[] expected = {0.0, 0.0, 0.0, 5.0, 5.0, 5.0, 10.0, 15.0, 20.0};
 
    List<Double> resultList = new ArrayList<Double>();
    for(SizeType sizeType : SizeType.values())
    {
      Size size = new Size(sizeType, 4);
      resultList.add(size.getReach());
    }
    
    assertArrayEquals(expected, resultList.toArray());
  }
  
  @Test
  public void testIsTallWithoutLegs()
  {
    Size size = new Size(SizeType.COLOSSAL, 0);
    
    assertFalse(size.isTall());
  }
  
  @Test
  public void testIsTallWithTwoLegs()
  {
    Size size = new Size(SizeType.COLOSSAL, 2);
    
    assertTrue(size.isTall());
  }
  
  @Test
  public void testIsTallWithFourLegs()
  {
    Size size = new Size(SizeType.COLOSSAL, 4);
    
    assertFalse(size.isTall());
  }

  @Test
  public void testToString()
  {
    Size size = new Size(SizeType.COLOSSAL);
    
    assertEquals("Colossal", size.toString());
  }
}
