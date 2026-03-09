package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant une plaque d'armure lourde pour le Ninja.
 * Elle augmente les PV de +5.
 */
public class ArmorPlate extends DefensiveEquipment {

    public ArmorPlate(String name, int healthLevel) {
        // super transmet le nom et le bonus (+5) au parent DefensiveEquipment
        super(name, healthLevel);
    }
}