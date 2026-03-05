package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;

/**
 * Classe représentant un Kunai, l'arme de jet préférée du Ninja.
 * Elle hérite de OffensiveEquipment pour ajouter des dégâts d'attaque.
 */
public class Kunai extends OffensiveEquipment {

    /**
     * @param name le nom du Kunai (ex: "Kunai d'acier").
     * @param attackLevel les dégâts bonus.
     */
    public Kunai(String name, int attackLevel) {
        // super transmet les infos au constructeur de OffensiveEquipment
        super(name, attackLevel);
    }
}