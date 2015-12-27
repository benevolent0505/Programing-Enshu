package models;

import models.enums.Phase;

import java.util.ArrayList;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Field {

    private Phase phase;

    private ArrayList<Card> deck;
    private ArrayList<Card> hands;
    private ArrayList<Card> monsterZone;
    private ArrayList<Card> cemeteryZone;
    private Card fieldMagicZone;
    private ArrayList<Card> fusionDeck;

    public Field() {
        deck = new ArrayList();
        hands = new ArrayList();
        monsterZone = new ArrayList();
        cemeteryZone = new ArrayList();

        initDeck();
        initHand();

        phase = Phase.DROW_PHASE;
    }

    public Phase getPhase() {
        return phase;
    }

    public ArrayList getHands() {
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

    public ArrayList drow(int number) {
        ArrayList<Card> tmp = new ArrayList();

        for (int i = 0; i < number; i++) {
            tmp.add(deck.get(0));
            deck.remove(0);
        }

        if (phase == Phase.DROW_PHASE) {
            phase = Phase.STAND_BY_PHASE;
        }

        return tmp;
    }

    private void initDeck() {

    }

    private void initHand() {
        for (int i = 0; i < 5; i++) {
            hands.add(deck.get(0));
            deck.remove(0);
        }
    }
}