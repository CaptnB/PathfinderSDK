package com.pathfindersdk.books.builders;

import com.pathfindersdk.books.Book;

/**
 * A base builder for creating Book objects.
 */
public abstract class BookBuilder
{
  
  public Book createBook(String title)
  {
    Book book = new Book(title);
    
    addRaces(book);
    addAlternateRacialTraits(book);
    addClasses(book);
    addClasses(book);
    addClassExtensions(book);
    addArchetypes(book);
    addPrestigeClasses(book);
    addSkills(book);
    //addSkillExpansions(book);
    addFeats(book);
    addEquipment(book);
    //addActions(book);
    addSpells(book);
    addMonsters(book);
    
    return book;
  }
  
  protected abstract void addRaces(Book book);
  
  protected abstract void addAlternateRacialTraits(Book book);
  
  protected abstract void addClasses(Book book);
  
  protected abstract void addClassExtensions(Book book);
  
  protected abstract void addArchetypes(Book book);
  
  protected abstract void addPrestigeClasses(Book book);
  
  protected abstract void addSkills(Book book);
  
  //protected abstract void addSkillExpansions(Book book);
  
  protected abstract void addFeats(Book book);
  
  protected abstract void addEquipment(Book book);
  
  //protected abstract void addActions(Book book);
  
  protected abstract void addSpells(Book book);
  
  protected abstract void addMonsters(Book book);
}
