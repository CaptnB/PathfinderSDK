package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap an alternated racial trait book entry.
 */
final public class AlternateRacialTraitItem extends BookItem
{

  public AlternateRacialTraitItem(String name)
  {
    super(name);
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.ALTERNATE_RACIAL_TRAITS).addItemWithoutIndexing(this);
  }

}
