package models;

import models.enums.DeckType;
import utilities.CardDBManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * Created by Mikio on 2016/01/21.
 * Fieldはプリミティブな操作を記述する.
 */
public class Field extends Observable {

    private static final int START_HAND_SIZE = 5;
    private static final int MAX_MONSTER_ZONE_SIZE = 5;
    private static final int MAX_MAGIC_AND_TRAP_ZONE_SIZE = 5;
    private static final int DEFAULT_LIFE_POINT = 8000;

    private int lifePoint;

    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> hands = new ArrayList<>();
    private ArrayList<Card> monsterZone = new ArrayList<>(MAX_MONSTER_ZONE_SIZE);
    private ArrayList<Card> magicAndTrapZone = new ArrayList<>();
    private ArrayList<Card> cemeteryZone = new ArrayList<>();
    private ArrayList<Card> fusionDeckZone = new ArrayList<>();
    private Card fieldMagicZone;

    public Field(DeckType deckType) {
        // デッキの読み込み
        deck = CardDBManager.getDeck(deckType);

        // デッキのシャッフル
        shuffle();

        // 手札の用意
        for (int i = 0; i < START_HAND_SIZE; i++) {
            addHand(this.drow());
        }

        // ライフポイントのセット
        lifePoint = DEFAULT_LIFE_POINT;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void changeLifePoint(int diff) {
        this.lifePoint = lifePoint + diff;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addDeck(Card card) {
        deck.add(card);
    }

    public Card drow() {
        return this.getDeck().remove(0);
    }

    public ArrayList<Card> getHands() {
        return hands;
    }

    public void addHand(Card card) {
        hands.add(card);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Card> getMonsterZone() {
        return monsterZone;
    }

    public void addMonster(Card card) {
        if (monsterZone.size() < MAX_MONSTER_ZONE_SIZE) {
            monsterZone.add(card);
        }
    }

    public ArrayList<Card> getMagicAndTrapZone() {
        return magicAndTrapZone;
    }

    public void addMagicAndTrap(Card card) {
        if (magicAndTrapZone.size() < MAX_MAGIC_AND_TRAP_ZONE_SIZE) {
            magicAndTrapZone.add(card);
        }
    }

    public ArrayList<Card> getCemeteryZone() {
        return cemeteryZone;
    }

    public void addCemetery(Card card) {
        cemeteryZone.add(card);
    }

    public ArrayList<Card> getFusionDeckZone() {
        return fusionDeckZone;
    }

    public void setFusionDeckZone(ArrayList<Card> fusionDeckZone) {
        this.fusionDeckZone = fusionDeckZone;
    }

    public Card getFieldMagicZone() {
        return fieldMagicZone;
    }

    public void setFieldMagicZone(Card fieldMagicZone) {
        this.fieldMagicZone = fieldMagicZone;
    }
}