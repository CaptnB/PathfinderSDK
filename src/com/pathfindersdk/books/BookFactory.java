package com.pathfindersdk.books;

/**
 * A base factory for creating Book objects.
 */
public abstract class BookFactory
{
  
  /**
   * Creates a new Book object.
   *
   * @param bookName The book's title
   * @return the book
   */
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
  
  /**
   * Adds all races included in the book.
   *
   * @param book the book
   */
  protected abstract void addRaces(Book book);
  
  /**
   * Adds all the classes included in the book.
   *
   * @param book the book
   */
  protected abstract void addClasses(Book book);
  
  /**
   * Adds all the class extensions included in the book.
   *
   * @param book the book
   */
  protected abstract void addClassExtensions(Book book);
  
  /**
   * Adds all the archetypes included in the book.
   *
   * @param book the book
   */
  protected abstract void addArchetypes(Book book);
  
  /**
   * Adds all the prestige classes included in the book.
   *
   * @param book the book
   */
  protected abstract void addPrestigeClasses(Book book);
  
  /**
   * Adds all the feats included in the book.
   *
   * @param book the book
   */
  protected abstract void addFeats(Book book);
  
  /**
   * Adds all the equipment and magic items included in the book.
   *
   * @param book the book
   */
  protected abstract void addEquipment(Book book);
  
  /**
   * Adds all the actions included in the book.
   *
   * @param book the book
   */
  protected abstract void addActions(Book book);
  
  /**
   * Adds all the spells included in the book.
   *
   * @param book the book
   */
  protected abstract void addSpells(Book book);
  
  /**
   * Adds all the monsters included in the book.
   *
   * @param book the book
   */
  protected abstract void addMonsters(Book book);
}
