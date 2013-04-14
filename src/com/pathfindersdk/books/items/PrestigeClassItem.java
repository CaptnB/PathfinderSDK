package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a prestige class book entry.
 */
final public class PrestigeClassItem extends BookItem
{

  public PrestigeClassItem(String name)
  {
    super(name, BookSectionType.PRESTIGE_CLASSES);
    // TODO Auto-generated constructor stub
  }

}
