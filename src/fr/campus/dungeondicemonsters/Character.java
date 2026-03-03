package fr.campus.dungeondicemonsters; //indique dans quelle "dossier" vituel se trouve le fichier

public class Character { // Public = la classe est utilisable dans tout le projet
                         // Class = plan de construction "moule"

    // --- 1. LES ATTRIBUTS (Privés) ---
    // C'est la carte d'identité du personnage. Personne ne peut les modifier directement de l'extérieur.
    private String name;
    private int life;
    private int attack;
    private int magic;

    // --- 2. LE CONSTRUCTEUR ---
    // C'est la méthode spéciale qui "fabrique" le personnage au début de la partie.
    public Character(String name, int life, int attack, int magic) {
        this.name = name;   //// THIS = Mot clé qui signifie "celui-ci"
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

    // --- 4. LES SETTERS (Mutateurs) = Pendant un combat, les perso vont perdre des Pv.
    // Il faut donc pouvoir modif la variable life.Les attributs ne seront approchés que par le biais des getters et setter
    // Ce sont nos "portes d'écriture". Ils permettent de modifier les stats en cours de partie (ex: prendre un coup).
    public void setLife(int life) {
        this.life = life;
    }
    // --- 5. LA MÉTHODE toString() ---
    // Cette méthode est appelée automatiquement quand on veut afficher l'objet sous forme de texte.
    @Override //L'annotation @Override est une étiquette de sécurité qui indique à Java que l'on remplace volontairement une méthode héritée de la classe mère par notre propre version.
    public String toString() {
        return "Personnage : " + name +
                " | PV : " + life +
                " | Attaque : " + attack +
                " | Magie : " + magic;
    }
    // Note : pas de setter pour le 'name' car le nom d'un personnage change pas en plein milieu du jeu !
}