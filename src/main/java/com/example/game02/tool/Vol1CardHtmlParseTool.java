package com.example.game02.tool;

import com.example.game02.model.Attribute;
import com.example.game02.model.CardType;
import com.example.game02.model.MonsterRace;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tools.jackson.databind.ObjectMapper;

public class Vol1CardHtmlParseTool {

  private static final Path VOL1_HTML_PATH = Path.of("tmp", "vol1.html");
  private static final Path OUTPUT_JSON_PATH =
      Path.of("src", "main", "resources", "data", "vol1-cards.json");

  public static void main(String[] args) throws Exception {
    Document document = Jsoup.parse(VOL1_HTML_PATH, StandardCharsets.UTF_8.name());

    Elements rows = document.select("#card_list .t_row");

    System.out.println("cards: " + rows.size());

    List<Vol1CardData> cards = new ArrayList<>();

    for (int i = 0; i < rows.size(); i++) {
      Element row = rows.get(i);

      Vol1CardData card = parseCard(row);
      cards.add(card);

      System.out.printf(
          "%02d %s cid=%s name=%s rarity=%s%n",
          i + 1, card.cardType(), card.cid(), card.name(), card.rarity());
    }

    writeJson(cards);

    System.out.println("Saved: " + OUTPUT_JSON_PATH.toAbsolutePath());
  }

  private static Vol1CardData parseCard(Element row) {
    String cid = textOrValue(row, ".cid", true);
    String name = textOrValue(row, ".card_name", false);
    String ruby = textOrValue(row, ".card_ruby", false);
    String attributeOrType = textOrValue(row, ".box_card_attribute span", false);
    String levelText = textOrValue(row, ".box_card_level_rank span", false);
    String speciesText = textOrValue(row, ".card_info_species_and_other_item span", false);
    String attackText = textOrValue(row, ".atk_power span", false);
    String defenseText = textOrValue(row, ".def_power span", false);
    String description = textOrValue(row, ".box_card_text", false);
    String rarity = textOrValue(row, ".lr_icon p", false);
    String rarityName = textOrValue(row, ".lr_icon span", false);

    String id = "vol1-" + cid;

    if (isMonster(attributeOrType)) {
      Attribute attribute = Attribute.fromJapaneseName(attributeOrType);
      int level = OfficialCardTextParser.parseLevel(levelText);
      String raceName = OfficialCardTextParser.parseMonsterRaceName(speciesText);
      String monsterKindName = OfficialCardTextParser.parseMonsterKindName(speciesText);
      MonsterRace race = MonsterRace.fromJapaneseName(raceName);
      int attack = OfficialCardTextParser.parseAttack(attackText);
      int defense = OfficialCardTextParser.parseDefense(defenseText);

      return new Vol1CardData(
          id,
          cid,
          name,
          ruby,
          CardType.MONSTER,
          attribute,
          level,
          race,
          monsterKindName,
          attack,
          defense,
          description,
          rarity,
          rarityName);
    }

    CardType cardType = CardType.fromJapaneseName(attributeOrType);

    return new Vol1CardData(
        id,
        cid,
        name,
        ruby,
        cardType,
        null,
        null,
        null,
        null,
        null,
        null,
        description,
        rarity,
        rarityName);
  }

  private static void writeJson(List<Vol1CardData> cards) throws Exception {
    Files.createDirectories(OUTPUT_JSON_PATH.getParent());

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writerWithDefaultPrettyPrinter().writeValue(OUTPUT_JSON_PATH.toFile(), cards);
  }

  private static boolean isMonster(String attributeOrType) {
    return !"魔法".equals(attributeOrType) && !"罠".equals(attributeOrType);
  }

  private static String textOrValue(Element row, String selector, boolean value) {
    Element element = row.selectFirst(selector);

    if (element == null) {
      return "";
    }

    if (value) {
      return element.attr("value").trim();
    }

    return element.text().trim();
  }
}
