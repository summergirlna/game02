package com.example.game02.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Vol1CardHtmlParseTool {

    private static final Path VOL1_HTML_PATH = Path.of("tmp", "vol1.html");

    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(VOL1_HTML_PATH, StandardCharsets.UTF_8.name());

        Elements rows = document.select("#card_list .t_row");

        System.out.println("cards: " + rows.size());

        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);

            String cid = row.selectFirst(".cid") != null
                    ? row.selectFirst(".cid").attr("value").trim()
                    : "";

            String name = row.selectFirst(".card_name") != null
                    ? row.selectFirst(".card_name").text().trim()
                    : "";

            String ruby = row.selectFirst(".card_ruby") != null
                    ? row.selectFirst(".card_ruby").text().trim()
                    : "";

            String attributeOrType = row.selectFirst(".box_card_attribute span") != null
                    ? row.selectFirst(".box_card_attribute span").text().trim()
                    : "";

            String levelText = row.selectFirst(".box_card_level_rank span") != null
                    ? row.selectFirst(".box_card_level_rank span").text().trim()
                    : "";

            String speciesText = row.selectFirst(".card_info_species_and_other_item span") != null
                    ? row.selectFirst(".card_info_species_and_other_item span").text().trim()
                    : "";

            String attackText = row.selectFirst(".atk_power span") != null
                    ? row.selectFirst(".atk_power span").text().trim()
                    : "";

            String defenseText = row.selectFirst(".def_power span") != null
                    ? row.selectFirst(".def_power span").text().trim()
                    : "";

            String description = row.selectFirst(".box_card_text") != null
                    ? row.selectFirst(".box_card_text").text().trim()
                    : "";

            String rarity = row.selectFirst(".lr_icon p") != null
                    ? row.selectFirst(".lr_icon p").text().trim()
                    : "";

            String rarityName = row.selectFirst(".lr_icon span") != null
                    ? row.selectFirst(".lr_icon span").text().trim()
                    : "";

            System.out.printf(
                    "%02d cid=%s name=%s ruby=%s type=%s level=%s species=%s atk=%s def=%s rarity=%s rarityName=%s text=%s%n",
                    i + 1,
                    cid,
                    name,
                    ruby,
                    attributeOrType,
                    levelText,
                    speciesText,
                    attackText,
                    defenseText,
                    rarity,
                    rarityName,
                    description
            );
        }
    }
}
