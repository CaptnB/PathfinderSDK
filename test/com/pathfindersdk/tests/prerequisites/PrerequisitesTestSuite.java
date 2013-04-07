package com.pathfindersdk.tests.prerequisites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  AbilityPrerequisiteTest.class,
  AlignmentPrerequisiteTest.class,
  AndPrerequisiteTest.class,
  FeatPrerequisiteTest.class,
  OrPrerequisiteTest.class,
  RacialTraitPrerequisiteTest.class,
  SkillPrerequisiteTest.class
})
public class PrerequisitesTestSuite
{

}
