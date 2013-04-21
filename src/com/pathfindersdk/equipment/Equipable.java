package com.pathfindersdk.equipment;

import com.pathfindersdk.creatures.Creature;

public interface Equipable
{
  public void equip(Creature target);
  public void unequip(Creature target);
}
