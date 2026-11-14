package com.example.game02.tool;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Vol1CardHtmlDownloadTool {
  private static final String VOL1_URL =
      "https://www.db.yugioh-card.com/yugiohdb/card_search.action?ope=1&sess=1&pid=1101000&rp=99999&request_locale=ja";

  public static void main(String[] args) throws Exception {
    Document document = Jsoup.connect(VOL1_URL).userAgent("Mozilla/5.0").timeout(10_000).get();

    Path outputPath = Path.of("tmp", "vol1.html");
    Files.createDirectories(outputPath.getParent());
    Files.writeString(outputPath, document.outerHtml(), StandardCharsets.UTF_8);

    System.out.println("Saved: " + outputPath.toAbsolutePath());
    System.out.println("Title: " + document.title());
  }
}
