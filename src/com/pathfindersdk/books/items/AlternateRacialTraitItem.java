package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class AlternateRacialTraitItem extends BookItem
{

  public AlternateRacialTraitItem(String name)
  {
    super(name);
  }

  @Override
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.ALTERNATE_RACIAL_TRAITS).addItem(this);
  }

}