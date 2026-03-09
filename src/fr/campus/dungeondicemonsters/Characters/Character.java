package fr.campus.dungeondicemonsters.Characters; // ICI : J'ai mis le grand 'C'

import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.SmokeBomb; // Import spécifique pour la logique Ninja

/**
 * Public = la classe est utilisable dans tout le projet
 * Class = plan de construction "moule"
 * Abstract = On ne peut pas créer un personnage "vide", il doit être un Guerrier ou un Mage
 */
public abstract class Character {

    // --- 1. LES ATTRIBUTS (Privés) ---
    private String name;
    private int life;
    private int attack;
    private int magic;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    // --- 2. LE CONSTRUCTEUR ---
    public Character(String name, int life, int attack, int magic) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.magic = magic;
    }

    // --- 3. LES GETTERS ---
    public String getName() { return name; }
    public int getLife() { return life; }
    public int getAttack() { return attack; }
    public int getMagic() { return magic; }

    // --- 4. LES SETTERS (Mutateurs) ---

    /**
     * Permet de changer l'équipement offensif et d'ajouter le bonus à la bonne stat.
     * @param offensiveEquipment La nouvelle arme ou le nouveau sort.
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;

        // [1] LOGIQUE DE RÉPARTITION DES BONUS
        if (this instanceof Warrior) {
            this.attack += offensiveEquipment.getBonus();
        } else if (this instanceof Wizard) {
            this.magic += offensiveEquipment.getBonus();
        } else if (this instanceof Ninja) {
            // Le Ninja est spécial : si c'est une SmokeBomb, il gagne attaque ET magie
            if (offensiveEquipment instanceof SmokeBomb) {
                this.attack += offensiveEquipment.getBonus();
                this.magic += ((SmokeBomb) offensiveEquipment).getMagicBonus();
            } else {
                // Sinon (Kunai ou Jutsu), on ajoute à l'attaque par défaut
                this.attack += offensiveEquipment.getBonus();
            }
        }
    }

    /**
     * Permet de changer l'équipement défensif du personnage et augmente ses PV.
     * @param defensiveEquipment Le nouveau bouclier ou la nouvelle potion.
     */
    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
        this.life += defensiveEquipment.getHealthBonus();
    }

    public void setLife(int life) {
        this.life = life;
    }

    // --- 5. LA MÉTHODE toString() ---
    @Override
    public String toString() {
        String armeNom = (offensiveEquipment != null) ? offensiveEquipment.toString() : "Poings nus";
        String defNom = (defensiveEquipment != null) ? defensiveEquipment.toString() : "Aucune protection";

        return "Personnage : " + name +
                " | PV : " + life +
                " | Attaque : " + attack +
                " | Magie : " + magic +
                "\n  -> Équipé : " + armeNom +
                "\n  -> Défense : " + defNom;
    }
}