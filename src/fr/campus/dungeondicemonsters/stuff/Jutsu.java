package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant un Jutsu pour le Ninja.
 * Il augmente la statistique de magie.
 */
public class Jutsu extends OffensiveEquipment {

    /**
     * @param name Le nom du Jutsu (ex: "Technique de la boule de feu").
     * @param magicLevel Le bonus de magie (+4).
     */
    public Jutsu(String name, int magicLevel) {
        // super transmet les infos au constructeur de OffensiveEquipment
        super(name, magicLevel);
    }
}