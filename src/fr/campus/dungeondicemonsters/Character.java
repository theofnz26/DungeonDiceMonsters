package fr.campus.dungeondicemonsters; //indique dans quelle "dossier" vituel se trouve le fichier

import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;

/**
 * Public = la classe est utilisable dans tout le projet [cite: 22]
 * Class = plan de construction "moule"
 * Abstract = On ne peut pas créer un personnage "vide", il doit être un Guerrier ou un Mage [cite: 3, 5]
 */
public abstract class Character {

    // --- 1. LES ATTRIBUTS (Privés) ---
    // C'est la carte d'identité du personnage. Personne ne peut les modifier directement de l'extérieur. [cite: 23]
    private String name;
    private int life;
    private int attack;
    private int magic;
    private OffensiveEquipment offensiveEquipment; // Emplacement pour l'arme ou le sort [cite: 23]
    private DefensiveEquipment defensiveEquipment; // Emplacement pour le bouclier ou la potion [cite: 23]

    // --- 2. LE CONSTRUCTEUR ---
    // C'est la méthode spéciale qui "fabrique" le personnage au début de la partie.
    public Character(String name, int life, int attack, int magic) {
        this.name = name;   // THIS = Mot clé qui signifie "celui-ci"
        // la ligne ce lit = Prends l'attribut "name" de ce perso prècis (This.name), et mets dedans la valeur donner en paramètre (= name)
        this.life = life;
        this.attack = attack;
        this.magic = magic;
    }

    // --- 3. LES GETTERS  = étant donné que les attribus sont verrouillés avec "private", les autres classes (comme le plateau du jeu) sont aveugles.
    // On crée la méthode public pour les rendre visible et pouvoir recup les info
    // Ce sont nos "portes de lecture". Ils permettent aux autres classes de consulter les stats.
    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagic() {
        return magic;
    }

    // --- 4. LES SETTERS (Mutateurs) = Pendant un combat, les perso vont perdre des Pv. [cite: 87]
    // Il faut donc pouvoir modif la variable life. Les attributs ne seront approchés que par le biais des getters et setter
    // Ce sont nos "portes d'écriture". Ils permettent de modifier les stats en cours de partie (ex: prendre un coup).

    /**
     * Permet de changer l'équipement offensif du personnage et augmente son attaque.
     * @param offensiveEquipment La nouvelle arme ou le nouveau sort.
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
        // On ajoute le bonus de l'équipement directement à la statistique d'attaque du perso
        this.attack += offensiveEquipment.getAttackBonus();
    }

    /**
     * Permet de changer l'équipement défensif du personnage et augmente ses PV.
     * @param defensiveEquipment Le nouveau bouclier ou la nouvelle potion.
     */
    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
        // On ajoute le bonus de l'équipement directement aux points de vie (life) du perso
        this.life += defensiveEquipment.getHealthBonus();
    }

    public void setLife(int life) {
        this.life = life;
    }

    // --- 5. LA MÉTHODE toString() ---
    // Cette méthode est appelée automatiquement quand on veut afficher l'objet sous forme de texte. [cite: 8, 24]
    @Override //L'annotation @Override est une étiquette de sécurité qui indique à Java que l'on remplace volontairement une méthode héritée de la classe mère par notre propre version.
    public String toString() {
        // On vérifie si l'équipement existe pour éviter d'afficher "null"
        String armeNom = (offensiveEquipment != null) ? offensiveEquipment.toString() : "Poings nus";
        String defNom = (defensiveEquipment != null) ? defensiveEquipment.toString() : "Aucune protection";

        return "Personnage : " + name +
                " | PV : " + life +
                " | Attaque : " + attack +
                " | Magie : " + magic +
                "\n  -> Équipé : " + armeNom +
                "\n  -> Défense : " + defNom;
    }
    // Note : pas de setter pour le 'name' car le nom d'un personnage change pas en plein milieu du jeu !
}