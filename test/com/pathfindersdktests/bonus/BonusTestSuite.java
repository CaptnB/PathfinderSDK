package com.pathfindersdktests.bonus;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
  BonusTest.class, 
  AcBonusTest.class, 
  AttackBonusTest.class, 
  CmbBonusTest.class, 
  CmdBonusTest.class, 
  InitiativeBonusTest.class,
  SaveBonusTest.class, 
  SizeBonusTest.class, 
  SkillBonusTest.class, 
  SpeedBonusTest.class 
  })
public class BonusTestSuite
{

}
