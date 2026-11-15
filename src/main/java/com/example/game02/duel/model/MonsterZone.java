package com.example.game02.duel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonsterZone implements Serializable {
  public static final int SIZE = 5;

  private final List<FieldMonster> zones = new ArrayList<>();

  public MonsterZone() {
    for (int i = 0; i < SIZE; i++) {
      zones.add(null);
    }
  }

  public boolean hasEmptyZone() {
    return zones.stream().anyMatch(Objects::isNull);
  }

  public boolean isEmpty() {
    return zones.stream().allMatch(Objects::isNull);
  }

  public FieldMonster get(int index) {
    validateIndex(index);
    return zones.get(index);
  }

  public void summon(int index, FieldMonster monster) {
    validateIndex(index);

    if (monster == null) {
      throw new IllegalArgumentException("Monster must not be null");
    }

    if (zones.get(index) != null) {
      throw new IllegalStateException("Monster zone is already occupied: " + index);
    }

    zones.set(index, monster);
  }

  public FieldMonster remove(int index) {
    validateIndex(index);

    FieldMonster monster = zones.get(index);

    if (monster == null) {
      throw new IllegalStateException("Monster zone is empty: " + index);
    }

    zones.set(index, null);
    return monster;
  }

  public void resetAttackFlags() {
    for (FieldMonster monster : zones) {
      if (monster != null) {
        monster.setAttackedThisTurn(false);
      }
    }
  }

  public List<FieldMonster> asList() {
    return List.copyOf(zones);
  }

  public List<FieldMonster> livingMonsters() {
    return zones.stream().filter(Objects::nonNull).toList();
  }

  private void validateIndex(int index) {
    if (index < 0 || index >= SIZE) {
      throw new IllegalArgumentException("Invalid monster zone index: " + index);
    }
  }
}
