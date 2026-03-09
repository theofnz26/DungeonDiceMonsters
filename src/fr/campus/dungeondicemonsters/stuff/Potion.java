package fr.campus.dungeondicemonsters.stuff;

public class Potion extends DefensiveEquipment {

    private boolean isFullHeal; // [1]

    public Potion(String name, int healthBonus, boolean isFullHeal) {
        super(name, healthBonus);
        this.isFullHeal = isFullHeal;
    }

    public boolean isFullHeal() {
        return isFullHeal;
    }
}