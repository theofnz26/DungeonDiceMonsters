package fr.campus.dungeondicemonsters.stuff;

/**
 * Classe représentant un Kunai.
 * Il augmente la statistique d'attaque physique.
 */
public class Kunai extends OffensiveEquipment {

    public Kunai(String name, int attackLevel) {
        // Envoie le nom et le bonus (+3) au parent
        super(name, attackLevel);
    }
}