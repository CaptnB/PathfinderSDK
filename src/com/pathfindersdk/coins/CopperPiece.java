package com.pathfindersdk.coins;

public class CopperPiece extends Piece
{

  public CopperPiece(int number)
  {
    super(number);
  }

  @Override
  public int getValue()
  {
    return getNumber();
  }

  @Override
  public String toString()
  {
    return getNumber() + " cp";
  }
}
