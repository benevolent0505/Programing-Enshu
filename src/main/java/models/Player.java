package models;

import models.enums.DeckType;
import models.enums.Phase;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/21.
 * PlayerはFieldのラッパーようなものだととらえる.より現実の操作に近い処理を記述する.
 */
public class Player extends Observable {

    private String name;
    private int lifePoint;
    private GameKeeper keeper;
    private Field field;
    private Card selectedCard;
    private boolean isSummoned;

    public Player(String name, DeckType deckType) {
        this.name = name;

        field = new Field(deckType);
        lifePoint = field.getLifePoint();

        isSummoned = false;
    }

    public String getName() {
        return name;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePointObserver(Observer observer) {
        field.addObserver(observer);
    }

    public void summon(Card card) {
        if (keeper.getCurrentPhase() == Phase.MAIN_PHASE_1 || keeper.getCurrentPhase() == Phase.MAIN_PHASE_2) {
            if (!isSummoned) {
                field.addMonster(card);
                field.removeHand(card);
                isSummoned = true;
            }
        }
    }

    public void drow(int number) {
        if (keeper.getCurrentPhase() == Phase.DROW_PHASE) {
            for (int i = 0; i < number; i++) {
                field.addHand(field.drow());
            }

            keeper.setPhase(Phase.STAND_BY_PHASE);
        }
    }

    public ArrayList<Card> getHands() {
        return field.getHands();
    }

    public void setHandsObserver(Observer observer) {
        field.addObserver(observer);
    }

    public ArrayList<Card> getMonsterZone() {
        return field.getMonsterZone();
    }

    public void setMonsterZoneObserver(Observer observer) {
        field.addObserver(observer);
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
        setChanged();
        notifyObservers();
    }

    public void setGameKeeper(GameKeeper keeper) {
        this.keeper = keeper;
    }
}
