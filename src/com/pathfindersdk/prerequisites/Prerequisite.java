package com.pathfindersdk.prerequisites;

import com.pathfindersdk.creatures.Creature;

/**
 * This class is a generic prerequisite a character has to fill.
 */
public abstract class Prerequisite
{
  public abstract Boolean isFilled(Creature creature);
}
