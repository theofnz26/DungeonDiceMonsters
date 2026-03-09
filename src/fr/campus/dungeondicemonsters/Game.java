package fr.campus.dungeondicemonsters;

import fr.campus.dungeondicemonsters.Characters.Character;

public class Game {

    private Board board;
    private int playerPosition;

    public Game() {
        this.board = new Board();
        this.playerPosition = 1;
    }

    /**
     * Cette méthode fait jouer un tour au personnage.
     * @param perso Le personnage du joueur.
     * @throws OutOfBoardException Si le joueur dépasse la case 64.
     */
    // [1] On ajoute "throws" à la signature de la méthode
    public void playTurn(Character perso) throws OutOfBoardException {

        // Lancer de dé aléatoire (de 1 à 6)
        int dice = (int) (Math.random() * 6) + 1;

        // On calcule la future position (sans y aller tout de suite)
        int futurePosition = this.playerPosition + dice;

        // [2] On vérifie si la future position sort du plateau
        if (futurePosition > 64) {
            // [3] On DÉCLENCHE l'alarme (l'Exception)
            throw new OutOfBoardException("Victoire ! " + perso.getName() + " a dépassé la case 64 et sort du donjon !");
        }

        // Si l'alarme n'a pas sonné, on valide le déplacement
        this.playerPosition = futurePosition;

        System.out.println("--------------------------------------------------");
        System.out.println(perso.getName() + " lance le dé et fait un " + dice + " !");
        System.out.println("Vous avancez sur la case " + this.playerPosition + " / 64");
    }
}