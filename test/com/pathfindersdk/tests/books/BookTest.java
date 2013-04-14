package com.pathfindersdk.tests.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookComponent;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class BookTest
{
  private class BookItemStub extends BookItem
  {
    public BookItemStub(String name)
    {
      super(name, BookSectionType.ARTIFACTS);
    }
  }

  @Test
  public void testBook()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    BookItem item = new BookItemStub("item");
    components.add(item);
    new Book("A book", components);   // Book constructor automatically index all contained components
    
    assertSame(item, Index.getInstance().getItem(BookSectionType.ARTIFACTS, "item"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBookNullSortedSet()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    new Book(null, components);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBookStringNull()
  {
    new Book("A book", null);
  }

  @Test
  public void testGetComponents()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    components.add(new BookItemStub("item1"));
    components.add(new BookItemStub("item2"));
    
    Book book = new Book("A book", components);
    
    components.add(new BookItemStub("item3"));
    
    assertEquals(2, book.getComponents().size());
  }

  @Test
  public void testToStringWithoutComponents()
  {
    Book book = new Book("A book", new ArrayList<BookComponent>());

    assertEquals("A book", book.toString());
  }

  @Test
  public void testToStringWithComponents()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    components.add(new BookItemStub("item1"));
    components.add(new BookItemStub("item2"));
    
    Book book = new Book("A book", components);

    assertEquals("A book\n-----\nitem1\nitem2", book.toString());
  }

}
