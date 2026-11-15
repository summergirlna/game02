package com.example.game02.card.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

/// カード
@Getter
@RequiredArgsConstructor
@SuperBuilder
public class Card implements Serializable {

  private final String id;
  private final String name;
  private final CardType cardType;
  private final String description;
}
