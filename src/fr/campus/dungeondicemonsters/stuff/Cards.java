package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant des Cartes de sort.
 * Elle donne un bonus de +1.
 */
public class Cards extends OffensiveEquipment {

    public Cards(String name, int magicLevel) {
        // super transmet le nom et le bonus (+1) au parent
        super(name, magicLevel);
    }
}