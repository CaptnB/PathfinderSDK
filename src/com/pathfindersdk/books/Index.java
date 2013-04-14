package com.pathfindersdk.books;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

final public class Index
{
  private class IndexSection
  {
    private SortedMap<String, BookItem> itemMap = new TreeMap<String, BookItem>();
    
    private void addItem(BookItem item)
    {
      ArgChecker.checkNotNull(item);
      
      itemMap.put(item.getName(), item);
    }
    
    private void removeItem(BookItem item)
    {
      ArgChecker.checkNotNull(item);
      
      itemMap.remove(item.getName());
    }

    private BookItem getItem(String name)
    {
      ArgChecker.checkNotNull(name);
      
      return itemMap.get(name);
    }
    
    private boolean isEmpty()
    {
      return itemMap.isEmpty();
    }
    
    @Override
    public String toString()
    {
      String out = "";
      
      Set<String> items = itemMap.keySet();
      for(String item : items)
        out += "\n  " + item;
      
      return out;
    }
  }
  
  // Singleton
  private static Index instance = new Index();
  private SortedMap<BookSectionType, IndexSection> index = new TreeMap<BookSectionType, IndexSection>();
    
  private Index() {}

  public static Index getInstance()
  {
    return instance;
  }
  
  private IndexSection getIndexSection(BookSectionType type)
  {
    ArgChecker.checkNotNull(type);
      
    // Get existing section
    IndexSection section = index.get(type);

    // If section has not been found, create and add it to index
    if(section == null)
    {
      section = new IndexSection();
      index.put(type, section);
    }
    
    return section;
  }
  
  public void indexItem(BookItem item)
  {
    ArgChecker.checkNotNull(item);
    
    getIndexSection(item.getType()).addItem(item);
  }
  
  public void unindexItem(BookItem item)
  {
    ArgChecker.checkNotNull(item);
    
    IndexSection section = getIndexSection(item.getType());
    section.removeItem(item);
    if(section.isEmpty())
      index.remove(item.getType());
  }
  
  public BookItem getItem(BookSectionType type, String name)
  {
    ArgChecker.checkNotNull(type);
    ArgChecker.checkNotNull(name);
    ArgChecker.checkNotEmpty(name);
    
    return getIndexSection(type).getItem(name);
    
  }
  
  public BookItem getItem(BookItem item)
  {
    ArgChecker.checkNotNull(item);
    
    return getItem(item.getType(), item.toString());
  }

  @Override
  public String toString()
  {
    String out = "Index\n-----";
    
    Set<BookSectionType> keys = index.keySet();
    for(BookSectionType key: keys)
      out += "\n" + key.toString() + index.get(key).toString();
    
    return out;
  }
}
