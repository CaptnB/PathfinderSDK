package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a monster book entry.
 */
final public class MonsterItem extends BookItem
{

  public MonsterItem(String name)
  {
    super(name, BookSectionType.MONSTERS);
    // TODO Auto-generated constructor stub
  }

}
