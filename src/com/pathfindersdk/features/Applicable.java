package com.pathfindersdk.features;


/**
 * Interface to apply/remove stuff from something else
 */
public interface Applicable<T>
{
  public void applyTo(T target);
  public void removeFrom(T target);
}
