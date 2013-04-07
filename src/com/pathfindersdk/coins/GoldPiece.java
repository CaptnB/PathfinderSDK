package com.pathfindersdk.coins;

public class GoldPiece extends Piece
{

  public GoldPiece(int number)
  {
    super(number);
  }

  @Override
  public int getValue()
  {
    return getNumber() * 100;
  }

  @Override
  public String toString()
  {
    return getNumber() + " gp";
  }
}
