package com.pathfindersdk.basics;

import com.pathfindersdk.creatures.Character;

public interface Feature
{
  public void apply(Character character);
  public void remove(Character character);
}
