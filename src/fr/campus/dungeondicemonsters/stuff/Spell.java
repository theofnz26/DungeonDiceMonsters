package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant un Sort magique.
 * C'est l'équipement offensif le plus puissant du Wizard (+4).
 */
public class Spell extends OffensiveEquipment {

    /**
     * @param name Le nom du sort (ex: "Boule de feu").
     * @param magicLevel La puissance du sort.
     */
    public Spell(String name, int magicLevel) {
        // super envoie les informations au constructeur parent OffensiveEquipment.
        super(name, magicLevel);
    }
}