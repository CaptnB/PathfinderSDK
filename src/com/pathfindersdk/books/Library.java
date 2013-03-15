package com.pathfindersdk.books;

import java.util.Hashtable;
import java.util.TreeSet;

import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.enums.BookSectionType;

public class Library
{
  private static Library instance = new Library();
  private Hashtable<String, Book> books;
  private Hashtable<String, RaceItem> races;
  
  private Library() {};
  
  public static Library getInstance()
  {
    return instance;
  }
  
  public void addBook(Book book)
  {
    if(book != null)
    {
      if(books == null)
        books = new Hashtable<String, Book>();
      
      books.put(book.getTitle(), book);
      
      BookSection raceSection = book.getSection(BookSectionType.RACES);
      if(raceSection != null)
      {
        TreeSet<BookItem> raceItems = raceSection.getItems();
        for(BookItem item : raceItems)
        {
          if(item instanceof RaceItem)
          {
            if(races == null)
              races = new Hashtable<String, RaceItem>();
            
            races.put(item.getName(), (RaceItem)item);
          }
        }
      }
    }
  }

}
