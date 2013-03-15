package com.pathfindersdk.books;

import java.util.Hashtable;

import com.pathfindersdk.enums.BookSectionType;


/**
 * This class wraps everything a book may contain. It also adds elements into indexes for easy retrieval, say from another book. 
 */
public class Book
{
  protected String title;
  protected Hashtable<BookSectionType, BookSection> sections;
  
  public Book(String title)
  {
    this.title = title;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public BookSection getSection(BookSectionType type)
  {
    if(sections != null)
      return sections.get(type);
    else
      return null;
  }

  public void addSection(BookSection section)
  {
    if(section != null)
    {
      if(sections == null)
        sections = new Hashtable<BookSectionType, BookSection>();
      
      sections.put(section.getType(), section);
    }    
  }
  
  public void removeSection(BookSection section)
  {
    if(section != null && sections != null)
    {
      sections.remove(section.getType());
      
      if(sections.isEmpty())
        sections = null;
    }
  }
}
