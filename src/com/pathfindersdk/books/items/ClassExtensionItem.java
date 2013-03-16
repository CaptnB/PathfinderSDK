package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class ClassExtensionItem extends BookItem
{

  public ClassExtensionItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void index()
  {
    Index.getInstance().getIndex(BookSectionType.CLASS_EXTENSIONS).addItem(this);
  }

}
