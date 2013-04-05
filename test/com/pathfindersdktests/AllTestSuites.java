package com.pathfindersdktests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pathfindersdktests.bonus.BonusTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ BonusTestSuite.class })
public class AllTestSuites
{

}
