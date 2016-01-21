package models;

import models.enums.Attribute;
import models.enums.Species;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Card {

    private String name;
    private Species species;
    private Attribute attribute;
    private int level;
    private int attackPoint;
    private int defensePoint;

    private boolean AttackPossible = true;
    private boolean PositionPossible = true;

    public Card(String name, Species species, Attribute attribute, int level, int attackPoint, int defensePoint) {
        this.name = name;
        this.species = species;
        this.attribute = attribute;
        this.level = level;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    public void resetPossible() {
        AttackPossible = true;
        PositionPossible = true;
    }

    public void Attack() {
        AttackPossible = false;
    }

    public boolean getPositionNum() {
        return PositionPossible;
    }

    public boolean getAttack() {
        return AttackPossible;
    }

    public void Position() {
        PositionPossible = false;
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
