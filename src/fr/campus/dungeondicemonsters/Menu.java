package fr.campus.dungeondicemonsters;

// cela importe l'outil natif de Java permettant de lire les flux de données
import java.util.Scanner;

public class Menu {

    // --- 1. L'ATTRIBUT (Privé) ---
    // Notre menu possède un outil de lecture. On l'encapsule en 'private'.
    private Scanner scanner;
            //Scanner est un outil natif de jave dont le but est de lire les flux de données "exemple toucher une touche du clavier"
            //scanner avec en minuscule est le nom que je donne a ma variable c'est le nom de cette boite "Scanner"



    // --- 2. LE CONSTRUCTEUR ---
    // Quand on instancie le Menu avec 'new', on prépare immédiatement le lecteur.
    public Menu() {
        // System.in est le flux d'entrée standard (le clavier), l'inverse de System.out (l'écran)
        this.scanner = new Scanner(System.in);
    }

    // --- 3. LES MÉTHODES D'AFFICHAGE ET DE LECTURE ---

    // Cette méthode centralise tous les affichages du jeu.
    // Plus besoin de taper System.out.println partout dans les autres classes !
    public void displayMessage(String message) {
        System.out.println(message);
    }
                             //-> argument on définit que pour utiliser cette méthode il faut fournir oblig du string "nommé temporairement message"


    // Cette méthode met le programme en pause et attend que le joueur tape sur "Entrée".
    // Elle renvoie ensuite le texte tapé sous forme de String.
    public String getUserInput() {
        return this.scanner.nextLine();
    }
    //methode renvoie du texte
    // .nextLine() : C'est une commande spécifique du Scanner.
    // Elle dit à Java : "Mets le programme en pause et attends que l'utilisateur tape quelque chose sur son clavier et appuie sur la touche Entrée".
    // Elle récupère tout ce qui a été tapé sous forme de texte.


    // Bonne pratique : une méthode pour libérer la mémoire quand le jeu est terminé.
    public void closeMenu() {
        this.scanner.close();
    }
}                         //.close, c'est la commande qui dit a java de libérer le flux "lien" avec le clavier