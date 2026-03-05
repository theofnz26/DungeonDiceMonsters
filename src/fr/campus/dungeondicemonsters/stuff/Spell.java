package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;
/**
 * Classe représentant un Sort magique pour les Magiciens.
 * Elle hérite de la classe abstraite OffensiveEquipment.
 */
public class Spell extends OffensiveEquipment {

    /**
     * @param name Nom du sort (ex: "Boule de feu").
     * @param attackLevel Puissance magique du sort.
     */
    public Spell(String name, int attackLevel) {
        // Envoie les informations au constructeur parent
        super(name, attackLevel);
    }
}