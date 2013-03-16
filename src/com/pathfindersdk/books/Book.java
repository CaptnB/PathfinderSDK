package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Book extends BookItem
{
  protected SortedSet<BookItem> items;

  public Book(String name)
  {
    super(name);
  }
  
  public SortedSet<BookItem> getitems()
  {
    return Collections.unmodifiableSortedSet(items);
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

  @Override
  protected void index()
  {
    Index.getInstance().addBook(this);
  }

}
