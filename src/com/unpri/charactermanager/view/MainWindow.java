
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Locale;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class MainWindow extends JFrame {

    private ArrayList<Character> characterList;
    private double averageLevel;

    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager v0.5");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        // Ukuran awal aplikasi
setSize(950, 620);

// Ukuran terkecil aplikasi
setMinimumSize(new Dimension(500, 300));

// Mengizinkan jendela diperbesar dan diperkecil
setResizable(true);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
    }

    private void initComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.PANEL_BORDER);

        // NORTH: HEADER
        JPanel headerPanel = new JPanel(new BorderLayout(10, 12));
        headerPanel.setBackground(AppTheme.BG_MAIN);

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER - DAFTAR KARAKTER"
        );

        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.GOLD);

        headerPanel.add(titleLabel, BorderLayout.NORTH);

        // Statistik GridLayout 2 x 2
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 10, 8));
        statsPanel.setBackground(AppTheme.BG_PANEL);
        statsPanel.setBorder(
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
        );

        int highLevelCount = 0;

        for (Character c : characterList) {
            if (c.getLevel() >= 5) {
                highLevelCount++;
            }
        }

        addStyledStat(statsPanel,
                "Total Karakter: " + characterList.size());

        addStyledStat(statsPanel,
                "Rata-rata Level: "
                + String.format(Locale.US, "%.1f", averageLevel));

        addStyledStat(statsPanel,
                "Level Tinggi: " + highLevelCount);

        addStyledStat(statsPanel,
                "Jenis Karakter: " + CharacterType.values().length);

        headerPanel.add(statsPanel, BorderLayout.CENTER);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // CENTER: DAFTAR KARAKTER
        JPanel characterPanel = new JPanel(
                new GridLayout(0, 1, 0, 10)
        );

        characterPanel.setBackground(AppTheme.BG_MAIN);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        for (Character c : characterList) {

            String info = c.getName()
                    + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            characterLabel.setOpaque(true);
            characterLabel.setBackground(
                    AppTheme.colorFor(c.getType())
            );
            characterLabel.setForeground(AppTheme.TEXT_LIGHT);
            characterLabel.setFont(AppTheme.FONT_BOLD);
            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

            characterPanel.add(characterLabel);
        }

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(AppTheme.BG_MAIN);
        wrapperPanel.add(characterPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setPreferredSize(new Dimension(650, 350));
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.setBorder(
                BorderFactory.createLineBorder(AppTheme.GOLD)
        );

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // EAST: LEGEND
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(
                new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.BG_PANEL);
        legendPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(AppTheme.GOLD),
                        "Legend Karakter",
                        0,
                        0,
                        AppTheme.FONT_BOLD,
                        AppTheme.GOLD
                )
        );

        legendPanel.add(Box.createVerticalStrut(12));

        for (CharacterType type : CharacterType.values()) {

            JLabel typeLabel = new JLabel(type.toString());

            typeLabel.setOpaque(true);
            typeLabel.setBackground(AppTheme.colorFor(type));
            typeLabel.setForeground(AppTheme.TEXT_LIGHT);
            typeLabel.setFont(AppTheme.FONT_BOLD);
            typeLabel.setAlignmentX(LEFT_ALIGNMENT);
            typeLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
            );

            legendPanel.add(typeLabel);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());
        mainPanel.add(legendPanel, BorderLayout.EAST);

        // SOUTH: STATUS BAR
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(AppTheme.BG_PANEL);
        statusPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 5, 5, 5)
        );

        JLabel statusLabel = new JLabel(
                "Status: Menampilkan "
                + characterList.size()
                + " karakter"
        );

        JLabel versionLabel = new JLabel("v0.5");

        statusLabel.setForeground(AppTheme.TEXT_MAIN);
        versionLabel.setForeground(AppTheme.GOLD);

        statusLabel.setFont(AppTheme.FONT_BODY);
        versionLabel.setFont(AppTheme.FONT_BOLD);

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private void addStyledStat(JPanel panel, String text) {

        JLabel label = new JLabel(text);
        label.setForeground(AppTheme.TEXT_MAIN);
        label.setFont(AppTheme.FONT_BOLD);

        panel.add(label);
    }
}
