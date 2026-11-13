
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

import java.util.ArrayList;
import java.util.Locale;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private double averageLevel;

    // Constructor
    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager v0.3");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Membuat komponen GUI
    private void initComponents() {

        mainPanel = new JPanel();

        // Menyusun komponen secara vertikal
        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Judul
        JLabel titleLabel = new JLabel(
                "=== Daftar Karakter ("
                + characterList.size() + ") ==="
        );

        mainPanel.add(titleLabel);

        // Garis kosong
        mainPanel.add(new JLabel(" "));

        // Menampilkan karakter secara dinamis
        for (Character c : characterList) {

            String info = c.getName()
                    + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            mainPanel.add(characterLabel);
        }

        // Jarak sebelum statistik
        mainPanel.add(new JLabel(" "));

        // Statistik rata-rata level
        JLabel statisticLabel = new JLabel(
                "Rata-rata Level: "
                + String.format(Locale.US, "%.1f", averageLevel)
        );

        mainPanel.add(statisticLabel);

        // Masukkan panel ke jendela
        add(mainPanel);
    }
}
