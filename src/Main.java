package fr.campus.dungeondicemonsters;

public class Main {

    public static void main(String[] args) {

        // 1. Création des personnages
        Warrior monGuerrier = new Warrior("Gaïa");
        Wizard monMage = new Wizard("Magicien des ténébres");
        Ninja monNinja = new Ninja("naruto");

        // 2. Affichage complet (Java appelle automatiquement la méthode toString() en coulisse !)
        System.out.println(monGuerrier);
        System.out.println(monMage);
        System.out.println(monNinja);

    }
}