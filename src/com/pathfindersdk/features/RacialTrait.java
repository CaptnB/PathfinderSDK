package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;

/**
 * Essentially a limited Feature class that only targets Character (Monsters don't have a Race) and prevents having Prerequsites.
 */
public class RacialTrait extends Feature<Character>
{
   
  public RacialTrait(String name, SortedSet<Bonus> bonuses)
  {
    super(name, bonuses);
  }

}
