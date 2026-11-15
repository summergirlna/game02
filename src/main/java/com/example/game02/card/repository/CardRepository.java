package com.example.game02.card.repository;

import com.example.game02.card.model.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Repository
public class CardRepository {

  private final String VOL1_CARDS_JSON = "/data/vol1-cards.json";

  private final List<Card> cards;

  public CardRepository() {
    this.cards = loadCards();
  }

  public List<Card> findAll() {
    return List.copyOf(cards);
  }

  public Optional<Card> findById(String id) {
    return cards.stream().filter(card -> card.getId().equals(id)).findFirst();
  }

  public List<MonsterCard> findMonsterCards() {
    return cards.stream()
        .filter(MonsterCard.class::isInstance)
        .map(MonsterCard.class::cast)
        .toList();
  }

  public List<Card> createStarterDeck() {
    List<Card> deck = new ArrayList<>();

    List<MonsterCard> monsters = findMonsterCards();

    for (MonsterCard monster : monsters) {
      deck.add(monster);
    }

    int index = 0;
    while (deck.size() < 40) {
      deck.add(monsters.get(index % monsters.size()));
      index++;
    }

    return deck;
  }

  private List<Card> loadCards() {
    try (InputStream inputStream = getClass().getResourceAsStream(VOL1_CARDS_JSON)) {
      if (inputStream == null) {
        throw new IllegalStateException("Card data not found: " + VOL1_CARDS_JSON);
      }

      ObjectMapper objectMapper = new ObjectMapper();

      List<CardData> cardDataList =
          objectMapper.readValue(inputStream, new TypeReference<List<CardData>>() {});

      return cardDataList.stream().map(this::toCard).toList();

    } catch (Exception e) {
      throw new IllegalStateException("Failed to load card data", e);
    }
  }

  private Card toCard(CardData data) {
    if (data.cardType() == CardType.MONSTER) {
      return MonsterCard.builder()
          .id(data.id())
          .name(data.name())
          .description(data.description())
          .level(new Level(data.level()))
          .attribute(data.attribute())
          .race(data.race())
          .attack(new CardPower(data.attack()))
          .defense(new CardPower(data.defense()))
          .build();
    }

    return Card.builder()
        .id(data.id())
        .name(data.name())
        .cardType(data.cardType())
        .description(data.description())
        .build();
  }
}
