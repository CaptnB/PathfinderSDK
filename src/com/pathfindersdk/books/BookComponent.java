package com.pathfindersdk.books;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

public abstract class BookComponent implements Comparable<BookComponent>
{
  private static int level = 0;
  private final BookSectionType type;
  
  protected BookComponent(BookSectionType type)
  {
    ArgChecker.checkNotNull(type);
    
    this.type = type;
  }
  
  public BookSectionType getType()
  {
    return type;
  }
  
  public abstract String getName();
  
  public abstract void index();
  
  public abstract void unindex();
  
  final protected void increaseLevel()
  {
    level += 1;
  }
  
  final protected void decreaseLevel()
  {
    level -= 1;
  }
  
  final protected String getSpacing()
  {
    String out = "";
    
    for(int i = 0; i < level; i++)
      out += "  ";
    
    return out;
  }

  @Override
  public int compareTo(BookComponent o)
  {
    // First sort by type
    if(!getType().equals(o.getType()))
      return getType().compareTo(o.getType());
    
    // Then by name
    else
      return getName().compareTo(o.getName());
  }
}
