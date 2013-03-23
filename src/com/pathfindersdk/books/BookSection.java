package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.BookSectionType;

public class BookSection
{
  protected BookSectionType type;
  protected SortedSet<BookItem> items;
  
  public BookSection(BookSectionType type)
  {
    this.type = type;
  }
  
  public BookSectionType getType()
  {
    return type;
  }
  
  public SortedSet<BookItem> getItems()
  {
    return Collections.unmodifiableSortedSet(items);
  }
  
  public void addItem(BookItem item)
  {
    if(item != null)
    {
      if(items == null)
        items = new TreeSet<BookItem>();
      
      // Add to section
      items.add(item);
      
      // Add to index
      Index.getInstance().getIndex(type).addItem(item);
    }
  }
}
