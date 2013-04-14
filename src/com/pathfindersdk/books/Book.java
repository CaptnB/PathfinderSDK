package com.pathfindersdk.books;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.utils.ArgChecker;

/**
 * Immutable class that wraps everything a Pathfinder book may contain.
 */
final public class Book
{
  final private String title;
  final private SortedSet<BookComponent> components;

  public Book(String title, List<BookComponent> components)
  {
    ArgChecker.checkNotNull(title);
    ArgChecker.checkNotEmpty(title);
    ArgChecker.checkNotNull(components);
    for(BookComponent component : components)
      ArgChecker.checkNotNull(component);
    
    this.title = title;
    this.components = new TreeSet<BookComponent>(components);
    
    // Update Index with new content
    for(BookComponent component : components)
      component.index();
  }
  
  public SortedSet<BookComponent> getComponents()
  {
    return Collections.unmodifiableSortedSet(components);
  }
  
  @Override
  public String toString()
  {
    String out = title;
    
    if(!components.isEmpty())
      out += "\n-----";
    
    for(BookComponent component : components)
      out += "\n" + component.toString();
    
    return out;
  }
}
