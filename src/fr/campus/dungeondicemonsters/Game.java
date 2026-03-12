package fr.campus.dungeondicemonsters;

import fr.campus.dungeondicemonsters.Characters.Character;

public class Game {

    // --- 1. LES ATTRIBUTS ---
    private Board board; // Le plateau de jeu
    private int playerPosition; // La position actuelle du joueur

    // --- 2. LE CONSTRUCTEUR ---
    public Game() {
        this.board = new Board(); // Génère les 64 cases
        this.playerPosition = 1; // Le joueur commence sur la case 1
    }

    // --- 3. LE MOTEUR DE JEU ---
    /**
     * Méthode qui gère un tour complet du joueur.
     * @param perso Le personnage joué.
     * @throws OutOfBoardException Si le joueur dépasse la case finale.
     */
    public void playTurn(Character perso) throws OutOfBoardException {

        // 1. Lancer le dé (de 1 à 6)
        int dice = (int) (Math.random() * 6) + 1;

        // 2. Calculer la future case
        int futurePosition = this.playerPosition + dice;

        // 3. Vérifier la condition de victoire (Sortie du plateau)
        if (futurePosition > 64) {
            throw new OutOfBoardException("Victoire absolue ! " + perso.getName() + " a dépassé la case 64 et triomphe du donjon !");
        }

        // 4. Valider le déplacement
        this.playerPosition = futurePosition;

        // 5. Afficher les informations de base
        System.out.println("--------------------------------------------------");
        System.out.println(perso.getName() + " lance le dé et fait un " + dice + " !");
        System.out.println("Vous avancez sur la case " + this.playerPosition + " / 64");

        // 6. INTERACTION AVEC LE PLATEAU (La nouveauté)
        // On demande au plateau de nous donner le contenu de la case actuelle
        Cell caseActuelle = this.board.getCell(this.playerPosition);

        // On affiche ce qu'il y a sur la case grâce au toString()
        System.out.println(caseActuelle.toString());
    }
}