package com.pathfindersdktests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.CopperPiece;
import com.pathfindersdk.coins.Piece;

public class CopperPieceTest
{

  @Test
  public void testGetValue()
  {
    Piece cp = new CopperPiece(10);
    assertEquals(10, cp.getValue());
  }

  @Test
  public void testToString()
  {
    Piece cp = new CopperPiece(10);
    assertEquals("10 cp", cp.toString());
  }

}
