package com.pathfindersdk.books;



public abstract class BookContent implements Comparable<BookContent>
{
  protected String name;
  protected Boolean allowed;
  
  public BookContent(String name)
  {
    this.name = name;
    this.allowed = true;
  }
  
  public Boolean isAllowed()
  {
    return allowed;
  }
  
  public void setAllowed(Boolean allowed)
  {
    this.allowed = allowed;
  }
  
  @Override
  public String toString()
  {
    return name;
  }
  
  @Override
  public int compareTo(BookContent component)
  {
    return toString().compareTo(component.toString());
  }
}
