package com.pathfindersdk.books;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class represents a book section (or chapter) that usually contains the same type of items.
 * Ex: A section with type BookSectionType.RACES will contains RaceItems
 */
final public class BookSection extends BookComponent
{
  final private SortedSet<BookComponent> components;
  
  public BookSection(BookSectionType type, List<BookComponent> components)
  {
    super(type);
    
    ArgChecker.checkNotNull(components);
    for(BookComponent comp : components)
      ArgChecker.checkNotNull(comp);

    this.components = new TreeSet<BookComponent>(components);
  }
  
  public boolean isEmpty()
  {
    return components.isEmpty();
  }
  
  @Override
  public void index()
  {
    for(BookComponent component : components)
      component.index();
  }

  
  @Override
  public void unindex()
  {
    for(BookComponent component : components)
      component.unindex();
    
  }
  
  @Override
  public String getName()
  {
    return getType().toString();
  }

  @Override
  public String toString()
  {
    String out = getSpacing() + getName();
    
    increaseLevel();
    for(BookComponent component : components)
      out += "\n" + component.toString();
    decreaseLevel();
    
    return out;
  }
}
