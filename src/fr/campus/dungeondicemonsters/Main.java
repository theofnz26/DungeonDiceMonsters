package fr.campus.dungeondicemonsters;

// Importation des équipements depuis le sous-dossier stuff
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

public class Main {

    public static void main(String[] args) {
        // 1. On prépare notre outil de communication
        Menu menu = new Menu();
        //Menu (le premier) : C'est le Type. je dis à Java que la variable va contenir un objet construit selon le plan de la classe Menu
        //menu (le deuxième) : C'est le Nom (l'identifiant). C'est l'étiquette que je colles sur mon objet pour l'appeler plus tard
        //Menu() : C'est l'appel au Constructeur. Il exécute le code à l'intérieur de la classe Menu (qui prépare le Scanner).


        //menu = fait reference à la ligne 7 le menu que j'ai creer a ce moment la "c'est le menu précis que j'ai frabriqué pour une nouvelle partie
        menu.displayMessage("=== Bienvenue dans Dungeon Dice Monsters ===");
        //displayMessage = méthode créée dans la clase menu pour retourné un msg
        // 2. On demande le type de personnage
        menu.displayMessage("Choisissez votre classe (1: Guerrier, 2: Mage, 3: Ninja) :");
        String choixType = menu.getUserInput();

        // 3. On demande le nom
        menu.displayMessage("Entrez le nom de votre héros :");
        String nomChoisi = menu.getUserInput();

        // 4. Logique de création (On utilise des variables vides pour l'instant)
        Character monHeros = null;
        //Character : c'est le "Type parent" j'utilise la classe mere car elle est assez large pour accepter n'importe quelle enfant (Guerrier, Mage, Ninja).
        //monHeros : Le nom de ta variable qui contiendra le personnage choisi.
        //null : On crée la boîte, mais on ne sait pas encore quel personnage mettre dedans tant que le joueur n'a pas choisi.

        if (choixType.equals("1")) {
            monHeros = new Warrior(nomChoisi); //monHeros récupère la boîte vide ligne 25

            // Création et équipement des items pour le Guerrier
            Weapon epee = new Weapon("Épée en bois", 2);
            Shield bouclier = new Shield("Petit bouclier", 1);
            monHeros.setOffensiveEquipment(epee);
            monHeros.setDefensiveEquipment(bouclier);

        } else if (choixType.equals("2")) {
            monHeros = new Wizard(nomChoisi);// new (Warrior; Wizard ; Ninja) fabrique un objet de la classe en question

            // Création et équipement des items pour le Mage
            Spell feu = new Spell("Boule de feu", 3);
            Potion soin = new Potion("Potion mineure", 2);
            monHeros.setOffensiveEquipment(feu);
            monHeros.setDefensiveEquipment(soin);

        } else if (choixType.equals("3")) {
            monHeros = new Ninja(nomChoisi);//(nomChoisi) passe en paramètre le texte que le joueur vas saisir

            // Création et équipement des items pour le Ninja
            Kunai kunai = new Kunai("Kunai d'acier", 2);
            SmokeBomb fumigene = new SmokeBomb("Fumigène", 1);
            monHeros.setOffensiveEquipment(kunai);
            monHeros.setDefensiveEquipment(fumigene);

        } else {                            // le text vas aller jusqu'au constructeur des perso puis vers le "super()" du constucteur perso
            menu.displayMessage("Choix invalide, un Guerrier par défaut a été créé.");
            monHeros = new Warrior(nomChoisi);
            monHeros.setOffensiveEquipment(new Weapon("Épée rouillée", 1));
        }

        // 5. On affiche le résultat grâce au toString() qu'on a codé
        menu.displayMessage("Félicitations ! Voici votre personnage :");
        menu.displayMessage(monHeros.toString());

        // 6. On n'oublie pas de fermer le scanner à la fin
        menu.closeMenu();
    }
}