package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;
/**
 * Classe représentant une Potion de soin ou de protection.
 * Elle hérite de la classe abstraite DefensiveEquipment.
 */
public class Potion extends DefensiveEquipment {

    /**
     * @param name Nom de la potion (ex: "Potion de vie").
     * @param defenseLevel Points de soin ou de défense apportés.
     */
    public Potion(String name, int defenseLevel) {
        // Appel direct au constructeur de la classe mère
        super(name, defenseLevel);
    }
}