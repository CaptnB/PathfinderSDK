package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a feat book entry.
 */
final public class FeatItem extends BookItem
{

  public FeatItem(String name)
  {
    super(name, BookSectionType.FEATS);
    // TODO Auto-generated constructor stub
  }

}
