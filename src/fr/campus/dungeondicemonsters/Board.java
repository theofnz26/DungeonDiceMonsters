package fr.campus.dungeondicemonsters;

import java.util.ArrayList; // L'outil pour faire des listes
import fr.campus.dungeondicemonsters.stuff.*; // Importe tout le stuff

public class Board {

    // --- L'ATTRIBUT ---
    private ArrayList<Cell> cases; // La liste qui contient les 64 cases

    // --- LE CONSTRUCTEUR ---
    public Board() {
        this.cases = new ArrayList<>(); // On fabrique la liste vide
        genererPlateau(); // On appelle la méthode pour remplir les 64 cases
    }

    private void genererPlateau() {
        // [1] On boucle de 1 à 64 pour créer les cases
        for (int i = 1; i <= 64; i++) {

            // Pour l'instant, on met des cases simples (on pourra ajouter l'aléatoire après)
            if (i % 10 == 0) {
                cases.add(new EnemyCell("Case " + i, "Gobelin")); // Un ennemi toutes les 10 cases
            } else if (i == 5) {
                cases.add(new BonusCell("Case " + i, new Potion("Potion de vie", 5, false)));
            } else {
                // Par défaut, la case est vide (on peut créer une classe EmptyCell plus tard)
                // Pour l'instant, on utilise une description simple
            }
        }
    }

    // --- LE GETTER ---
    public Cell getCell(int position) {
        // [2] On récupère la case. Attention : la liste commence à 0, pas à 1 !
        return cases.get(position - 1);
    }
}