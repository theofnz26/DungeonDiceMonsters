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
import fr.campus.dungeondicemonsters.stuff.Kunai;
import fr.campus.dungeondicemonsters.stuff.SmokeBomb;
import fr.campus.dungeondicemonsters.stuff.BlackSuite; // Ajouté pour donner une vraie défense au Ninja

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.displayMessage("=== Bienvenue dans Dungeon Dice Monsters ===");
        menu.displayMessage("Choisissez votre classe (1: Guerrier, 2: Mage, 3: Ninja) :");
        String choixType = menu.getUserInput();

        menu.displayMessage("Entrez le nom de votre héros :");
        String nomChoisi = menu.getUserInput();

        Character monHeros = null;

        if (choixType.equals("1")) {
            monHeros = new Warrior(nomChoisi);
            monHeros.setOffensiveEquipment(new Weapon("Épée en bois", 2));
            monHeros.setDefensiveEquipment(new Shield("Petit bouclier", 1));

        } else if (choixType.equals("2")) {
            monHeros = new Wizard(nomChoisi);
            monHeros.setOffensiveEquipment(new Spell("Boule de feu", 3));
            // CORRECTION : La potion demande maintenant 3 informations, dont un vrai/faux à la fin
            monHeros.setDefensiveEquipment(new Potion("Potion mineure", 2, false));

        } else if (choixType.equals("3")) {
            monHeros = new Ninja(nomChoisi);
            // CORRECTION : La SmokeBomb demande maintenant un nom, un bonus attaque ET un bonus magie
            monHeros.setOffensiveEquipment(new SmokeBomb("Fumigène", 1, 2));
            // CORRECTION : La SmokeBomb étant offensive, on donne une vraie armure au Ninja pour sa défense
            monHeros.setDefensiveEquipment(new BlackSuite("Tenue de l'ombre", 3));

        } else {
            menu.displayMessage("Choix invalide, un Guerrier par défaut a été créé.");
            monHeros = new Warrior(nomChoisi);
            monHeros.setOffensiveEquipment(new Weapon("Épée rouillée", 1));
        }

        menu.displayMessage("\nFélicitations ! Voici votre personnage :");
        menu.displayMessage(monHeros.toString());

        // =========================================================
        // === NOUVELLE PARTIE : LE LANCEMENT DU MOTEUR DE JEU ===
        // =========================================================

        menu.displayMessage("\nAppuyez sur Entrée pour commencer l'aventure !");
        menu.getUserInput(); // Fait une pause en attendant la touche Entrée

        // 1. On allume le moteur (Création du plateau et du pion)
        Game game = new Game();

        // 2. On crée une étiquette qui dit que la partie est en cours
        boolean partieEnCours = true;

        // 3. LA BOUCLE DE JEU (Game Loop)
        // Tant que "partieEnCours" est Vrai, on répète ce bloc de code à l'infini
        while (partieEnCours) {
            menu.displayMessage("\n--- NOUVEAU TOUR ---");
            menu.displayMessage("Tapez '1' pour lancer le dé, ou 'q' pour quitter :");
            String action = menu.getUserInput();

            if (action.equalsIgnoreCase("q")) {
                // Si le joueur tape 'q', on change l'étiquette en Faux.
                // La boucle va s'arrêter et le jeu se termine.
                menu.displayMessage("Vous fuyez le donjon lâchement... Fin de la partie.");
                partieEnCours = false;
            } else {

                // [NOUVEAU] LE FILET DE SÉCURITÉ (try / catch)
                try {
                    // On "essaye" de faire jouer un tour.
                    // Si le joueur dépasse 64, cette ligne déclenche l'alarme et le code saute directement au "catch"
                    game.playTurn(monHeros);

                } catch (OutOfBoardException e) {
                    // SI l'alarme sonne, on l'attrape ici !

                    // On affiche proprement le message de l'erreur (ex: "Victoire ! ... a dépassé la case 64")
                    menu.displayMessage(e.getMessage());

                    // On change l'étiquette pour arrêter la boucle et terminer la partie
                    partieEnCours = false;
                }
            }
        }

        // On ferme proprement le scanner à la toute fin du programme
        menu.closeMenu();
    }
}