package com.pathfindersdk.books;

import java.util.TreeSet;

public class BookSection extends BookContent
{
  protected BookSectionType type;
  protected TreeSet<BookItem> items;
  
  public BookSection(BookSectionType type)
  {
    super(type.toString());
    this.type = type;
  }
  
  public BookSectionType getType()
  {
    return type;
  }
  
  public void addItem(BookItem item)
  {
    if(item != null)
    {
      if(items == null)
        items = new TreeSet<BookItem>();
      
      items.add(item);
    }
  }
  
  public void removeItem(BookItem item)
  {
    if(items != null)
    {
      items.remove(item);
      
      if(items.isEmpty())
        items = null;
    }
  }
}
