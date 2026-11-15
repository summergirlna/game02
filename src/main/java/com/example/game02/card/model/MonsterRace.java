package com.example.game02.card.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/// 種族
@RequiredArgsConstructor
@Getter
public enum MonsterRace implements JapaneseNamed {
  DRAGON("ドラゴン族"),
  SPELLCASTER("魔法使い族"),
  ZOMBIE("アンデット族"),
  WARRIOR("戦士族"),
  BEAST_WARRIOR("獣戦士族"),
  BEAST("獣族"),
  WINGED_BEAST("鳥獣族"),
  FIEND("悪魔族"),
  FAIRY("天使族"),
  INSECT("昆虫族"),
  DINOSAUR("恐竜族"),
  REPTILE("爬虫類族"),
  FISH("魚族"),
  SEA_SERPENT("海竜族"),
  MACHINE("機械族"),
  THUNDER("雷族"),
  AQUA("水族"),
  PYRO("炎族"),
  ROCK("岩石族"),
  PLANT("植物族");

  private final String japaneseName;

  public static MonsterRace fromJapaneseName(String japaneseName) {
    return EnumLookup.fromJapaneseName(MonsterRace.class, japaneseName);
  }
}
