package com.pathfindersdk.coins;

import java.util.ArrayList;
import java.util.List;

import com.pathfindersdk.utils.ArgChecker;

/**
 * While Piece objects represent metal pieces, this class represents the currency system (think paper bills and metal coins vs. dollars and cents).
 * Coins use the lowest value (CopperPiece) as a common base. Everything is converted in cp value before being added or substracted and pieces are automatically normalized.
 * Ex: [103 gp + 17 cp] converts into [10317 cp] which normalizes to [10 pp, 3 gp, 1 sp, 7 cp]
 */
final public class Coins
{
  private Piece cp;
  private Piece sp;
  private Piece gp;
  private Piece pp;
  
  public Coins()
  {
    cp = new CopperPiece(0);
    sp = new SilverPiece(0);
    gp = new GoldPiece(0);
    pp = new PlatinumPiece(0);
  }
  
  public Coins(int cpValue)
  {
    this();
    
    normalize(cpValue);
  }
  
  public Coins(Piece...pieces)
  {
    this();
    
    // No need to add each piece individually, add the total value
    int totalValue = 0;
    for(Piece piece : pieces)
    {
      ArgChecker.checkNotNull(piece);
      totalValue += piece.getValue();
    }
    
    normalize(totalValue);
  }
  
  final public Coins add(Piece piece)
  {
    normalize(getValue() + piece.getValue());
    
    return this;
  }
  
  final public Coins add(Coins coins)
  {
    normalize(getValue() + coins.getValue());
    
    return this;
  }
  
  // Always send the value in cp (ie. the smallest piece value)
  private void normalize(int value)
  {
    cp.setNumber(value % 10); // Get the cp leftovers
    value /= 10;              // Convert into sp
    
    sp.setNumber(value % 10); // Get the sp leftovers
    value /= 10;              // Convert into gp
    
    gp.setNumber(value % 10); // Get the gp leftovers
    value /= 10;              // Convert into pp
    
    pp.setNumber(value);      // No more higher piece value
  }
  
  private int getValue()
  {
    return cp.getValue() + sp.getValue() + gp.getValue() + pp.getValue();
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
