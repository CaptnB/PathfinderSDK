package com.pathfindersdk.books;

import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

final public class Index
{
  // Singleton
  private static Index instance = new Index();
  private SortedMap<BookSectionType, BookSection> index = new TreeMap<BookSectionType, BookSection>();
    
  private Index() {}

  public static Index getInstance()
  {
    return instance;
  }

  public SortedMap<BookSectionType, BookSection> getFullIndex()
  {
    return Collections.unmodifiableSortedMap(index);
  }
  
  public BookSection getIndex(BookSectionType type)
  {
    ArgChecker.checkNotNull(type);
      
    // Get existing section
    BookSection section = index.get(type);

    // If section has not been found, create and add it to index
    if(section == null)
    {
      section = new BookSection(type);
      index.put(type, section);
    }
    
    return section;
  }

  @Override
  public String toString()
  {
    String out = "Index\n-----\n";
    
    Set<BookSectionType> keys = index.keySet();
    for(BookSectionType key: keys)
      out += index.get(key).toString();
    
    return out;
  }
}
