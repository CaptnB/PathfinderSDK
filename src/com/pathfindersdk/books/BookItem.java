package com.pathfindersdk.books;

import com.pathfindersdk.utils.ArgChecker;

/**
 * Base class for every item found in a book. Make sure every derived class is immutable (final class, final private members and no setters) 
 * as it prevents unintended modifications of the book content and simplifies affectations (no clone())
 */
public abstract class BookItem implements Comparable<BookItem>
{
  final private String name;
  
  public BookItem(String name)
  {
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);

    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public abstract void index();
  
  @Override
  public String toString()
  {
    return name;
  }
  
  @Override
  public int compareTo(BookItem item)
  {
    return toString().compareTo(item.toString());
  }
}
