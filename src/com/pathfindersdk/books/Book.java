package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import com.pathfindersdk.enums.BookSectionType;

public class Book
{
  protected String title;
  protected SortedMap<BookSectionType, BookSection> sections;

  public Book(String title)
  {
    this.title = title;
  }
  
  public SortedMap<BookSectionType, BookSection> getSections()
  {
    if(sections != null)
      return Collections.unmodifiableSortedMap(sections);
    else
      return null;
  }
  
  public void addSection(BookSection section)
  {
    if(section != null)
    {
      if(sections == null)
        sections = new TreeMap<BookSectionType, BookSection>();
      
      sections.put(section.getType(), section);
    }
  }
}
