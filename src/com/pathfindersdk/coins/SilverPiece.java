package com.pathfindersdk.coins;

public class SilverPiece extends Piece
{

  public SilverPiece(int number)
  {
    super(number);
  }

  @Override
  public int getValue()
  {
    return getNumber() * 10;
  }

  @Override
  public String toString()
  {
    return getNumber() + " sp";
  }
}
