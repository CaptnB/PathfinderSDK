package com.pathfindersdk.books;

import java.util.Collections;
import java.util.SortedSet;

import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class that wraps everything a Pathfinder book may contain.
 */
final public class Book
{
  final private String title;
  final private SortedSet<BookComponent> components;

  public Book(String title, SortedSet<BookComponent> components)
  {
    ArgChecker.checkNotNull(title);
    ArgChecker.checkNotEmpty(title);
    ArgChecker.checkNotNull(components);
    for(BookComponent component : components)
      ArgChecker.checkNotNull(component);
    
    this.title = title;
    this.components = components;
    
    indexAll();
  }
  
  public void remove()
  {
    unindexAll();
  }
  
  public SortedSet<BookComponent> getComponents()
  {
    return Collections.unmodifiableSortedSet(components);
  }
  
  private void indexAll()
  {
    for(BookComponent component : components)
      component.index();
  }
  
  private void unindexAll()
  {
    for(BookComponent component : components)
      component.unindex();
  }
  
  @Override
  public String toString()
  {
    String out = title + "\n\n";
    
    for(BookComponent component : components)
      out += component.toString();
    
    return out;
  }
}
