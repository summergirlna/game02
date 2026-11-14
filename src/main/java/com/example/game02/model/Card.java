package com.example.game02.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/// カード
@Getter
@RequiredArgsConstructor
public class Card implements Serializable {

    private final String id;
    private final String name;
    private final CardType cardType;
    private final String description;
}
