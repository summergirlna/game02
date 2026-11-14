package com.example.game02.model;

import lombok.Getter;

/// モンスターカード
@Getter
public class MonsterCard extends Card {

  private final int level;
  private final Attribute attribute;
  private final MonsterRace race;
  private final int attack;
  private final int defense;

  public MonsterCard(
      String id,
      String name,
      String description,
      int level,
      Attribute attribute,
      MonsterRace race,
      int attack,
      int defense) {
    super(id, name, CardType.MONSTER, description);
    this.level = level;
    this.attribute = attribute;
    this.race = race;
    this.attack = attack;
    this.defense = defense;
  }
}
