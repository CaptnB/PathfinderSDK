package com.pathfindersdk.general;

import java.util.TreeSet;

/**
 * This class works with Stat to collect all bonuses related to one BonusType. 
 * Ex: Will saving throw (a Stat object) receives +2 Morale from Heroism spell and +1 Morale from Inspire Courage. 
 * Morale bonuses don't stack.
 * As for the circumstantial bonuses, they are kept appart so they are not included in the total stat score.
 */
public class StatBonus
{
  private TreeSet<Bonus> baseBonuses = new TreeSet<Bonus>();
  private TreeSet<Bonus> circumstantialBonuses = new TreeSet<Bonus>();

  public TreeSet<Bonus> getBaseBonuses()
  {
    return baseBonuses;
  }
  
  public TreeSet<Bonus> getCircumstantialBonuses()
  {
    return circumstantialBonuses;
  }
}
