package com.pathfindersdk.books;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.utils.ArgChecker;

final public class Index
{
  public class IndexSection
  {
    private Map<String, BookItem> itemMap = new HashMap<String, BookItem>();
    
    public void addItem(BookItem item)
    {
      ArgChecker.checkNotNull(item);
      
      itemMap.put(item.toString(), item);
    }

    public BookItem getItem(String name)
    {
      ArgChecker.checkNotNull(name);
      
      return itemMap.get(name);
    }
    
    @Override
    public String toString()
    {
      String out = "";
      
      Set<String> items = itemMap.keySet();
      for(String item : items)
        out += "  " + item;
      
      return out;
    }
  }
  
  // Singleton
  private static Index instance = new Index();
  private Map<BookSectionType, IndexSection> index = new HashMap<BookSectionType, IndexSection>();
    
  private Index() {}

  public static Index getInstance()
  {
    return instance;
  }
  
  public IndexSection getIndex(BookSectionType type)
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

  @Override
  public String toString()
  {
    String out = "Index\n-----\n";
    
    Set<BookSectionType> keys = index.keySet();
    for(BookSectionType key: keys)
    {
      out += key.toString();
      out += index.get(key).toString();
    }
    
    return out;
  }
}
