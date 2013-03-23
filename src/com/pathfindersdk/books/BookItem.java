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

  // Make sure to use covariant return type when overriding
  public abstract BookItem deepCopy();
  
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
