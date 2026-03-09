package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant des bandages de protection.
 * Elle augmente les PV de +2.
 */
public class Bandage extends DefensiveEquipment {

    public Bandage(String name, int healthLevel) {
        // super transmet le nom et le bonus (+2) au parent DefensiveEquipment
        super(name, healthLevel);
    }
}
