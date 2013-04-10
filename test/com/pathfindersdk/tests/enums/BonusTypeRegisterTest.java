package com.pathfindersdk.tests.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.enums.BonusTypeRegister;

public class BonusTypeRegisterTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testRegisterNull()
  {
    BonusTypeRegister.getInstance().register(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRegisterEmpty()
  {
    BonusTypeRegister.getInstance().register("");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRegisterDuplicate()
  {
    // Default BonusTypeRegister constructor already defines some basic bonus types like "Armor"
    BonusTypeRegister.getInstance().register("Armor");
  }
  
  @Test
  public void testRegisterAndGet()
  {
    BonusTypeRegister.getInstance().register("New Type");
    
    assertEquals(" New Type", BonusTypeRegister.getInstance().get("New Type").toString());
  }

}
