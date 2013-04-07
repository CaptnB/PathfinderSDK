package com.pathfindersdktests.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.SizeBonus;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.stats.Size;

public class SizeBonusTest
{

  @Test
  public void testApplyTo()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));

    Bonus bonus = new SizeBonus(2, BonusType.ARMOR);
    bonus.applyTo(character);

    assertEquals(SizeType.HUGE, character.getSize().getSize());
  }

  @Test
  public void testRemoveFrom()
  {
    Character character = new Character();
    character.setSize(new Size(SizeType.MEDIUM));

    Bonus bonus = new SizeBonus(2, BonusType.ARMOR);
    bonus.removeFrom(character);

    assertEquals(SizeType.MEDIUM, character.getSize().getSize());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testApplyToNull()
  {
    Bonus bonus = new SizeBonus(2, BonusType.ARMOR);
    bonus.applyTo(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveFromNull()
  {
    Bonus bonus = new SizeBonus(2, BonusType.ARMOR);
    bonus.removeFrom(null);
  }

}
