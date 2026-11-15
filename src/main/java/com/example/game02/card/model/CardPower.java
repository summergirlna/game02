package com.example.game02.card.model;

public record CardPower(int value) implements Comparable<CardPower> {

  public static final CardPower ZERO = new CardPower(0);

  public CardPower {
    if (value < 0) {
      throw new IllegalArgumentException("Card power must not be negative: " + value);
    }
  }

  public CardPower increase(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Increase amount must not be negative: " + amount);
    }

    return new CardPower(value + amount);
  }

  public CardPower decrease(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Decrease amount must not be negative: " + amount);
    }

    return new CardPower(Math.max(0, value - amount));
  }

  public int difference(CardPower other) {
    return this.value - other.value;
  }

  public boolean isGreaterThan(CardPower other) {
    return this.value > other.value;
  }

  public boolean isLessThan(CardPower other) {
    return this.value < other.value;
  }

  public boolean isEqualTo(CardPower other) {
    return this.value == other.value;
  }

  @Override
  public int compareTo(CardPower other) {
    return Integer.compare(this.value, other.value);
  }
}
