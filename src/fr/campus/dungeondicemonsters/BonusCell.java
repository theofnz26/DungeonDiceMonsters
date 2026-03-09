package fr.campus.dungeondicemonsters;

// On importe les équipements pour pouvoir les mettre dans la case
import fr.campus.dungeondicemonsters.stuff.OffensiveEquipment;
import fr.campus.dungeondicemonsters.stuff.DefensiveEquipment;

public class BonusCell extends Cell {

    // --- LES ATTRIBUTS ---
    private OffensiveEquipment offItem;
    private DefensiveEquipment defItem;

    // Constructeur pour un bonus offensif (Arme/Sort)
    public BonusCell(String description, OffensiveEquipment item) {
        super(description);
        this.offItem = item;
    }

    // Constructeur pour un bonus défensif (Armure/Potion)
    public BonusCell(String description, DefensiveEquipment item) {
        super(description);
        this.defItem = item;
    }

    @Override
    public String toString() {
        String contenu = (offItem != null) ? offItem.toString() : defItem.toString();
        return super.toString() + ". Vous trouvez : " + contenu;
    }
}