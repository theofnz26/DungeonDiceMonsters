package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;

/**
 * Classe représentant une Bombe Fumigène.
 * Elle hérite de DefensiveEquipment car elle sert à réduire les dégâts reçus.
 */
public class SmokeBomb extends DefensiveEquipment {

    /**
     * @param name le nom de l'objet (ex: "Fumigène de l'ombre").
     * @param defenseLevel le niveau de protection apporté.
     */
    public SmokeBomb(String name, int defenseLevel) {
        // super transmet les infos au constructeur de DefensiveEquipment
        super(name, defenseLevel);
    }
}