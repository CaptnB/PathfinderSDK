package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.creatures.Character;

public class WeaponFamiliarity extends Feature<Character>
{
  protected SortedSet<WeaponProficiency> proficiencies;

  public WeaponFamiliarity(String name)
  {
    super("Weapon familiarity");
  }

  @Override
  public void applyTo(Character target)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Character target)
  {
    // TODO Auto-generated method stub
    
  }

}
