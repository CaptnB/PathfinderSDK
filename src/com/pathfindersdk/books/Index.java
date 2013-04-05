package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.BookSectionType;

public class Index
{
  private static Index instance = new Index();
  
  private SortedSet<BookSection> index = new TreeSet<BookSection>();  // Does not reference book sections directly, it gathers say all RaceItems
  
  // Library is a singleton
  private Index() {}

  public static Index getInstance()
  {
    return instance;
  }

  public SortedSet<BookSection> getFullIndex()
  {
    if(index != null)
      return Collections.unmodifiableSortedSet(index);
    else
      return null;
  }

  public void addIndex(BookSection section)
  {
    if(section != null)
    {
      // Check if an existing indexed section with the same type already exists
      BookSectionType type = section.getType();
      boolean alreadyIndexed = false;
      
      for(BookSection indexed : index)
      {
        if(indexed.getType().equals(type))
          alreadyIndexed = true;
      }
      
      if(!alreadyIndexed)
        index.add(new BookSection(section.getType()));
    }
  }
  
  public BookSection getIndex(BookSectionType type)
  {
    BookSection section = null;
    
    // Try to find an existing section
    for(BookSection indexed : index)
    {
      if(indexed.getType().equals(type))
        section = indexed;
    }
    
    // If section has not been found, create and add it to index
    if(section == null)
    {
      section = new BookSection(type);
      index.add(section);
    }
    
    return section;
  }

}
