package com.pathfindersdk.creatures;

import com.pathfindersdk.basics.Alignment;
import com.pathfindersdk.basics.SaveType;
import com.pathfindersdk.stats.AbilityStat;
import com.pathfindersdk.stats.AbilityType;
import com.pathfindersdk.stats.SaveStat;
import com.pathfindersdk.stats.Stat;
import com.pathfindersdk.stats.StatGroup;


/**
 * This base class contains stats common to every creatures (PCs, NPCs and Monsters).
 */
public abstract class Creature extends StatGroup
{
  protected String name;
  protected Alignment alignment;

  public Creature(String name)
  {
    this.name = name;

    // Ability scores
    StatGroup abilities = new StatGroup();
    addComponent("Ability Scores", abilities);
    AbilityStat str = new AbilityStat(AbilityType.STR);
    abilities.addComponent(AbilityType.STR.toString(), str);
    AbilityStat dex = new AbilityStat(AbilityType.DEX);
    abilities.addComponent(AbilityType.DEX.toString(), dex);
    AbilityStat con = new AbilityStat(AbilityType.CON);
    abilities.addComponent(AbilityType.CON.toString(), con);
    AbilityStat inte = new AbilityStat(AbilityType.INT);
    abilities.addComponent(AbilityType.INT.toString(), inte);
    AbilityStat wis = new AbilityStat(AbilityType.WIS);
    abilities.addComponent(AbilityType.WIS.toString(), wis);
    AbilityStat cha = new AbilityStat(AbilityType.CHA);
    abilities.addComponent(AbilityType.CHA.toString(), cha);
    
    // Saves
    StatGroup saves = new StatGroup();
    addComponent("Saves", saves);
    SaveStat fort = new SaveStat(SaveType.FORT, con);
    saves.addComponent(SaveType.FORT.toString(), fort);
    SaveStat ref = new SaveStat(SaveType.REF, dex);
    saves.addComponent(SaveType.REF.toString(), ref);
    SaveStat will = new SaveStat(SaveType.WILL, wis);
    saves.addComponent(SaveType.WILL.toString(), will);

    // Initiative
    addComponent("Initiative", new Stat(0));
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public Alignment getAlignment()
  {
    return alignment;
  }
  
  public void setAlignment(Alignment alignment)
  {
    this.alignment = alignment;
  }
  
}
