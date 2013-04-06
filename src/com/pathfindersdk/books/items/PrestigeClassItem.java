package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a prestige class book entry.
 */
final public class PrestigeClassItem extends BookItem
{

  public PrestigeClassItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.PRESTIGE_CLASSES).addItemWithoutIndexing(this);
  }

}
