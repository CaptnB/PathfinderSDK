package com.pathfindersdk.tests.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pathfindersdk.books.BookComponent;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.BookSection;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

public class BookSectionTest
{
  private class BookItemStub extends BookItem
  {
    public BookItemStub(String name)
    {
      super(name, BookSectionType.ARTIFACTS);
    }
  }

  @Test
  public void testIndex()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    BookItem item1 = new BookItemStub("item1"); 
    BookItem item2 = new BookItemStub("item2"); 
    BookItem item3 = new BookItemStub("item3"); 

    components.add(item1);
    components.add(item2);
    components.add(item3);

    BookSection section = new BookSection(BookSectionType.FEATS, components);
    section.index();

    // Item type is not related to section type
    assertSame(item2, Index.getInstance().getItem(BookSectionType.ARTIFACTS, "item2"));
  }

  @Test
  public void testUnindex()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    BookComponent comp1 = new BookItemStub("item1"); 
    BookComponent comp2 = new BookItemStub("item2"); 
    BookComponent comp3 = new BookItemStub("item3"); 

    components.add(comp1);
    components.add(comp2);
    components.add(comp3);

    BookSection section = new BookSection(BookSectionType.FEATS, components);
    section.index();
    section.unindex();

    assertNull(Index.getInstance().getItem(BookSectionType.FEATS, "item2"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBookSectionNull()
  {
    new BookSection(BookSectionType.FEATS, null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBookSectionListWithNull()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    components.add(new BookItemStub("item1"));
    components.add(null);
    components.add(new BookItemStub("item3"));
    
    new BookSection(BookSectionType.FEATS, components);
  }

  @Test
  public void testGetType()
  {
    BookSection section = new BookSection(BookSectionType.FEATS, new ArrayList<BookComponent>());
    assertEquals(BookSectionType.FEATS, section.getType());
  }

  @Test
  public void testIsEmpty()
  {
    BookSection section = new BookSection(BookSectionType.FEATS, new ArrayList<BookComponent>());
    assertTrue(section.isEmpty());
  }

  @Test
  public void testToString()
  {
    List<BookComponent> components = new ArrayList<BookComponent>();
    components.add(new BookItemStub("item1"));
    BookSection section = new BookSection(BookSectionType.FEATS, components);
    
    components = new ArrayList<BookComponent>();
    components.add(section);
    components.add(new BookItemStub("item2"));
    section = new BookSection(BookSectionType.CLASSES, components);

    assertEquals("Classes\n  Feats\n    item1\n  item2", section.toString());
  }

}
