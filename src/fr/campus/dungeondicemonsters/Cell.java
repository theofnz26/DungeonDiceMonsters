package fr.campus.dungeondicemonsters;

/**
 * La classe Cell représente une case du plateau de jeu.
 * Elle est abstract car une case "toute seule" n'existe pas,
 * elle sera soit vide, soit avec un ennemi, soit avec un bonus.
 */
public abstract class Cell {
//'utilise "abstract" parcque je ne veux pas créer une case "generique"




 // --- 1. L'ATTRIBUT (Privé) ---
    // Chaque case a un nom ou une description (ex: "Case Vide" ou "Dragon").
    private String description;

    // --- 2. LE CONSTRUCTEUR ---
    // Sert à fabriquer la case en lui donnant un nom.
    public Cell(String description) {
        this.description = description; // On range le nom reçu dans la variable privée.
    }

    // --- 3. LE GETTER ---
    // Permet aux autres classes (comme la classe Game) de lire le nom de la case.
    public String getDescription() {
        return description;
    }

    // --- 4. LA MÉTHODE toString() ---
    // Permet d'afficher directement la case dans la console.
    @Override
    public String toString() {
        return "Vous êtes sur : " + description;
    }
}