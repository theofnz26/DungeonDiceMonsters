package fr.campus.dungeondicemonsters.stuff;

/**
 * Modèle pour les objets qui augmentent la force de frappe (Attaque ou Magie). [cite: 61, 235]
 */
public abstract class OffensiveEquipment {
    // --- 1. LES ATTRIBUTS (Privés) ---
    private String name;
    private int bonus; // [1] Le bonus qui s'ajoutera à la stat principale du perso

    // --- 2. LE CONSTRUCTEUR ---
    public OffensiveEquipment(String name, int bonus) {
        this.name = name; // On range le nom
        this.bonus = bonus; // On range la puissance
    }

    // --- 3. LE GETTER ---
    /**
     * Permet de récupérer la valeur du bonus.
     * @return la valeur numérique du bonus.
     */
    public int getBonus() {
        return bonus;
    }

    // --- 4. LA MÉTHODE toString() ---
    @Override
    public String toString() {
        // On utilise un affichage neutre car cela peut être de l'attaque ou de la magie
        return name + " (Puissance +" + bonus + ")";
    }
}