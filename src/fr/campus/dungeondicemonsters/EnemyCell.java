package fr.campus.dungeondicemonsters;

/**
 * Case qui contient un ennemi.
 */
public class EnemyCell extends Cell {

    // --- L'ATTRIBUT ---
    // On pourrait plus tard créer une classe Enemy, mais pour l'instant on utilise un nom.
    private String enemyName;

    public EnemyCell(String description, String enemyName) {
        super(description); // On donne la description à la classe Cell
        this.enemyName = enemyName;
    }

    @Override
    public String toString() {
        return super.toString() + " ! Un " + enemyName + " surgit !";
    }
}