package com.pathfindersdk.books;

import com.pathfindersdk.creatures.Creature;

public abstract class BookItem extends BookContent
{

  public BookItem(String name)
  {
    super(name);
  }

  public abstract void applyTo(Creature creature);
  
  public abstract void removeFrom(Creature creature);
}
