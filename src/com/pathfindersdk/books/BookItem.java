package com.pathfindersdk.books;



public abstract class BookItem implements Comparable<BookItem>
{
  protected String name;
  
  public BookItem(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
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
