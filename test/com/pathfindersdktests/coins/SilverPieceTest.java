package com.pathfindersdktests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.Piece;
import com.pathfindersdk.coins.SilverPiece;

public class SilverPieceTest
{

  @Test
  public void testGetValue()
  {
    Piece sp = new SilverPiece(10);
    assertEquals(100, sp.getValue());
  }

  @Test
  public void testToString()
  {
    Piece sp = new SilverPiece(10);
    assertEquals("10 sp", sp.toString());
  }

}
