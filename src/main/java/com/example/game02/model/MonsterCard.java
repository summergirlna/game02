package com.example.game02.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/// モンスターカード
@Getter
@SuperBuilder
public class MonsterCard extends Card {

  private final int level;
  private final Attribute attribute;
  private final MonsterRace race;
  private final CardPower attack;
  private final CardPower defense;

}
