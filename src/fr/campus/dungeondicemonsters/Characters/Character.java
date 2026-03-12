// 'package' : Définit l'adresse du dossier où se trouve ce fichier. Indispensable pour que Java le retrouve.
package fr.campus.dungeondicemonsters.Characters;

// 'import' : Demande à Java d'aller chercher des outils (classes) rangés dans d'autres dossiers pour pouvoir les utiliser ici.
import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.SmokeBomb; // Import spécifique pour la logique Ninja

/**
 * public = la classe est visible et utilisable dans tout le reste du projet.
 * class = c'est le mot-clé qui crée le plan de construction (le "moule").
 * abstract = signifie que ce plan est incomplet. On ne peut pas créer un personnage "vide", il doit être un Guerrier ou un Mage.
 * Il est impossible de créer un simple "Personnage" dans le jeu avec le mot 'new'.
 * Ce fichier sert uniquement de fondation (de classe mère) pour fabriquer des versions concrètes (Guerrier, Mage, Ninja).
 */
public abstract class Character {

    // 1. LES ATTRIBUTS (Privés)
    // 'private' : Concept d'Encapsulation. Ces variables sont verrouillées. Seul le code écrit DANS ce fichier peut les modifier.

    // NOUVEAU : 'id' est le numéro unique (la Clé Primaire) généré par la base de données MariaDB.
    private int id;

    private String name;
    private int life;
    private int attack;
    private int magic;

    // Au lieu d'un simple chiffre, le héros possède un objet complexe (son équipement).
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    // --- 2. LE CONSTRUCTEUR ---
    // C'est la méthode spéciale (qui porte le même nom que la classe) appelée automatiquement quand on fait un 'new'.
    // Les variables entre parenthèses sont les ingrédients obligatoires pour fabriquer l'objet.
    public Character(String name2, int life, int attack, int magic) {
        // 'this' : Signifie "Mon propre attribut à moi".
        // Lecture : "Prends le nom qu'on vient de me donner (à droite), et sauvegarde-le dans ma mémoire interne (à gauche)".
        //dans ce cas de figure le this veux dire "l'objet que je suit "le character que je suis la variable name sera mon nom"
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.magic = magic;
    }

    // 3. LES GETTERS

    // Ce sont des "guichets publics" pour permettre aux autres fichiers de lire nos variables privées.

    // NOUVEAU : Permet à la base de données de connaître l'identifiant du héros pour pouvoir le mettre à jour.
    public int getId() { return id; }


    public String getName() { return name; }
    public int getLife() { return life; }
    public int getAttack() { return attack; }
    public int getMagic() { return magic; }

    // Permet à la base de données (et à Gson) de lire l'arme du personnage
    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    // Permet à la base de données (et à Gson) de lire l'armure/potion du personnage
    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    // 4. LES SETTERS

    // Ce sont des "guichets publics" pour permettre de modifier nos variables privées de manière contrôlée.
    // 'void' : Signifie "Vide". Cette méthode fait une action, mais ne renvoie aucune réponse à la fin.

    // NOUVEAU : Permet à notre code Java de stocker l'ID que MariaDB vient d'attribuer au héros.
    public void setId(int id) { this.id = id; }

    /**
     * Permet de changer l'équipement offensif et d'ajouter le bonus à la bonne stat.
     * @param offensiveEquipment La nouvelle arme ou le nouveau sort (Ceci est lu par l'aide d'IntelliJ).
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;

        // [1] LOGIQUE DE RÉPARTITION DES BONUS
        // 'if' : Si la condition entre parenthèses est vraie.
        // 'instanceof' : Mot-clé posant la question : "Cet objet est-il un enfant de la classe suivante ?"
        if (this instanceof Warrior) {
            // '+=' : Raccourci mathématique. Équivaut à dire : this.attack = this.attack + offensiveEquipment.getBonus()
            this.attack += offensiveEquipment.getBonus();

            // 'else if' : Sinon, si la condition suivante est vraie.
        } else if (this instanceof Wizard) {
            this.magic += offensiveEquipment.getBonus();

        } else if (this instanceof Ninja) {
            // Le Ninja est spécial : si c'est une SmokeBomb, il gagne attaque ET magie
            if (offensiveEquipment instanceof SmokeBomb) {
                this.attack += offensiveEquipment.getBonus();
                // '(SmokeBomb)' : C'est un "Cast". On force Java à considérer l'équipement générique comme une SmokeBomb
                // pour avoir le droit d'utiliser sa méthode spéciale getMagicBonus() qui n'existe que pour les fumigènes.
                this.magic += ((SmokeBomb) offensiveEquipment).getMagicBonus();
                // 'else' : Sinon (pour tous les autres cas restants).
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

    // 5. LA MÉTHODE toString()

    // '@Override' : Annotation signalant à Java que l'on va écraser/remplacer le comportement par défaut de l'affichage en console.
    @Override
    public String toString() {
        // C'est un Opérateur Ternaire (une condition condensée sur une ligne) :
        // (condition) ? résultat_si_vrai : résultat_si_faux;
        // '!=' : Signifie "Différent de".
        // 'null' : Signifie "Le vide absolu en mémoire".
        String armeNom = (offensiveEquipment != null) ? offensiveEquipment.toString() : "Poings nus";
        String defNom = (defensiveEquipment != null) ? defensiveEquipment.toString() : "Aucune protection";

        // On a ajouté 'id' dans l'affichage pour que tu puisses voir le numéro MariaDB de ton héros dans la console !
        return "Personnage [ID " + id + "] : " + name +
                " | PV : " + life +
                " | Attaque : " + attack +
                " | Magie : " + magic +
                "\n  -> Équipé : " + armeNom +
                "\n  -> Défense : " + defNom;
    }
}