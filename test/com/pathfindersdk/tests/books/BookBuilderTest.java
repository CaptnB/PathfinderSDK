package com.pathfindersdk.tests.books;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookBuilder;
import com.pathfindersdk.books.BookComponent;
import com.pathfindersdk.books.BookSection;
import com.pathfindersdk.books.items.EquipmentItem;
import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.enums.BookSectionType;

public class BookBuilderTest
{
  private class BookBuilderEmptyStub extends BookBuilder
  {
    // No "create" methods overriden so it creates an empty book
  }
  
  private class BookBuilderSimpleStub extends BookBuilder
  {
    @Override
    protected void addNewBonusTypes(List<String> newTypes)
    {
      newTypes.add("A");
      newTypes.add("B");
    }
    
    @Override
    protected BookSection createRacesSection(BookSectionType type,
        List<BookComponent> components)
    {
      return null;
    }
    
    @Override
    protected BookSection createClassesSection(BookSectionType type,
        List<BookComponent> components)
    {
      // Empty
      return super.createClassesSection(type, components);
    }
    
    @Override
    protected BookSection createEquipmentSection(BookSectionType type,
        List<BookComponent> components)
    {
      components.add(new EquipmentItem("item", new Coins()));
      return super.createEquipmentSection(type, components);
    }

  }

  @Test
  public void testCreateBookEmpty()
  {
    BookBuilder builder = new BookBuilderEmptyStub();
    Book book = builder.createBook("Empty book");
    
    assertEquals("Empty book", book.toString());
  }
  
  @Test
  public void testCreateBookSimple()
  {
    BookBuilder builder = new BookBuilderSimpleStub();
    Book book = builder.createBook("Simple book");
    
    assertEquals("Simple book\n-----\nEquipment\n  Equipment\n    item", book.toString());
    
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreateBookNullTitle()
  {
    BookBuilder builder = new BookBuilderEmptyStub();
    builder.createBook(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCreateBookEmptyTitle()
  {
    BookBuilder builder = new BookBuilderEmptyStub();
    builder.createBook("");
  }

}
