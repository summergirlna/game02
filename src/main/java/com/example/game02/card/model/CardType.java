package com.example.game02.card.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/// カードの種類
@RequiredArgsConstructor
@Getter
public enum CardType implements JapaneseNamed {
  MONSTER("モンスター"),
  SPELL("魔法"),
  TRAP("罠");

  private final String japaneseName;

  public static CardType fromJapaneseName(String japaneseName) {
    return EnumLookup.fromJapaneseName(CardType.class, japaneseName);
  }
}
