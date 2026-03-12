package fr.campus.dungeondicemonsters;

/**
 * Case qui contient un ennemi.
 */
public class EnemyCell extends Cell {

    // --- L'ATTRIBUT ---

    private String enemyName;

    public EnemyCell(String description, String enemyName) {
        super(description); //super fait reférence à la classe parent en locurence "Cell"
        this.enemyName = enemyName;
    }

    @Override
    public String toString() {
        return super.toString() + " ! Un " + enemyName + " surgit !";
    }
}