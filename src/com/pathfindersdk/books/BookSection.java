package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.BookSectionType;

/**
 * This class represents a book section (or chapter) that usually contains the same type of items.
 * Ex: A section with type BookSectionType.RACES will contains RaceItems
 */
public class BookSection implements Comparable<BookSection>
{
  protected BookSectionType type;
  protected SortedSet<BookItem> items;
  
  public BookSection(BookSectionType type)
  {
    if(type == null)
      throw new IllegalArgumentException("type can't ne null!");
    this.type = type;
  }
  
  public BookSectionType getType()
  {
    return type;
  }
  
  public SortedSet<BookItem> getItems()
  {
    if(items != null)
      return Collections.unmodifiableSortedSet(items);
    else
      return null;
  }
  
  // Add item to section and also places it into main index corresponding section
  public void addItem(BookItem item)
  {
    if(item == null)
      throw new IllegalArgumentException("item can't be null!");

    if(items == null)
      items = new TreeSet<BookItem>();
    
    // Add to this section
    items.add(item);
    
    // Add to index
    item.index();
  }

  // 
  public void addItemWithoutIndexing(BookItem item)
  {
    if(item != null)
    {
      if(items == null)
        items = new TreeSet<BookItem>();
      
      // Add to section
      items.add(item);
    }
  }

  @Override
  public int compareTo(BookSection section)
  {
    // Sort BookSection according to the BookSectionType enum
    return type.compareTo(section.getType());
  }
  
  @Override
  public String toString()
  {
    String out = type.toString();
    for(BookItem item : items)
      out += "\n  " + item.toString();
    
    return out;
  }
}
