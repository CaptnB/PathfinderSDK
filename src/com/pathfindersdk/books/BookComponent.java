package com.pathfindersdk.books;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

public abstract class BookComponent
{
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
  
  private static int level = 0;
  
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

}
