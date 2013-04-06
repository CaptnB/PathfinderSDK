package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap an equipment book entry.
 */
final public class EquipmentItem extends BookItem
{

  public EquipmentItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.EQUIPMENT).addItemWithoutIndexing(this);
  }

}
