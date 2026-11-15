package com.example.game02.model;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
  private final List<Card> cards = new ArrayList<>();

  public void add(Card card) {
    if (card == null) {
      throw new IllegalArgumentException("Card must not be null");
    }

    cards.add(card);
  }

  public int size() {
    return cards.size();
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }

  public List<Card> asList() {
    return List.copyOf(cards);
  }
}
