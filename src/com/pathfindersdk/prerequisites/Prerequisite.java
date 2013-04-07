package com.pathfindersdk.prerequisites;



/**
 * This class is a generic prerequisite a character has to fill.
 */
public interface Prerequisite<T>
{
  public abstract boolean isFilled(T target);
}
