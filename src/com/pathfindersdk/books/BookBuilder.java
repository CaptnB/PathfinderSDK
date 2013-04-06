package com.pathfindersdk.books;

import java.util.SortedMap;
import java.util.TreeMap;

import com.pathfindersdk.enums.BookSectionType;


/**
 * A base builder for creating Book objects.
 */
public abstract class BookBuilder
{
  
  public Book createBook(String title)
  {
    // Create book tree map of sections
    SortedMap<BookSectionType, BookSection> sections = new TreeMap<BookSectionType, BookSection>();
   
    // Fill each section
    addRaces(sections);
    addAlternateRacialTraits(sections);
    addClasses(sections);
    addClasses(sections);
    addClassExtensions(sections);
    addArchetypes(sections);
    addPrestigeClasses(sections);
    addSkills(sections);
    addFeats(sections);
    addEquipment(sections);
    addSpells(sections);
    addMonsters(sections);
    
    // Return newly assembled book
    return new Book(title, sections);
  }
  
  protected abstract void addRaces(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addAlternateRacialTraits(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addClasses(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addClassExtensions(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addArchetypes(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addPrestigeClasses(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addSkills(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addFeats(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addEquipment(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addSpells(SortedMap<BookSectionType, BookSection> sections);
  
  protected abstract void addMonsters(SortedMap<BookSectionType, BookSection> sections);
  
}
