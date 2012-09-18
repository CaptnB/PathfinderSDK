package com.pathfindersdk.creatures.characters;

import com.pathfindersdk.creatures.Alignment;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.creatures.Size;

/**
 * The Class Chraracter.
 */
public class Chraracter extends Creature
{
  private Race race;

  public Chraracter(String name, Alignment alignment, Race race)
  {
    super(name, alignment);
    this.race = race;
  }

  @Override
  public Size getSize()
  {
    return race.getSize();
  }

}
