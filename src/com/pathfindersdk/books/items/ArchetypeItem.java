package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap an archetype book entry.
 */
final public class ArchetypeItem extends BookItem
{

  public ArchetypeItem(String name)
  {
    super(name, BookSectionType.ARCHETYPES);
    // TODO Auto-generated constructor stub
  }

}
