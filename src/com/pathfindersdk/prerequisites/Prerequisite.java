package com.pathfindersdk.prerequisites;


/**
 * This class is a generic prerequisite a character has to fill.
 */
public abstract class Prerequisite<T>
{
  public abstract boolean isFilled(T target);
}
