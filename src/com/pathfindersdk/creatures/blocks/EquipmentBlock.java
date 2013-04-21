package com.pathfindersdk.creatures.blocks;

import java.util.HashMap;
import java.util.Map;

import com.pathfindersdk.enums.BodySlotType;
import com.pathfindersdk.equipment.Armor;
import com.pathfindersdk.equipment.Equipment;
import com.pathfindersdk.equipment.Shield;

final public class EquipmentBlock
{
  private Map<BodySlotType, Equipment> equipment = new HashMap<BodySlotType, Equipment>();
  
  public EquipmentBlock()
  {
    for(BodySlotType type : BodySlotType.values())
    {
      // Initialize all body slots with nothing
      equipment.put(type, null);
    }
  }
  
  public Equipment getSlot(BodySlotType bodySlot)
  {
    return equipment.get(bodySlot);
  }
  
  public void setArmorSlot(Armor armor)
  {
    equipment.put(BodySlotType.ARMOR, armor);
  }

//  public void setBeltSlot(Belt belt)
//  {
//    equipment.put(BodySlotType.BELT, belt);
//  }

//  public void setBodySlot(Robe robe)
//  {
//    equipment.put(BodySlotType.BODY, robe);
//  }

//  public void setChestSlot(Mantle mantle)
//  {
//    equipment.put(BodySlotType.CHEST, mantle);
//  }

//  public void setEyesSlot(Goggles goggles)
//  {
//    equipment.put(BodySlotType.EYES, goggles);
//  }

//  public void setFeetSlot(Boots boots)
//  {
//    equipment.put(BodySlotType.FEET, boots);
//  }

//  public void setHandsSlot(Gloves gloves)
//  {
//    equipment.put(BodySlotType.HANDS, gloves);
//  }

//  public void setHeadSlot(Helmet helmet)
//  {
//    equipment.put(BodySlotType.HEAD, helmet);
//  }

//  public void setHeadbandSlot(Headband headband)
//  {
//    equipment.put(BodySlotType.HEADBAND, headband);
//  }

//  public void setNeckSlot(Necklace necklace)
//  {
//    equipment.put(BodySlotType.NECK, necklace);
//  }

//  public void setFirstRingSlot(Ring ring)
//  {
//    equipment.put(BodySlotType.RING_1, ring);
//  }

//  public void setSecondRingSlot(Ring ring)
//  {
//    equipment.put(BodySlotType.RING_2, ring);
//  }

//  public void setPrimaryHandSlot(Weapon weapon)
//  {
//    equipment.put(BodySlotType.PRIMARY_HAND, weapon);
//    
//    // If two-handed, fill off-hand too
//  }

//  public void setOffHandSlot(Weapon weapon)
//  {
//    equipment.put(BodySlotType.OFF_HAND, weapon);
//  }

  public void setOffHandSlot(Shield shield)
  {
    equipment.put(BodySlotType.OFF_HAND, shield);
  }

//  public void setShoulderSlot(Cape cape)
//  {
//    equipment.put(BodySlotType.SHOULDER, cape);
//  }

//  public void setWristSlot(Bracers bracers)
//  {
//    equipment.put(BodySlotType.WRIST, bracers);
//  }

  
}
