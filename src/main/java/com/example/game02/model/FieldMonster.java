package com.example.game02.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/// フィールド上のモンスター定義
@Getter
@Setter
public class FieldMonster implements Serializable {

    private final MonsterCard card;
    private BattlePosition position;
    private boolean attackedThisTurn;

    public FieldMonster(MonsterCard card, BattlePosition position) {
        this.card = card;
        this.position = position;
        this.attackedThisTurn = false;
    }
}
