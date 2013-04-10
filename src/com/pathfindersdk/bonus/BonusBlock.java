package com.pathfindersdk.bonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.BonusTypeRegister.BonusType;
import com.pathfindersdk.utils.ArgChecker;

final public class BonusBlock
{
  private class BonusGroup
  {
    final private SortedSet<Bonus> baseBonuses = new TreeSet<Bonus>();      // Bonus are sorted in descending order, first bonus is biggest
    final private Set<Bonus> circumstantialBonuses = new HashSet<Bonus>();  // No need to sort those
    
    public SortedSet<Bonus> getBaseBonuses()
    {
      return Collections.unmodifiableSortedSet(baseBonuses);
    }
    
    public Set<Bonus> getCircumstantialBonuses()
    {
      return Collections.unmodifiableSet(circumstantialBonuses);
    }
    
    public void addBonus(Bonus bonus)
    {
      if(bonus.isCircumstantial())
        circumstantialBonuses.add(bonus);
      else
        baseBonuses.add(bonus);
    }
    
    public void removeBonus(Bonus bonus)
    {
      if(bonus.isCircumstantial())
        circumstantialBonuses.remove(bonus);
      else
        baseBonuses.remove(bonus);
    }
  }
  
  final private Map<BonusType, BonusGroup> bonusGroups = new HashMap<BonusType, BonusGroup>();
  
  public void addBonus(Bonus bonus)
  {
    ArgChecker.checkNotNull(bonus);

    // Add bonus to proper group
    BonusGroup group = bonusGroups.get(bonus.getType());
    
    // If group does not exist, just add it
    if(group == null)
    {
      group = new BonusGroup();
      bonusGroups.put(bonus.getType(), group);
    }
    group.addBonus(bonus);
  }
  
  public void removeBonus(Bonus bonus)
  {
    ArgChecker.checkNotNull(bonus);
    
    // Remove from proper group
    BonusGroup group = bonusGroups.get(bonus.getType());
    if(group != null)
    {
      group.removeBonus(bonus);
      
      // If group becomes empty, just remove it
      if(group.getBaseBonuses().isEmpty() && group.getCircumstantialBonuses().isEmpty())
        bonusGroups.remove(bonus.getType());
    }
  }
  
  public List<Bonus> getApplicableBaseBonus()
  {
    List<Bonus> bonusList = new ArrayList<Bonus>();   // No need to keep them sorted here, we just want the important ones
    
    Set<BonusType> types = bonusGroups.keySet();
    for(BonusType type : types)
    {
      BonusGroup group = bonusGroups.get(type);
      
      // Untyped bonus stack
      if(type.equals(BonusTypeRegister.getInstance().get("Untyped")))
        bonusList.addAll(group.getBaseBonuses());
      
      // Typed bonus only apply biggest (if any)
      else if(!group.getBaseBonuses().isEmpty())
        bonusList.add(group.getBaseBonuses().first());
    }
    
    return Collections.unmodifiableList(bonusList);
  }
  
  public List<Bonus> getApplicableCircumstantialBonus()
  {
    List<Bonus> bonusList = new ArrayList<Bonus>();
    
    Set<BonusType> types = bonusGroups.keySet();
    for(BonusType type : types)
    {
      BonusGroup group = bonusGroups.get(type);
      
      // Untyped bonus stack
      if(type.equals(BonusTypeRegister.getInstance().get("Untyped")))
        bonusList.addAll(group.getCircumstantialBonuses());

      // Typed bonus don't stack but since they are circumstantial, we don't know which to apply or not
      else
      {
        // Still, if a base bonus exists, all circumstantial bonus of the same type that are smaller won't ever apply
        if(!group.getBaseBonuses().isEmpty())
        {
          Bonus baseBonus = group.getBaseBonuses().first();
          for(Bonus circBonus : group.getCircumstantialBonuses())
          {
            // If circumstantial bonus is bigger than base bonus, return the difference
            if(circBonus.getValue() > baseBonus.getValue())
            {
              bonusList.add(circBonus.newBonus(baseBonus.getValue()));
            }
          }
        }
        else
          bonusList.addAll(group.getCircumstantialBonuses());
      }
    }
    
    return Collections.unmodifiableList(bonusList);
  }
}
