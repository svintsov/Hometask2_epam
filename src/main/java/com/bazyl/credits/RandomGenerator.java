package com.bazyl.credits;

public class RandomGenerator {

  public  static int RAND_MIN = 0;
  public static int RAND_MAX = 100;

  public static int rand(int min, int max) {
    return (int) Math.floor(Math.random() * (max - min + 1)) + min;
  }

  public static int rand() {
    return (int) Math.floor(Math.random() * (RAND_MAX - RAND_MIN + 1)) + RAND_MIN;
  }
}
