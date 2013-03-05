package com.pathfindersdk.equipment;

import com.pathfindersdk.enums.BodySlotType;

public class BodyEquipment extends Equipment
{
  protected BodySlotType slot;

  public BodyEquipment(String name, int cost, int weight, BodySlotType slot)
  {
    super(name, cost, weight);
    this.slot = slot;
  }

}
