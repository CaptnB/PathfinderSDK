package com.pathfindersdk.books.items;

// Features can apply to both characters and monsters (ex: Feats) so T = Creature. Or just apply to characters (ex: Race), T = Character.
public interface Feature<T>
{
  public void applyTo(T target);
  public void removeFrom(T target);
}
