package models;

import models.enums.Attribute;
import models.enums.Phase;
import models.enums.Species;

import java.util.ArrayList;
import java.util.Observable;
import java.util.jar.Pack200;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Field extends Observable {

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

        setPhase(Phase.DROW_PHASE);
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase p) {
        this.phase = p;
        setChanged();
        notifyObservers();
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

    public ArrayList draw(int number) {
        ArrayList<Card> tmp = new ArrayList();

        for (int i = 0; i < number; i++) {
            tmp.add(deck.get(0));
            deck.remove(0);
        }

        if (phase == Phase.DROW_PHASE) {
            phase = Phase.STAND_BY_PHASE;
            setChanged();
            notifyObservers();
        }

        return tmp;
    }

    private void initDeck() {
        for (int i = 0; i < 40; i++) {
            deck.add(new Card("青眼の白龍", Species.Dragon, Attribute.Light, 8, 3000, 2500));
        }
    }

    private void initHand() {
        for (int i = 0; i < 5; i++) {
            hands.add(deck.get(0));
            deck.remove(0);
        }
    }
}
