package com.example.game02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/// デュエル中のプレイヤーの定義
@Getter
@Setter
public class DuelPlayer implements Serializable {

  public static final int MONSTER_ZONE_SIZE = 5;

  private int lifePoints;
  private final List<Card> deck;
  private final List<Card> hand;
  private final List<Card> graveyard;
  private final List<FieldMonster> monsterZones;
  private boolean normalSummonedThisTurn;

  public DuelPlayer(List<Card> deck) {
    this.lifePoints = 8000;
    this.deck = new ArrayList<>(deck);
    this.hand = new ArrayList<>();
    this.graveyard = new ArrayList<>();
    this.monsterZones = new ArrayList<>();

    for (int i = 0; i < MONSTER_ZONE_SIZE; i++) {
      this.monsterZones.add(null);
    }

    this.normalSummonedThisTurn = false;
  }

  /// モンスターゾーンが空かどうか
  ///
  /// @return モンスターゾンーが空の場合はtrue
  public boolean hasEmptyMonsterZone() {
    return monsterZones.stream().anyMatch(Objects::isNull);
  }

  /// 攻撃フラグをリセットする
  public void resetTurnFlags() {
    this.normalSummonedThisTurn = false;
    for (FieldMonster monster : monsterZones) {
      if (monster != null) {
        monster.setAttackedThisTurn(false);
      }
    }
  }
}
