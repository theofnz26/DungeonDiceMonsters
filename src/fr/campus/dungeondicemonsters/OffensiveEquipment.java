package fr.campus.dungeondicemonsters.stuff;

/**
 * Modèle pour les objets qui augmentent l'Attaque.
 */
public abstract class OffensiveEquipment {
    private String name;
    private int attackBonus; // Le bonus qui s'ajoutera à l'attaque du perso

    public OffensiveEquipment(String name, int attackBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() { return attackBonus; }

    @Override
    public String toString() {
        return name + " (Attaque +" + attackBonus + ")";
    }
}