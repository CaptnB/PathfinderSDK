package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class PrestigeClassItem extends BookItem
{

  public PrestigeClassItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.PRESTIGE_CLASSES).addItem(this);
  }

}
