package com.pathfindersdk.basics;

import java.util.ArrayList;

import com.pathfindersdk.bonus.Bonus;

public class RacialTrait
{
  protected String name;
  protected ArrayList<Bonus> bonuses;
  //protected ArrayList<SpellLikeAbility> spellLikeAbilities;
  
  public RacialTrait(String name)
  {
    this.name = name;
  }
  
  public void addBonus(Bonus bonus)
  {
    if(bonus != null)
    {
      if(bonuses == null)
        bonuses = new ArrayList<Bonus>();
      
      bonuses.add(bonus);
    }
  }
  
  @Override
  public String toString()
  {
    return name;
  }

}
