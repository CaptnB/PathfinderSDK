package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.pathfindersdk.stats.Dice;

public class DiceTest
{

  @Test
  public void testRolWithoutSeed()
  {
    Dice dice = new Dice(3, 6);
    
    boolean checkRange = true;
    for(int i = 0; i < 100; i++)
    {
      int roll = dice.roll();
      
      if(roll < 3 || roll > 18)
        checkRange = false;
    }
    
    assertTrue(checkRange);
  }

  @Test
  public void testRollWithSeed()
  {
    Random random = new Random();
    Dice dice = new Dice(3, 6, random.nextInt());
    
    boolean checkSame = true;
    int roll1 = dice.roll();
    for(int i = 0; i < 100; i++)
    {
      int roll2 = dice.roll();
      if(roll1 != roll2)
        checkSame = false;
    }
    
    assertTrue(checkSame);
  }

}
