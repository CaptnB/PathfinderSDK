package com.pathfindersdk.coins;

public class PlatinumPiece extends Piece
{

  public PlatinumPiece(int number)
  {
    super(number);
  }

  @Override
  public int getValue()
  {
    return getNumber() * 1000;
  }

  @Override
  public String toString()
  {
    return getNumber() + " pp";
  }
}
