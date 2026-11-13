package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    public static final Color BG_MAIN = Color.decode("#13131f");
    public static final Color TEXT_MAIN = Color.decode("#dfe6e9");
    public static final Color TEXT_LIGHT = Color.WHITE;
    public static final Color GOLD = Color.decode("#fdcb6e");

    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    public static final Border PANEL_BORDER =
            BorderFactory.createEmptyBorder(16, 16, 16, 16);

    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);

    public static final int HIGH_LEVEL_THRESHOLD = 5;

    private AppTheme() {
    }

    public static Color colorFor(CharacterType type) {
        switch (type) {
            case WARRIOR:
                return Color.decode("#d63031");
            case MAGE:
                return Color.decode("#0984e3");
            case ARCHER:
                return Color.decode("#00b894");
            case HEALER:
                return Color.decode("#6c5ce7");
            default:
                return Color.GRAY;
        }
    }

    public static String describe(CharacterType type) {
        switch (type) {
            case WARRIOR:
                return "Warrior: petarung jarak dekat";
            case MAGE:
                return "Mage: pengguna kekuatan sihir";
            case ARCHER:
                return "Archer: penyerang jarak jauh";
            case HEALER:
                return "Healer: karakter pendukung dan penyembuh";
            default:
                return "Role belum terdaftar";
        }
    }
}