package com.pathfindersdk.general;

import com.pathfindersdk.creatures.characters.Character;

/**
 * The Class Prerequisite.
 */
public abstract class Prerequisite
{
  
  /**
   * Checks if prerequisite is filled.
   *
   * @param character Character needing to fill the prerequisite
   * @return the boolean
   */
  public abstract Boolean check(Character character);
}
