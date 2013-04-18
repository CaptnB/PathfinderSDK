package com.pathfindersdk.stats;

import java.util.Random;

import com.pathfindersdk.utils.ArgChecker;


final public class Dice implements Rollable
{
  final private int numbers;
  final private int faces;
  final private Integer seed;
  
  public Dice(int numbers, int faces)
  {
    this(numbers, faces, null);
  }
  
  public Dice(int numbers, int faces, Integer seed)
  {
    ArgChecker.checkIsPositive(numbers);
    ArgChecker.checkIsPositive(faces);

    this.numbers = numbers;
    this.faces = faces;
    this.seed = seed;
  }
  
  @Override
  public int roll()
  {
    Random random;
    if(seed != null)
      random = new Random(seed);
    else
      random = new Random();

    int roll = 0;
    for(int i = 0; i < numbers; i++)
      roll += random.nextInt(faces) + 1;

    return roll;
  }
}
