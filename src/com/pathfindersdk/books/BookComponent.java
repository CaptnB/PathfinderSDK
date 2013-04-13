package com.pathfindersdk.books;

public abstract class BookComponent
{
  private static int level = 0;
  
  public abstract void index();
  
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
