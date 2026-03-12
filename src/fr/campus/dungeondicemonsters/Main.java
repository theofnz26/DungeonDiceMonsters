package fr.campus.dungeondicemonsters;

// Importation des classes nécessaires
import fr.campus.dungeondicemonsters.Characters.Character;
import fr.campus.dungeondicemonsters.Characters.Ninja;
import fr.campus.dungeondicemonsters.Characters.Warrior;
import fr.campus.dungeondicemonsters.Characters.Wizard;
import fr.campus.dungeondicemonsters.stuff.Weapon;
import fr.campus.dungeondicemonsters.stuff.Shield;
import fr.campus.dungeondicemonsters.stuff.Spell;
import fr.campus.dungeondicemonsters.stuff.Potion;
import fr.campus.dungeondicemonsters.stuff.SmokeBomb;
import fr.campus.dungeondicemonsters.stuff.BlackSuite;


import fr.campus.dungeondicemonsters.db.DatabaseConnection; // lien avec la BDD

// class = plan de constuction



public class Main {
         //static = la classe n'appartien à la class elle meme
    public static void main(String[] args) {
        //Variable Menu -> nommé menu
        Menu menu = new Menu(); //ordonne à l'ordi de créer ce qui suit ex : menu() = l'appel au constructeur

        //  initialisation de l'outil de base de données
        DatabaseConnection db = new DatabaseConnection();

        menu.displayMessage("=== Bienvenue dans Dungeon Dice Monsters ===");
      //comment ce lit ça = menu : utilise l'objet le point "." veut dire rentre dans cet objet et utilise une de ses capacités donc la méthode displayMessage pour afficher une msg



        // --- 1. LECTURE (READ) ---
        menu.displayMessage("\nChargement des personnages par défaut depuis MariaDB...");
        db.getHeroes(); // Cette méthode va se connecter et afficher les 3 personnages !
    //J'utilise la "db" -> ".getHeros execute la méthode qui vas lire MariaDB
        menu.displayMessage("Choisissez votre classe (1: Guerrier, 2: Mage, 3: Ninja) :");
        String choixType = menu.getUserInput();

                        //.getUserInput: l'objet menu utilise "getUserInput()", qui met le programme en pause et récupère ce que l'utilisateur tape


        menu.displayMessage("Entrez le nom de votre héros personnalisé :");
        String nomChoisi = menu.getUserInput();


        // wwww   LA CRÉATION DU PERSO   wwww

        Character monHeros = null;

        /**Explication du ".equals" SUPER IMPORTANT !!!!!
         Pourquoi utliser equal au lieu de "==" en Java pour les objet ( le texte "String" est un objet en Java), le signe == ne regarde pas le texte mais,
         regarde l'adresse mémoire. il vérifie si c'est exactement la même boîte physique dans la mémoire RAM donc exemple
         si je prend une carte de TCG imaginons que je puisse avoir un dracofeu == me dit qu'il me faut strictement le meme que ce soit la meme carte un clone le meme carton alors que
         si je n'ai pas ce dracofeu et que pour m'entrainer je decide de prendre une autre carte et je considère que c'est le dracofeu que j'ai besoin psk j'ai ecrit dracofeu dessu
         alors .equals me permet de me dire que ce sont les meme cartes
         */

        if (choixType.equals("1")) {
            monHeros = new Warrior(nomChoisi);
            monHeros.setOffensiveEquipment(new Weapon("Épée en bois", 2));
            monHeros.setDefensiveEquipment(new Shield("Petit bouclier", 1));

        } else if (choixType.equals("2")) {
            monHeros = new Wizard(nomChoisi);
            monHeros.setOffensiveEquipment(new Spell("Boule de feu", 3));
            monHeros.setDefensiveEquipment(new Potion("Potion mineure", 2, false));

        } else if (choixType.equals("3")) {
            monHeros = new Ninja(nomChoisi);
            monHeros.setOffensiveEquipment(new SmokeBomb("Fumigène", 1, 2));
            monHeros.setDefensiveEquipment(new BlackSuite("Tenue de l'ombre", 3));

        } else {
            menu.displayMessage("Choix invalide, un Guerrier par défaut a été créé.");
            monHeros = new Warrior(nomChoisi);
            monHeros.setOffensiveEquipment(new Weapon("Épée rouillée", 1));
        }

        menu.displayMessage("\nFélicitations ! Voici votre personnage :");
        menu.displayMessage(monHeros.toString());

        //2. ÉCRITURE (CREATE)
        menu.displayMessage("\nSauvegarde de votre héros personnalisé en base de données...");
        db.createHero(monHeros); // Gson va transformer l'équipement en texte et le sauvegarder


        // === LE LANCEMENT DU MOTEUR DE JEU ===


        menu.displayMessage("\nAppuyez sur Entrée pour commencer l'aventure !");
        menu.getUserInput();

        Game game = new Game();
        boolean partieEnCours = true;

        while (partieEnCours) {
            menu.displayMessage("\n--- NOUVEAU TOUR ---");
            menu.displayMessage("Tapez '1' pour lancer le dé, ou 'q' pour quitter :");
            String action = menu.getUserInput();

            if (action.equalsIgnoreCase("q")) {
                menu.displayMessage("Vous fuyez le donjon lâchement... Fin de la partie.");
                partieEnCours = false;
            } else {
                try {
                    game.playTurn(monHeros);
                } catch (OutOfBoardException e) {
                    menu.displayMessage(e.getMessage());
                    partieEnCours = false;
                }
            }
        }

        menu.closeMenu();
    }
}