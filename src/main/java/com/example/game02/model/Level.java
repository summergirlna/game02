package com.example.game02.model;

public record Level(int value) implements Comparable<Level> {

  public static final int MIN_VALUE = 1;
  public static final int MAX_VALUE = 12;

  public Level {
    if (value < MIN_VALUE || value > MAX_VALUE) {
      throw new IllegalArgumentException(
          "Level must be between " + MIN_VALUE + " and " + MAX_VALUE + ": " + value);
    }
  }

  public boolean isGreaterThan(Level other) {
    return this.value > other.value;
  }

  public boolean isLessThan(Level other) {
    return this.value < other.value;
  }

  public boolean isEqualTo(Level other) {
    return this.value == other.value;
  }

  @Override
  public int compareTo(Level other) {
    return Integer.compare(this.value, other.value);
  }
}
