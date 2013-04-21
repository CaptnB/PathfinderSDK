package com.pathfindersdk.tests.stats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.items.ArmorItem;
import com.pathfindersdk.books.items.ShieldItem;
import com.pathfindersdk.coins.Coins;
import com.pathfindersdk.enums.ArmorType;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.equipment.Armor;
import com.pathfindersdk.equipment.Shield;
import com.pathfindersdk.stats.AbilityScore;
import com.pathfindersdk.stats.ArmorClass;
import com.pathfindersdk.stats.Size;

public class ArmorClassTest
{

  @Test (expected = IllegalArgumentException.class)
  public void testArmorClassAbilityScoreNull()
  {
    new ArmorClass(new AbilityScore(), null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testArmorClassNullSize()
  {
    new ArmorClass(null, new Size(SizeType.MEDIUM));
  }
  
  @Test
  public void testAddAbilityScore()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    ac.addAbilityScore(new AbilityScore(16));   // +3 ability modifier
    
    assertEquals(11, ac.getScore());
  }
  
  @Test
  public void testAddManyAbilityScore()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    ac.addAbilityScore(new AbilityScore(16));   // +3 ability modifier
    ac.addAbilityScore(new AbilityScore(8));    // -1 ability modifier
    
    assertEquals(10, ac.getScore());
  }
  
  @Test
  public void testRemoveAbilityScore()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    AbilityScore score = new AbilityScore(16); 
    ac.addAbilityScore(score);
    ac.removeAbilityScore(score);
    
    assertEquals(8, ac.getScore());
  }
  
  @Test
  public void testRemoveManyAbilityScore()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    AbilityScore score1 = new AbilityScore(16); 
    AbilityScore score2 = new AbilityScore(8); 
    ac.addAbilityScore(score1);
    ac.addAbilityScore(score2);
    ac.removeAbilityScore(score1);
    
    assertEquals(7, ac.getScore());
  }
  
  @Test
  public void testRemoveEmptyAbilityScore()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    AbilityScore score = new AbilityScore(16); 
    ac.removeAbilityScore(score);
    
    assertEquals(8, ac.getScore());
  }

  @Test
  public void testGetScoreWithoutArmorShield()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    ArmorClass ac = new ArmorClass(dex, size);
    
    assertEquals(8, ac.getScore());
  }

  @Test
  public void testGetScoreWithOnlyArmor()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Armor armor = new Armor(new ArmorItem("Some armor", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    
    assertEquals(9, ac.getScore());
  }
  
  @Test
  public void testGetScoreSwapArmor()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Armor armor1 = new Armor(new ArmorItem("Armor 1", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    Armor armor2 = new Armor(new ArmorItem("Armor 2", ArmorType.LIGHT, 4, 3, -1, 0.0, 1, new Coins()));   // +4 Armor, +3 max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor1);
    ac.setArmor(armor2);
    
    assertEquals(12, ac.getScore());
  }
  
  
  @Test
  public void testGetScoreSwapArmorToNull()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Armor armor = new Armor(new ArmorItem("Armor 1", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    ac.setArmor(null);
    
    assertEquals(8, ac.getScore());
  }


  @Test
  public void testGetScoreWithOnlyShieldNoMaxDex()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Shield shield = new Shield(new ShieldItem("Some shield", 2, -1, 0.0, 1, new Coins()));   // +2 Shield, no max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setShield(shield);
    
    assertEquals(10, ac.getScore());
  }

  @Test
  public void testGetScoreWithOnlyShield()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Shield shield = new Shield(new ShieldItem("Some shield", 2, 1, -1, 0.0, 1, new Coins()));   // +2 Shield, +1 max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setShield(shield);
    
    assertEquals(9, ac.getScore());
  }

  @Test
  public void testGetScoreSwapShield()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Shield shield1 = new Shield(new ShieldItem("Shield 1", 2, -1, 0.0, 1, new Coins()));   // +2 Shield, no max dex
    Shield shield2 = new Shield(new ShieldItem("Shield 2", 4, -1, 0.0, 1, new Coins()));   // +4 Shield, no max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setShield(shield1);
    ac.setShield(shield2);
    
    assertEquals(12, ac.getScore());
  }

  @Test
  public void testGetScoreSwapShieldToNull()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Shield shield = new Shield(new ShieldItem("Shield 1", 2, -1, 0.0, 1, new Coins()));   // +2 Shield, no max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setShield(shield);
    ac.setShield(null);
    
    assertEquals(8, ac.getScore());
  }

  @Test
  public void testGetScoreWithArmorAndShield()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier
    Armor armor = new Armor(new ArmorItem("Some armor", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    Shield shield = new Shield(new ShieldItem("Some shield", 2, 0, -1, 0.0, 1, new Coins()));               // +2 Shield, +0 max dex
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    ac.setShield(shield);
    
    assertEquals(10, ac.getScore());
  }
  
  @Test
  public void testGetScoreWithArmorShieldAndBonus()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier

    Armor armor = new Armor(new ArmorItem("Some armor", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    Shield shield = new Shield(new ShieldItem("Some shield", 2, 0, -1, 0.0, 1, new Coins()));               // +2 Shield, +0 max dex
    
    Bonus armorBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Armor"));    // +4 Armor, supersedes armor
    Bonus shieldBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Shield"));  // +4 Shield, supersedes shield
    Bonus otherBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Luck"));     // +4 Luck
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    ac.setShield(shield);
    ac.addBonus(armorBonus);
    ac.addBonus(shieldBonus);
    ac.addBonus(otherBonus);
    
    assertEquals(18, ac.getScore());
  }
  

  @Test
  public void testGetTouch()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier

    Armor armor = new Armor(new ArmorItem("Some armor", ArmorType.LIGHT, 2, 1, -1, 0.0, 1, new Coins()));   // +2 Armor, +1 max dex
    Shield shield = new Shield(new ShieldItem("Some shield", 2, 0, -1, 0.0, 1, new Coins()));               // +2 Shield, +0 max dex
    
    Bonus natBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Natural Armor"));    // +4 Natural Armor
    Bonus otherBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Luck"));           // +4 Luck
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    ac.setShield(shield);
    ac.addBonus(natBonus);
    ac.addBonus(otherBonus);
    
    assertEquals(10, ac.getTouchScore());
  }

  @Test
  public void testGetFlatFooted()
  {
    AbilityScore dex = new AbilityScore(14);    // +2 dex modifier
    Size size = new Size(SizeType.GARGANTUAN);  // -4 size modifier

    Armor armor = new Armor(new ArmorItem("Some armor", ArmorType.LIGHT, 2, 2, -1, 0.0, 1, new Coins()));   // +2 Armor, +2 max dex
    Shield shield = new Shield(new ShieldItem("Some shield", 2, 2, -1, 0.0, 1, new Coins()));               // +2 Shield, +2 max dex
    
    Bonus dodgeBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Dodge"));          // +4 Dodge
    Bonus otherBonus = new AcBonus(4, BonusTypeRegister.getInstance().get("Luck"));           // +4 Luck
    
    ArmorClass ac = new ArmorClass(dex, size);
    ac.setArmor(armor);
    ac.setShield(shield);
    ac.addBonus(dodgeBonus);
    ac.addBonus(otherBonus);
    
    assertEquals(14, ac.getFlatFootedScore());
  }

}
