package com.pathfindersdk.creatures;

/**
 * The Enum Vision.
 */
public enum Vision
{
  
  /** Normal vision. */
  NORMAL ("Normal"),
  
  /** Low-Light vision. */
  LOW_LIGHT ("Low-Light"),
  
  /** Darkvision. */
  DARKVISION ("Darkvision");
  
  /** Vision name. */
  private final String name;
  
  /**
   * Instantiates a new vision.
   *
   * @param name vision name
   */
  private Vision(String name)
  {
    this.name = name;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override public String toString()
  {
    return name;
  }
}
