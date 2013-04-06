package com.pathfindersdktests.books;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.pathfindersdk.books.BookItem;

public class BookItemTest
{
  private static class BasisBookItem extends BookItem
  {

    public BasisBookItem(String name)
    {
      super(name);
      // TODO Auto-generated constructor stub
    }
    
    @Override
    public void index()
    {
      // Do nothing
    }

    
  }

  @Test
  public void testBookItem()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testGetName()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testToString()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testCompareTo()
  {
    fail("Not yet implemented");
  }

}
