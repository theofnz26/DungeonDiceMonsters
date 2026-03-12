package fr.campus.dungeondicemonsters.db;

import fr.campus.dungeondicemonsters.Characters.Character;
import com.google.gson.Gson; // Importation de la librairie Gson

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/dungeon_dice_monsters";
    private static final String USER = "root";
    private static final String PASSWORD = "Tf26111998";

    /**
     * Méthode utilitaire pour ouvrir la connexion.
     * C'est beaucoup plus propre que de tout réécrire à chaque fois.
     */
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * CREATE : Enregistre un personnage en base de données.
     */
    public void createHero(Character hero) {
        // En développement web, on utilise TOUJOURS des "?" pour les requêtes d'insertion.
        // Cela s'appelle une requête préparée et ça protège des failles de sécurité (Injections SQL).
        String sql = "INSERT INTO `Character` (Type, Name, LifePoints, Strength, OffensiveEquipment, DefensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";

        // Le "try-with-resources" (les parenthèses après le try) permet à Java de fermer la connexion tout seul à la fin.
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 1. On remplace les "?" par les attributs de ton objet Java
            // (Attention : Vérifie que getLife() et getAttack() correspondent bien aux noms des méthodes dans ta classe Character)
            pstmt.setString(1, hero.getClass().getSimpleName()); // Astuce : Récupère automatiquement "Warrior", "Wizard", etc.
            pstmt.setString(2, hero.getName());
            pstmt.setInt(3, hero.getLife());
            pstmt.setInt(4, hero.getAttack());

            // 2. Transformation des objets en JSON grâce à Gson
            Gson gson = new Gson();
            String offensiveJson = gson.toJson(hero.getOffensiveEquipment());
            String defensiveJson = gson.toJson(hero.getDefensiveEquipment());

            pstmt.setString(5, offensiveJson);
            pstmt.setString(6, defensiveJson);

            // 3. Exécution
            pstmt.executeUpdate(); // "Update" car on modifie le contenu de la base
            System.out.println("✅ Le héros " + hero.getName() + " a bien été sauvegardé en base de données !");

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la sauvegarde du héros :");
            e.printStackTrace();
        }
    }

    /**
     * READ : Affiche la liste de tous les personnages dans la console.
     */
    public void getHeroes() {
        String sql = "SELECT * FROM `Character`";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { // "Query" car on lit des données sans les modifier

            System.out.println("\n=== Liste des Héros sauvegardés dans la BDD ===");

            // On parcourt le tableau renvoyé par MariaDB ligne par ligne
            while (rs.next()) {
                System.out.println("- ID: " + rs.getInt("Id") +
                        " | Type: " + rs.getString("Type") +
                        " | Nom: " + rs.getString("Name") +
                        " | PV: " + rs.getInt("LifePoints") +
                        " | Force: " + rs.getInt("Strength"));
            }
            System.out.println("===============================================\n");

        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la récupération des héros :");
            e.printStackTrace();
        }
    }
}