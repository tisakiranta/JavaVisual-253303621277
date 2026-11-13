
package com.unpri.charactermanager.model;

public class Character {

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;

    // Constructor pertama
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
    }

    // Constructor kedua
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
    }

    // Menghitung HP
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    // Menghitung Attack
    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Setter ID
    public void setId(int id) {
        this.id = id;
    }

    // Setter Level
    public void setLevel(int level) {

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{id=" + id
                + ", name='" + name + '\''
                + ", type=" + type
                + ", level=" + level
                + ", hp=" + hitPoints
                + ", atk=" + attackPower
                + '}';
    }

    // Membandingkan nama karakter
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return this.name.equals(other.name);
    }
}
