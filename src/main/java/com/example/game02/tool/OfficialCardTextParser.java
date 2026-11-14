package com.example.game02.tool;

public final class OfficialCardTextParser {

    private OfficialCardTextParser() {}

    public static int parseLevel(String text) {
        return parseTrailingNumber(text, "レベル");
    }

    public static int parseAttack(String text) {
        return parseTrailingNumber(text, "攻撃力");
    }

    public static int parseDefense(String text) {
        return parseTrailingNumber(text, "守備力");
    }

    public static String parseMonsterRaceName(String speciesText) {
        String normalized = normalizeSpeciesText(speciesText);
        String[] parts = normalized.split("／");
        if (parts.length == 0 || parts[0].isBlank()) {
            throw new IllegalArgumentException("Monster race not found: " + speciesText);
        }
        return parts[0].trim();
    }

    public static String parseMonsterKindName(String speciesText) {
        String normalized = normalizeSpeciesText(speciesText);
        String[] parts = normalized.split("／");
        if (parts.length < 2 || parts[1].isBlank()) {
            throw new IllegalArgumentException("Monster kind not found: " + speciesText);
        }
        return parts[1].trim();
    }

    private static int parseTrailingNumber(String text, String label) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(label + " text is blank");
        }

        String normalized = text.replace(label, "").trim();
        return Integer.parseInt(normalized);
    }

    private static String normalizeSpeciesText(String speciesText) {
        if (speciesText == null || speciesText.isBlank()) {
            throw new IllegalArgumentException("Species text is blank");
        }

        return speciesText
                .replace("【", "")
                .replace("】", "")
                .trim();
    }
}
