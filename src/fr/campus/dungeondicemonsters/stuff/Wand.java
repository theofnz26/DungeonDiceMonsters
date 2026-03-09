package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant une Baguette magique.
 * Elle donne un bonus de +2.
 */
public class Wand extends OffensiveEquipment {

    public Wand(String name, int magicLevel) {
        // super transmet le nom et le bonus (+2) au parent
        super(name, magicLevel);
    }
}