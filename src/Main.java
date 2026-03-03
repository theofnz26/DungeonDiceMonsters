package fr.campus.dungeondicemonsters;

public class Main {

    public static void main(String[] args) {

        // 1. Création des personnages
        //Warrior = j'annonce a l'ordi ce que je m'apprête à manipuler, en gros = je dit "l'élément qui arrive respecte les règles du moule WARRIOR"
        //new = force l'ordi à faire naître l'objet qui suit new
        //Warrior("Gaia") j'appel le contructeur

        Warrior monGuerrier = new Warrior("Gaïa");
        Wizard monMage = new Wizard("Magicien des ténébres");
        Ninja monNinja = new Ninja("naruto");

        // 2. Affichage complet (Java appelle automatiquement la méthode toString() en coulisse !)
        System.out.println(monGuerrier);
        System.out.println(monMage);
        System.out.println(monNinja);
      //System = ça represente le systeme de l'ordi. En appelant "system" je dit a java "Je veux interagir avec la machine sur la quelle le programme est en train de tourner
    } //.out = c'est un attribut qui appartien a la classe "System", c'est la sortie de l'ecran de la console " je dit = dans le systeme de l'ordi je veux cibler l'ecran de console
}