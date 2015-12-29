package models;

import models.enums.*;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Card {

    private String name;
    private Species species;
    private Attribute attribute;
    private Position position;
    private int level;
    private int attackPoint;
    private int defensePoint;
    private CardType cardType;

    public Card(String name, Species species, Attribute attribute, int level, int attackPoint, int defensePoint) {
        this.name = name;
        this.species = species;
        this.attribute = attribute;
        this.level = level;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public int getDefensePoint() {
        return defensePoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
