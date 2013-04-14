package com.pathfindersdk.books;

import java.util.SortedSet;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

/**
 * This class represents a book section (or chapter) that usually contains the same type of items.
 * Ex: A section with type BookSectionType.RACES will contains RaceItems
 */
final public class BookSection extends BookComponent implements Comparable<BookSection>
{
  final private SortedSet<BookComponent> components;
  
  public BookSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    super(type);
    
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(components);
    for(BookComponent component : components)
      ArgChecker.checkNotNull(component);

    this.components = components;
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
  public int compareTo(BookSection section)
  {
    // Sort BookSection according to the BookSectionType enum ordinals
    return getType().compareTo(section.getType());
  }
  
  @Override
  public String toString()
  {
    String out = getSpacing() + getType().toString();
    
    increaseLevel();
    for(BookComponent component : components)
      out += component.toString();
    decreaseLevel();
    
    return out;
  }
}
