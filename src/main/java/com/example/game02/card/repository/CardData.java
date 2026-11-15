package com.example.game02.card.repository;

import com.example.game02.card.model.Attribute;
import com.example.game02.card.model.CardType;
import com.example.game02.card.model.MonsterRace;

public record CardData(
    String id,
    String cid,
    String name,
    String ruby,
    CardType cardType,
    Attribute attribute,
    Integer level,
    MonsterRace race,
    String monsterKind,
    Integer attack,
    Integer defense,
    String description,
    String rarity,
    String rarityName) {}
