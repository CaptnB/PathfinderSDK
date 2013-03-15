package com.pathfindersdk.books;

import java.util.TreeSet;

import com.pathfindersdk.enums.BookSectionType;

public class BookSection extends BookItem
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
  
  public TreeSet<BookItem> getItems()
  {
    return items;
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
