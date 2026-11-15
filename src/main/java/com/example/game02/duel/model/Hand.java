package com.example.game02.duel.model;

import com.example.game02.card.model.Card;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hand implements Serializable {
  private final List<Card> cards = new ArrayList<>();

  public void add(Card card) {
    if (card == null) {
      throw new IllegalArgumentException("Card must not be null");
    }

    cards.add(card);
  }

  public Card get(int index) {
    validateIndex(index);
    return cards.get(index);
  }

  public Card remove(int index) {
    validateIndex(index);
    return cards.remove(index);
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

  private void validateIndex(int index) {
    if (index < 0 || index >= cards.size()) {
      throw new IllegalArgumentException("Invalid hand index: " + index);
    }
  }
}
