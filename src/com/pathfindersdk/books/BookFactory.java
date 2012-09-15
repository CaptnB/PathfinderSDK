package com.pathfindersdk.books;

public abstract class BookFactory
{
  public Book createBook(String bookName)
  {
    Book book = new Book(bookName);
    
    addRaces(book);
    addClasses(book);
    addClasses(book);
    addClassExtensions(book);
    addArchetypes(book);
    addPrestigeClasses(book);
    addFeats(book);
    addEquipment(book);
    addActions(book);
    addSpells(book);
    addMonsters(book);
    
    return book;
  }
  
  protected abstract void addRaces(Book book);
  protected abstract void addClasses(Book book);
  protected abstract void addClassExtensions(Book book);
  protected abstract void addArchetypes(Book book);
  protected abstract void addPrestigeClasses(Book book);
  protected abstract void addFeats(Book book);
  protected abstract void addEquipment(Book book);
  protected abstract void addActions(Book book);
  protected abstract void addSpells(Book book);
  protected abstract void addMonsters(Book book);
}
