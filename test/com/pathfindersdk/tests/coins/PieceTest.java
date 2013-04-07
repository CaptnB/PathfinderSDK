package com.pathfindersdk.tests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.Piece;

public class PieceTest
{
  private class PieceStub extends Piece
  {

    public PieceStub(int number)
    {
      super(number);
    }

    @Override
    public int getValue()
    {
      return 0;
    }
    
  }

  @Test
  public void testGetNumber()
  {
    Piece p = new PieceStub(10);
    assertEquals(10, p.getNumber());
  }

  @Test
  public void testSetNumber()
  {
    Piece p = new PieceStub(10);
    p.setNumber(20);
    assertEquals(20, p.getNumber());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetNegativeNumber()
  {
    new PieceStub(-10);
  }

  @Test
  public void testAdd()
  {
    Piece p = new PieceStub(10);
    p.add(20);
    assertEquals(30, p.getNumber());
  }

}
