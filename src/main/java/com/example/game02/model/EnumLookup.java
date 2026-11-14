package com.example.game02.model;

import java.util.Arrays;

public final class EnumLookup {
  private EnumLookup() {}

  public static <E extends Enum<E> & JapaneseNamed> E fromJapaneseName(
      Class<E> enumType, String japaneseName) {
    return Arrays.stream(enumType.getEnumConstants())
        .filter(value -> value.getJapaneseName().equals(japaneseName))
        .findFirst()
        .orElseThrow(() ->
            new IllegalArgumentException(
                "Unknown " + enumType.getSimpleName() + ": " + japaneseName));
  }
}
