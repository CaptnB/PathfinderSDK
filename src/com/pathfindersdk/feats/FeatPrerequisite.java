package com.pathfindersdk.feats;

/**
 * The Interface FeatPrerequisite. Feats can have many types of requirements (skill ranks, other feats, etc.). 
 * This interface allows all possible prerequisite to share a common way to check them.
 */
public interface FeatPrerequisite
{
  
  /**
   * Checks if prerequisite is filled.
   *
   * @param character Character taking the feat
   * @return the boolean
   */
  public abstract Boolean isFilled(Character character);
}
