package com.pathfindersdk.books;

import java.util.Hashtable;


/**
 * This class wraps everything a book may contain. It also adds elements into indexes for easy retrieval, say from another book. 
 */
public class Book extends BookContent
{
  protected Hashtable<BookSectionType, BookSection> sections;
  
  public Book(String name)
  {
    super(name);
  }
    
  public void addSection(BookSection section)
  {
    if(section != null)
    {
      if(sections == null)
        sections = new Hashtable<BookSectionType, BookSection>();
      
      if(sections.get(section.getType()) == null)
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
  
  public BookSection getSection(BookSectionType type)
  {
    if(sections != null)
      return sections.get(type);
    else
      return null;
  }
}
