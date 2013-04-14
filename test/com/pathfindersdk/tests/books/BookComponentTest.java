package com.pathfindersdk.tests.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pathfindersdk.books.BookComponent;
import com.pathfindersdk.enums.BookSectionType;

public class BookComponentTest
{
  private class BookComponentStub extends BookComponent
  {
    private String name;
    
    protected BookComponentStub(String name, BookSectionType type)
    {
      super(type);
      this.name = name;
    }

    @Override
    public void index()
    {
      // Do nothing
    }

    @Override
    public void unindex()
    {
      // Do nothing
    }

    @Override
    public String getName()
    {
      return name;
    }

  }

  @Test
  public void testGetType()
  {
    BookComponent comp = new BookComponentStub("comp", BookSectionType.ARMORS);
    
    assertEquals(BookSectionType.ARMORS, comp.getType());
  }

  @Test
  public void testCompareToLowerType()
  {
    // Sorted by ordinal : CLASSES comes before ARMORS
    BookComponent comp1 = new BookComponentStub("comp", BookSectionType.CLASSES);
    BookComponent comp2 = new BookComponentStub("comp", BookSectionType.ARMORS);

    assertTrue(comp1.compareTo(comp2) < 0);
  }

  @Test
  public void testCompareToGreaterType()
  {
    // Sorted by ordinal : CLASSES comes before ARMORS
    BookComponent comp1 = new BookComponentStub("comp", BookSectionType.ARMORS);
    BookComponent comp2 = new BookComponentStub("comp", BookSectionType.CLASSES);

    assertTrue(comp1.compareTo(comp2) > 0);
  }


  @Test
  public void testCompareToLowerName()
  {
    BookComponent comp1 = new BookComponentStub("comp A", BookSectionType.ARMORS);
    BookComponent comp2 = new BookComponentStub("comp B", BookSectionType.ARMORS);

    assertTrue(comp1.compareTo(comp2) < 0);
  }

  @Test
  public void testCompareToEqualName()
  {
    BookComponent comp1 = new BookComponentStub("comp A", BookSectionType.ARMORS);
    BookComponent comp2 = new BookComponentStub("comp A", BookSectionType.ARMORS);

    assertEquals(0, comp1.compareTo(comp2));
  }

  @Test
  public void testCompareToGreaterName()
  {
    BookComponent comp1 = new BookComponentStub("comp B", BookSectionType.ARMORS);
    BookComponent comp2 = new BookComponentStub("comp A", BookSectionType.ARMORS);

    assertTrue(comp1.compareTo(comp2) > 0);
  }

}
