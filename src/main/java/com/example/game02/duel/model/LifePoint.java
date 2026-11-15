package com.example.game02.duel.model;

public record LifePoint(int value) {

  public static final int INITIAL_VALUE = 8000;
  public static final LifePoint INITIAL = new LifePoint(INITIAL_VALUE);
  public static final LifePoint ZERO = new LifePoint(0);

  public LifePoint {
    if (value < 0) {
      value = 0;
    }
  }

  public LifePoint damage(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Damage amount must not be negative: " + amount);
    }

    return new LifePoint(value - amount);
  }

  public LifePoint heal(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Heal amount must not be negative: " + amount);
    }

    return new LifePoint(value + amount);
  }

  public boolean isZero() {
    return value == 0;
  }
}
