package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.prerequisites.Prerequisite;

public class WeaponFamiliarity extends Feature<Character>
{
  protected SortedSet<WeaponProficiency> proficiencies;

  public WeaponFamiliarity(String name,
      SortedSet<Prerequisite<Character>> prerequisites, SortedSet<Bonus> bonuses)
  {
    super(name, prerequisites, bonuses);
    // TODO Auto-generated constructor stub
  }

  

//  public WeaponFamiliarity()
//  {
//    super("Weapon familiarity");
//  }

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
