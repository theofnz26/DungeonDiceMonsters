package fr.campus.dungeondicemonsters.Characters;

// 'extends' indique que le Warrior EST un Character
//Cela indique à l'ordi que la nouvelle classe est une "fille" de la classe mère "Character".
//Elle hérite intante de toutes ses stats et de ses méthodes (getter setters)
public class Warrior extends Character {

    // Le constructeur du Guerrier ne demande que le nom à l'utilisateur
    public Warrior(String name) {
        // 'super' envoie les stats de base à la classe mère (nom, 10 PV, 5 Attaque, 0 Magie)
        super(name, 10, 5, 0);
    }   // super = c'est un appel direct au constructeur de classe mère.
    // grosso modo la classe fille dit à la classe mère "je vien d'etre cree, voici les stat que tu doit ranger des tes variables privées"
}