package com.pathfindersdk.tests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.Piece;
import com.pathfindersdk.coins.PlatinumPiece;

public class PlatinumPieceTest
{

  @Test
  public void testGetValue()
  {
    Piece pp = new PlatinumPiece(10);
    assertEquals(10000, pp.getValue());
  }

  @Test
  public void testToString()
  {
    Piece pp = new PlatinumPiece(10);
    assertEquals("10 pp", pp.toString());
  }

}
