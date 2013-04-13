package com.pathfindersdk.books.items;

import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.books.Index;
import com.pathfindersdk.enums.BookSectionType;

/**
 * Immutable class to wrap a class extension book entry. 
 * Unlike archetypes that swap features for other in a playable class, this class extends an existing feature.
 * Ex: Core Rulebook lists Rogue Talents for the Rogue class. In APG, new Rogue Talents are added.
 */
final public class ClassExtensionItem extends BookItem
{

  public ClassExtensionItem(String name)
  {
    super(name);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void index()
  {
    Index.getInstance().getIndex(BookSectionType.CLASS_EXTENSIONS).addItem(this);
  }

}
