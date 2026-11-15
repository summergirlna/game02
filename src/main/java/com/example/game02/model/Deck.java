package com.example.game02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements Serializable {
  private final List<Card> cards;

  public Deck(List<Card> cards) {
    if (cards == null) {
      throw new IllegalArgumentException("Deck cards must not be null");
    }

    this.cards = new ArrayList<>(cards);
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card draw() {
    if (isEmpty()) {
      throw new IllegalStateException("Cannot draw from empty deck");
    }

    return cards.removeFirst();
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }

  public int size() {
    return cards.size();
  }

  public List<Card> asList() {
    return List.copyOf(cards);
  }
}
