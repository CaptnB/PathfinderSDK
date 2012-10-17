package com.pathfindersdk.equipment;

public class BodyEquipment extends Equipment
{
  protected BodySlot slot;

  public BodyEquipment(String name, int cost, int weight, BodySlot slot)
  {
    super(name, cost, weight);
    this.slot = slot;
  }

}
