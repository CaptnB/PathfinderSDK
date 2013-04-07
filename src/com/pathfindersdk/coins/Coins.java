package com.pathfindersdk.coins;

import java.util.ArrayList;
import java.util.List;

final public class Coins
{
  private Piece cp = new CopperPiece(0);
  private Piece sp = new SilverPiece(0);
  private Piece gp = new GoldPiece(0);
  private Piece pp = new PlatinumPiece(0);
  
  public Coins add(Piece piece)
  {
    convert(piece);
    
    return this;
  }
  
  private void convert(Piece piece)
  {
    int valueInSp = convertCpToSp(piece.getValue());
    int valueInGp = convertSpToGp(valueInSp);
    int valueInPp = convertGpToPp(valueInGp);
    pp.add(valueInPp);
  }
  
  private int convertCpToSp(int valueInCp)
  {
    int totalCp = cp.getNumber() + valueInCp;
    cp.setNumber(totalCp % 10);
    return totalCp / 10;
  }
  
  private int convertSpToGp(int valueInSp)
  {
    int totalSp = sp.getNumber() + valueInSp;
    sp.setNumber(totalSp % 10);
    return totalSp / 10;
  }
  
  private int convertGpToPp(int valueInGp)
  {
    int totalGp = gp.getNumber() + valueInGp;
    gp.setNumber(totalGp % 10);
    return totalGp / 10;
  }
  
  @Override
  public String toString()
  {
    List<String> list = new ArrayList<String>();
    
    if(pp.getNumber() > 0)
      list.add(pp.toString());
    if(gp.getNumber() > 0)
      list.add(gp.toString());
    if(sp.getNumber() > 0)
      list.add(sp.toString());
    if(cp.getNumber() > 0)
      list.add(cp.toString());
    
    if(list.isEmpty())
      return cp.toString();
    else
    {
      String out = list.get(0);
      
      for(int i = 1; i < list.size(); i++)
      {
        out += ", " + list.get(i);
      }
      
      return out;
    }
  }
}
