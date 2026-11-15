package com.example.game02.duel.model;

import com.example.game02.card.model.Card;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

/// デュエル中のプレイヤーの定義
@Getter
public class DuelPlayer implements Serializable {

  public static final int MONSTER_ZONE_SIZE = 5;

  private LifePoint lifePoint;
  private final Deck deck;
  private final Hand hand;
  private final Graveyard graveyard;
  private final MonsterZone monsterZone;
  private boolean normalSummonedThisTurn;

  public DuelPlayer(List<Card> deckCards) {
    this.lifePoint = LifePoint.INITIAL;
    this.deck = new Deck(deckCards);
    this.hand = new Hand();
    this.graveyard = new Graveyard();
    this.monsterZone = new MonsterZone();
    this.normalSummonedThisTurn = false;
  }

  public void draw() {
    hand.add(deck.draw());
  }

  public boolean canDraw() {
    return !deck.isEmpty();
  }

  /// モンスターゾーンが空かどうか
  ///
  /// @return モンスターゾーンが空の場合はtrue
  public boolean hasEmptyMonsterZone() {
    return monsterZone.hasEmptyZone();
  }

  /// 攻撃フラグをリセットする
  public void resetTurnFlags() {
    this.normalSummonedThisTurn = false;
    this.monsterZone.resetAttackFlags();
  }

  public void markNormalSummoned() {
    this.normalSummonedThisTurn = true;
  }

  public void damage(int amount) {
    this.lifePoint = this.lifePoint.damage(amount);
  }

  public void heal(int amount) {
    this.lifePoint = this.lifePoint.heal(amount);
  }

  public boolean isDefeated() {
    return this.lifePoint.isZero();
  }
}
