package com.example.game02.tool;

import com.example.game02.model.Attribute;
import com.example.game02.model.CardType;
import com.example.game02.model.MonsterRace;

public record Vol1CardData(
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
