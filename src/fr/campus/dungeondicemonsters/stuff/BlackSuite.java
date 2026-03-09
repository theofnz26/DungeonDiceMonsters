package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant la tenue noire classique du Ninja.
 * Elle augmente les PV de +3.
 */
public class BlackSuite extends DefensiveEquipment {

    public BlackSuite(String name, int healthLevel) {
        // super transmet le nom et le bonus (+3) au parent DefensiveEquipment
        super(name, healthLevel);
    }
}