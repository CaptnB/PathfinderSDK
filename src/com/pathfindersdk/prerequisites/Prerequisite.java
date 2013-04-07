package com.pathfindersdk.prerequisites;


/**
 * This interface allows checking of prerequisite on a generic target.
 */
public interface Prerequisite<T>
{
  public boolean isFilled(T target);
}
