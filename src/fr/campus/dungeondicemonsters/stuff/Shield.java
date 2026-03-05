package fr.campus.dungeondicemonsters.stuff;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;
/**
 * Classe représentant un Bouclier concret.
 * Elle hérite (extends) de DefensiveEquipment.
 */
public class Shield extends DefensiveEquipment {

    public Shield(String name, int defenseLevel) {
        // super = appel direct au constructeur de la classe mère
        super(name, defenseLevel);
    }
}