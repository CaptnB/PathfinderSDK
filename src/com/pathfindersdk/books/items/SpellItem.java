package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a spell book entry.
 */
final public class SpellItem extends BookItem
{

  public SpellItem(String name)
  {
    super(name, BookSectionType.SPELLS);
    // TODO Auto-generated constructor stub
  }

}
