package com.pathfindersdk.books;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

/**
 * Base class for every item found in a book. Make sure every derived class is immutable (final class, final private members and no setters) 
 * as it prevents unintended modifications of the book content and simplifies affectations (no clone())
 */
public abstract class BookItem extends BookComponent
{
  final private String name;
  
  public BookItem(String name, BookSectionType type)
  {
    super(type);

    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);

    this.name = name;
  }
  
  @Override
  public void index()
  {
    Index.getInstance().indexItem(this);
  }
  
  @Override
  public void unindex()
  {
    Index.getInstance().unindexItem(this);
  }
  
  @Override
  public String getName()
  {
    return name;
  }
  
  @Override
  public String toString()
  {
    return getSpacing() + name;
  }

}
