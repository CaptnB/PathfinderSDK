package com.pathfindersdk.tests.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.coins.GoldPiece;
import com.pathfindersdk.coins.Piece;

public class GoldPieceTest
{

  @Test
  public void testGetValue()
  {
    Piece gp = new GoldPiece(10);
    assertEquals(1000, gp.getValue());
  }

  @Test
  public void testToString()
  {
    Piece gp = new GoldPiece(10);
    assertEquals("10 gp", gp.toString());
  }

}
