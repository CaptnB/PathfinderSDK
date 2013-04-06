package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a feat book entry.
 */
final public class FeatItem extends BookItem
{

  public FeatItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.FEATS).addItemWithoutIndexing(this);
  }

}
