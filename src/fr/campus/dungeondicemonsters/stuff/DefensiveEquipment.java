package fr.campus.dungeondicemonsters.stuff;

/**
 * Modèle pour les objets qui augmentent les PV.
 */
public abstract class DefensiveEquipment {
    private String name;
    private int healthBonus; // Le bonus qui s'ajoutera aux PV du perso

    public DefensiveEquipment(String name, int healthBonus) {
        this.name = name;
        this.healthBonus = healthBonus;
    }

    public int getHealthBonus() { return healthBonus; }

    @Override
    public String toString() {
        return name + " (PV +" + healthBonus + ")";
    }
}