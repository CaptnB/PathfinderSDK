package com.pathfindersdk.tests.books;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class IndexTest
{
  private class BookItemStub extends BookItem
  {
    public BookItemStub(String name)
    {
      super(name, BookSectionType.ARTIFACTS);
    }
  }

  @Test (expected = IllegalArgumentException.class)
  public void testIndexItemNull()
  {
    Index.getInstance().indexItem(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testUnindexItemNull()
  {
    Index.getInstance().unindexItem(null);
  }
  
  @Test
  public void testUnindexItem()
  {
    BookItem item = new BookItemStub("item");
    Index.getInstance().indexItem(item);
    Index.getInstance().unindexItem(item);
    
    assertNull(Index.getInstance().getItem(item));
  }
  
  @Test
  public void testGetItemBookItem()
  {
    BookItem item = new BookItemStub("item");
    Index.getInstance().indexItem(item);
    
    assertSame(item, Index.getInstance().getItem(item));
  }
  
  @Test
  public void testGetItemBookBookSectionTypeString()
  {
    BookItem item = new BookItemStub("item");
    Index.getInstance().indexItem(item);
    
    assertSame(item, Index.getInstance().getItem(BookSectionType.ARTIFACTS, "item"));
  }

  @Test
  public void testToString()
  {
    // Depending on what tests have run, Index could contain anything at this point.
    assertNotNull(Index.getInstance().toString());
  }
}
