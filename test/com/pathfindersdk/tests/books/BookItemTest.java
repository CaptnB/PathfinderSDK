package com.pathfindersdk.tests.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class BookItemTest
{
  private class BookItemStub extends BookItem
  {

    public BookItemStub(String name)
    {
      super(name, BookSectionType.ARTIFACTS);
    }
    
    @Override
    public String toString()
    {
      increaseLevel();
      String out = super.toString();
      decreaseLevel();
      
      return out;
    }

  }

  @Test (expected = IllegalArgumentException.class)
  public void testBookItem()
  {
    new BookItemStub(null);
  }
  
  @Test
  public void testGetName()
  {
    BookItem item = new BookItemStub("Book item");
    assertEquals("Book item", item.getName());
  }

  @Test
  public void testToString()
  {
    BookItem item = new BookItemStub("Book item");
    assertEquals("  Book item", item.toString());
  }
  
  @Test
  public void testIndex()
  {
    BookItem item1 = new BookItemStub("Item");
    item1.index();
    
    BookItem item2 = Index.getInstance().getItem(BookSectionType.ARTIFACTS, "Item");
    
    assertSame(item1, item2);
  }
  
  @Test
  public void testUnindex()
  {
    BookItem item1 = new BookItemStub("Item");
    item1.index();
    item1.unindex();
    
    BookItem item2 = Index.getInstance().getItem(BookSectionType.ARTIFACTS, "Item");
    
    assertNull(item2);
  }

}
