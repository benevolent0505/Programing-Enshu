package models;

import models.enums.Phase;
import models.enums.Position;
import utilities.CardDBManager;

import java.util.ArrayList;
import java.util.Observable;
import java.util.jar.Pack200;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Field extends Observable {

    private static final int MAX_MONSTER_ZONE_SIZE = 5;

    private int lifePoint;

    private Phase phase;
    private ArrayList<Card> deck;
    private ArrayList<Card> hands;
    private ArrayList<Card> monsterZone;
    private ArrayList<Card> cemeteryZone;
    private Card fieldMagicZone;
    private ArrayList<Card> fusionDeck;


    public Field() {

        lifePoint = 8000;
        deck = new ArrayList();
        hands = new ArrayList();
        monsterZone = new ArrayList();
        cemeteryZone = new ArrayList();

        initDeck();
        initHand();

    }


    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase sp) {
        phase = sp;
    }

    public ArrayList<Card> getHands() {
        return hands;
    }

    public ArrayList<Card> getMonsterZone() {
        return monsterZone;
    }

    public void setMonsterZone(ArrayList<Card> monsterZone) {
        this.monsterZone = monsterZone;
    }

    public ArrayList<Card> getCemeteryZone() {
        return cemeteryZone;
    }

    public void setCemeteryZone(ArrayList<Card> cemeteryZone) {
        this.cemeteryZone = cemeteryZone;
    }

    public Card getFieldMagicZone() {
        return fieldMagicZone;
    }

    public void setFieldMagicZone(Card fieldMagicZone) {
        this.fieldMagicZone = fieldMagicZone;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList draw(int number) {
        ArrayList<Card> tmp = new ArrayList();

        for (int i = 0; i < number; i++) {
            tmp.add(deck.get(0));
            deck.remove(0);
        }

        return tmp;
    }

    private void initDeck() {
        // TODO: 2016/01/03 デッキ名を引数に取る
        deck = CardDBManager.getDeck("hogehoge");
    }

    private void initHand() {
        for (int i = 0; i < 5; i++) {
            hands.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void summon(Card card) {
        // モンスターカードゾーンに召喚できる条件
        if (hands.contains(card) && monsterZone.size() < MAX_MONSTER_ZONE_SIZE) {
            hands.remove(hands.indexOf(card));
            card.setPosition(Position.Attack);
            monsterZone.add(card);

            setChanged();
            notifyObservers();
        }
    }

    public void set(Card card) {
        // モンスターカードゾーンに召喚できる条件
        if (hands.contains(card) && monsterZone.size() < MAX_MONSTER_ZONE_SIZE) {
            hands.remove(hands.indexOf(card));
            card.setPosition(Position.Set);
            monsterZone.add(card);
            setChanged();
            notifyObservers();
        }
    }


    public void changePosition(Card card, Position position) {
        card.setPosition(position);
        setChanged();
        notifyObservers();
    }

    public void destroyMonster(Card card) {
        if (monsterZone.size() != 0) {
            monsterZone.remove(monsterZone.indexOf(card));
            cemeteryZone.add(card);
            setChanged();
            notifyObservers();
        }
    }

    public void changeLifePoint(int changePoint) {
        this.setLifePoint(this.lifePoint + changePoint);
        if(this.lifePoint < 0) this.setLifePoint(0);
        setChanged();
        notifyObservers();
    }
}
