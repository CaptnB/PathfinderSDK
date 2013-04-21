package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.NullPrerequisite;

public class WeaponFamiliarity extends Feature
{
  protected SortedSet<WeaponProficiency> proficiencies;

  public WeaponFamiliarity(String name, Applicable ... applicables)
  {
    super(name, new NullPrerequisite(), applicables);
    // TODO Auto-generated constructor stub
  }

  

//  public WeaponFamiliarity()
//  {
//    super("Weapon familiarity");
//  }

  @Override
  public void applyTo(Creature target)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeFrom(Creature target)
  {
    // TODO Auto-generated method stub
    
  }

}
