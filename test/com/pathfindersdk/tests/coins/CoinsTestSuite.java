package com.pathfindersdk.tests.coins;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  PieceTest.class,
  CopperPieceTest.class,
  SilverPieceTest.class,
  GoldPieceTest.class,
  PlatinumPieceTest.class,
  CoinsTest.class
})
public class CoinsTestSuite
{

}
