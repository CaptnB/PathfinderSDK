package com.pathfindersdk.equipment;

public class Shield extends BodyEquipment
{
  protected Integer ac;
  protected Integer maxDex;
  protected Integer checkPenalty;
  protected Float spellFailure;
  protected Boolean masterwork;
  
  public Shield(String name, int ac, int maxDex, int checkPenalty, float spellFailure, int cost, int weight)
  {
    super(name, cost, weight, BodySlot.SHIELD);
    this.ac = ac;
    this.maxDex = maxDex;
    this.checkPenalty = checkPenalty;
    this.spellFailure = spellFailure;
    this.masterwork = false;
  }
  
}
