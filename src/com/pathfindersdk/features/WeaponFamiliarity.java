package com.pathfindersdk.features;

import java.util.SortedSet;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.NullPrerequisite;

public class WeaponFamiliarity extends Feature<Character>
{
  protected SortedSet<WeaponProficiency> proficiencies;

  public WeaponFamiliarity(String name, Applicable<Creature> ... applicables)
  {
    super(name, new NullPrerequisite<Creature>(), applicables);
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
