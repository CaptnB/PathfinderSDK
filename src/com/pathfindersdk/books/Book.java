package com.pathfindersdk.books;

import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;

import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class that wraps everything a Pathfinder book may contain.
 */
final public class Book
{
  final private String title;
  final private SortedMap<BookSectionType, BookSection> sections;

  public Book(String title, SortedMap<BookSectionType, BookSection> sections)
  {
    if(title == null)
      throw new IllegalArgumentException("title can't be null!");
    
    if(sections == null)
      throw new IllegalArgumentException("sections can't be null");
    
    this.title = title;
    this.sections = sections;
  }
  
  public SortedMap<BookSectionType, BookSection> getSections()
  {
    return Collections.unmodifiableSortedMap(sections);
  }
  
  @Override
  public String toString()
  {
    String out = title + "\n\n";
    
    Set<BookSectionType> keys = sections.keySet();
    for(BookSectionType key : keys)
      out += sections.get(key).toString();
    
    return out;
  }
}
