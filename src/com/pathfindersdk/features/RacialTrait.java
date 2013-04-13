package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.NullPrerequisite;

/**
 * Essentially a limited Feature class that only targets Character (Monsters don't have a Race) and prevents having Prerequsites.
 */
public class RacialTrait extends Feature<Character>
{
   
  public RacialTrait(String name, Applicable<Creature> ... applicables)
  {
    // RacialTrais come from a Race. If you are not from that Race, you just don't have access to that RacialTrait. 
    // Prerequisite is superfluous. 
    super(name, new NullPrerequisite<Creature>(), applicables);
  }

}
