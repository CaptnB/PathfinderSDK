package com.pathfindersdktests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.coins.CopperPiece;
import com.pathfindersdk.coins.GoldPiece;
import com.pathfindersdk.coins.PlatinumPiece;
import com.pathfindersdk.coins.SilverPiece;

public class CoinsTest
{

  @Test
  public void testAdd5Copper()
  {
    Coins coins = new Coins();
    coins.add(new CopperPiece(5));
    assertEquals("5 cp", coins.toString());
  }

  @Test
  public void testAdd15Copper()
  {
    Coins coins = new Coins();
    coins.add(new CopperPiece(15));
    assertEquals("1 sp, 5 cp", coins.toString());
  }

  @Test
  public void testAdd5Silver()
  {
    Coins coins = new Coins();
    coins.add(new SilverPiece(5));
    assertEquals("5 sp", coins.toString());
  }

  @Test
  public void testAdd15Silver()
  {
    Coins coins = new Coins();
    coins.add(new SilverPiece(15));
    assertEquals("1 gp, 5 sp", coins.toString());
  }

  @Test
  public void testAdd5Gold()
  {
    Coins coins = new Coins();
    coins.add(new GoldPiece(5));
    assertEquals("5 gp", coins.toString());
  }

  @Test
  public void testAdd15Gold()
  {
    Coins coins = new Coins();
    coins.add(new GoldPiece(15));
    assertEquals("1 pp, 5 gp", coins.toString());
  }

  @Test
  public void testAdd5Platinum()
  {
    Coins coins = new Coins();
    coins.add(new PlatinumPiece(5));
    assertEquals("5 pp", coins.toString());
  }

  @Test
  public void testAdd15Platinum()
  {
    Coins coins = new Coins();
    coins.add(new PlatinumPiece(15));
    assertEquals("15 pp", coins.toString());
  }

  @Test
  public void testAddFewOfEach()
  {
    Coins coins = new Coins();
    coins.add(new CopperPiece(3));
    coins.add(new SilverPiece(3));
    coins.add(new GoldPiece(3));
    coins.add(new PlatinumPiece(3));    
    assertEquals("3 pp, 3 gp, 3 sp, 3 cp", coins.toString());
  }

  @Test
  public void testAddLotsOfEach()
  {
    Coins coins = new Coins();
    coins.add(new CopperPiece(123));
    coins.add(new SilverPiece(123));
    coins.add(new GoldPiece(123));
    coins.add(new PlatinumPiece(123));    
    assertEquals("136 pp, 6 gp, 5 sp, 3 cp", coins.toString());
  }

  @Test
  public void testCoinsEmpty()
  {
    Coins coins = new Coins();
    assertEquals("0 cp", coins.toString());
  }
  
}
