package utilities;

import models.Card;
import models.enums.Attribute;
import models.enums.DeckType;
import models.enums.Species;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Mikio on 2016/01/03.
 */
public class CardDBManager {

    public static ArrayList<Card> getDeck(DeckType deckType) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        ArrayList<Card> deck = new ArrayList<>();

        try {
            connection = createConnection("cards.db");

            statement = connection.createStatement();

            // TODO: 2016/01/03 decknameにデッキ名を入れる
            resultSet = statement.executeQuery("SELECT * FROM CARDS;");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Species species = getSpecies(resultSet.getString("species"));
                Attribute attribute = getAttribute(resultSet.getString("attribute"));
                int level = resultSet.getInt("level");
                int attack = resultSet.getInt("attack");
                int defense = resultSet.getInt("defense");

                deck.add(new Card(name, species, attribute, level, attack, defense));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // TODO: データベースファイルが見つからなかった時の例外処理を書く
            return null;
        } catch (SQLException e) {
            // TODO: SQL系の例外処理を書く
            e.printStackTrace();
            return null;
        }

        return deck;
    }

    public static Connection createConnection(String filename) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + "db" + File.separator + filename);

            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: SQL系の例外処理を書く
            return null;
        }
    }

    public static Species getSpecies(String speacies) {
        switch (speacies) {
            case "dragon":
                return Species.Dragon;
            case "beast-warrior":
                return Species.Beast_Warrior;
            case "beast":
                return Species.Beast;
            case "spellcaster":
                return Species.Spellcaster;
            case "warrior":
                return Species.Warrior;
            case "devil":
                return Species.Devil;
            case "fairy":
                return Species.Fairy;
            case "rock":
                return Species.Rock;
            case "zombie":
                return Species.Zombie;
            case "fish":
                return Species.Fish;
            case "dinosaur":
                return Species.Dinosaur;
            case "aqua":
                return Species.Aqua;
            default:
                return null;
        }
    }

    public static Attribute getAttribute(String attribute) {
        switch (attribute) {
            case "LIGHT":
                return Attribute.LIGHT;
            case "EARTH":
                return Attribute.EARTH;
            case "DARK":
                return Attribute.DARK;
            case "WIND":
                return Attribute.WIND;
            case "WATER":
                return Attribute.WATER;
            default:
                return null;
        }
    }
}
