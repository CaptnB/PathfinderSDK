package com.pathfindersdk.tests.utils;

import org.junit.Test;

import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.utils.ArgChecker;

public class ArgCheckerTest
{

  @Test
  public void testCheckNullPass()
  {
    ArgChecker.checkNotNull(new Object());
  }

  @Test
  public void testCheckEmptyPass()
  {
    ArgChecker.checkNotEmpty("a string");
  }

  @Test
  public void testCkeckRangeIntIntIntPass()
  {
    ArgChecker.checkInRange(5, 0, 10);
  }

  @Test
  public void testCkeckRangeIntIntIntUpperPass()
  {
    ArgChecker.checkInRange(10, 0, 10);
  }

  @Test
  public void testCkeckRangeIntIntIntLowerPass()
  {
    ArgChecker.checkInRange(0, 0, 10);
  }

  @Test
  public void testCheckPositivePass()
  {
    ArgChecker.checkIsPositive(5);
  }

  @Test
  public void testCheckPositiveZeroPass()
  {
    ArgChecker.checkIsPositive(0);
  }

  @Test
  public void testCkeckRangeDoubleDoubleDoublePass()
  {
    ArgChecker.checkInRange(5.0, 0.0, 10.0);
  }

  @Test
  public void testCkeckRangeDoubleDoubleDoubleUpperPass()
  {
    ArgChecker.checkInRange(10.0, 0.0, 10.0);
  }

  @Test
  public void testCkeckRangeDoubleDoubleDoubleLowerPass()
  {
    ArgChecker.checkInRange(0.0, 0.0, 10.0);
  }

  @Test
  public void testCheckPositiveDoublePass()
  {
    ArgChecker.checkIsPositive(5.0);
  }

  @Test
  public void testCheckPositiveDoubleZeroPass()
  {
    ArgChecker.checkIsPositive(0.0);
  }

  @Test
  public void testCheckIsNotPass()
  {
    ArgChecker.checkIsNot(AbilityType.CHA, AbilityType.ANY);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCheckNullFail()
  {
    ArgChecker.checkNotNull(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCheckEmptyFail()
  {
    ArgChecker.checkNotEmpty("");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCkeckRangeIntIntIntLowerFail()
  {
    ArgChecker.checkInRange(-5, 0, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCkeckRangeIntIntIntUpperFail()
  {
    ArgChecker.checkInRange(15, 0, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCheckPositiveIntFail()
  {
    ArgChecker.checkIsPositive(-5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCkeckRangeDoubleDoubleDoubleLowerFail()
  {
    ArgChecker.checkInRange(-5.0, 0.0, 10.0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCkeckRangeDoubleDoubleDoubleUpperFail()
  {
    ArgChecker.checkInRange(15.0, 0.0, 10.0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCheckPositiveDoubleFail()
  {
    ArgChecker.checkIsPositive(-5.0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testCheckIsNotFail()
  {
    ArgChecker.checkIsNot(AbilityType.ANY, AbilityType.ANY);
  }

}
