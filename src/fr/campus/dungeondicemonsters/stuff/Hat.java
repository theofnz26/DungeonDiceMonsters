package fr.campus.dungeondicemonsters.stuff;

public class Hat extends DefensiveEquipment {
    public Hat(String name, int healthLevel) {
        // super transmet le nom et le bonus (+3) au parent.
        super(name, healthLevel);
    }
}