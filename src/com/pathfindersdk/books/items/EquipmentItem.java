package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class to wrap an equipment book entry.
 */
public class EquipmentItem extends BookItem
{
  private final Coins cost;

  public EquipmentItem(String name, Coins cost)
  {
    super(name, BookSectionType.EQUIPMENT);

    ArgChecker.checkNotNull(cost);
    
    this.cost = cost;
  }
  
  public Coins getCost()
  {
    return cost;
  }

}
