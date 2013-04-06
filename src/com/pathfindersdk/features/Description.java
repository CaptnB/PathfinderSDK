package com.pathfindersdk.features;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.AlignmentType;
import com.pathfindersdk.enums.GenderType;

public class Description implements Applicable<Character>
{
  protected String name;
  protected String playerName;
  protected String playerEmail;
  protected AlignmentType alignment;
  protected String deity;
  protected String homeland;
  protected GenderType gender;
  protected int age;
  protected double height;
  protected double weight;
  protected String hairColor;
  protected String eyesColor;
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }

  public String getPlayerName()
  {
    return playerName;
  }

  public void setPlayerName(String playerName)
  {
    this.playerName = playerName;
  }

  public String getPlayerEmail()
  {
    return playerEmail;
  }

  public void setPlayerEmail(String playerEmail)
  {
    this.playerEmail = playerEmail;
  }

  public AlignmentType getAlignment()
  {
    return alignment;
  }

  public void setAlignment(AlignmentType alignment)
  {
    this.alignment = alignment;
  }

  public String getDeity()
  {
    return deity;
  }

  public void setDeity(String deity)
  {
    this.deity = deity;
  }

  public String getHomeland()
  {
    return homeland;
  }

  public void setHomeland(String homeland)
  {
    this.homeland = homeland;
  }

  public GenderType getGender()
  {
    return gender;
  }

  public void setGender(GenderType gender)
  {
    this.gender = gender;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public double getHeight()
  {
    return height;
  }

  public void setHeight(double height)
  {
    this.height = height;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public String getHairColor()
  {
    return hairColor;
  }

  public void setHairColor(String hairColor)
  {
    this.hairColor = hairColor;
  }

  public String getEyesColor()
  {
    return eyesColor;
  }

  public void setEyesColor(String eyesColor)
  {
    this.eyesColor = eyesColor;
  }

  @Override
  public void applyTo(Character character)
  {
    character.setName(name);
    character.setAlignment(alignment);
  }

  @Override
  public void removeFrom(Character character)
  {
    character.setName(null);
    character.setAlignment(null);
  }

}
