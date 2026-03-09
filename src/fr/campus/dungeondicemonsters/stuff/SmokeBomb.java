package fr.campus.dungeondicemonsters.stuff;

public class SmokeBomb extends OffensiveEquipment {
    private int magicBonus; // [2]

    public SmokeBomb(String name, int attackLevel, int magicLevel) {
        super(name, attackLevel);
        this.magicBonus = magicLevel;
    }

    public int getMagicBonus() {
        return magicBonus;
    }
}