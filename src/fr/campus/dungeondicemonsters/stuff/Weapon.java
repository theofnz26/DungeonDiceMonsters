package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;

/**
 * Classe représentant une Arme concrète.
 * Elle hérite (extends) de OffensiveEquipment.
 */
public class Weapon extends OffensiveEquipment {

    public Weapon(String name, int attackLevel) {
        // Envoie les infos au constructeur du parent (super) pour les ranger
        super(name, attackLevel);
    }
}