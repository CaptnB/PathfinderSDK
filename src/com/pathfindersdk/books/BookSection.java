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
  final private BookSectionType type;
  final private SortedSet<BookComponent> components;
  
  public BookSection(BookSectionType type, SortedSet<BookComponent> components)
  {
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(components);
    for(BookComponent component : components)
      ArgChecker.checkNotNull(component);

    this.type = type;
    this.components = components;
  }
  
  public BookSectionType getType()
  {
    return type;
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
  public int compareTo(BookSection section)
  {
    // Sort BookSection according to the BookSectionType enum ordinals
    return type.compareTo(section.getType());
  }
  
  @Override
  public String toString()
  {
    String out = getSpacing() + type.toString();
    
    increaseLevel();
    for(BookComponent component : components)
      out += component.toString();
    decreaseLevel();
    
    return out;
  }
}
