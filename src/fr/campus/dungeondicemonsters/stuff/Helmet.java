package fr.campus.dungeondicemonsters.stuff;

public class Helmet extends DefensiveEquipment {
    public Helmet(String name, int healthLevel) {
        super(name, healthLevel); // On envoie le bonus (+3) au parent
    }
}