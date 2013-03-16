package com.pathfindersdk.books;



public abstract class BookItem implements Comparable<BookItem>
{
  protected String name;
  
  public BookItem(String name)
  {
    this.name = name;
    index();
  }
  
  public String getName()
  {
    return name;
  }
  
  protected abstract void index();
  
  @Override
  public String toString()
  {
    return name;
  }
  
  @Override
  public int compareTo(BookItem component)
  {
    return toString().compareTo(component.toString());
  }
}
