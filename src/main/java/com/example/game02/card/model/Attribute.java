package com.example.game02.card.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/// 属性
@RequiredArgsConstructor
@Getter
public enum Attribute implements JapaneseNamed {
  DARK("闇属性"),
  LIGHT("光属性"),
  EARTH("地属性"),
  WATER("水属性"),
  FIRE("炎属性"),
  WIND("風属性");

  private final String japaneseName;

  public static Attribute fromJapaneseName(String japaneseName) {
    return EnumLookup.fromJapaneseName(Attribute.class, japaneseName);
  }
}
