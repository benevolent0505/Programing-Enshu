package models;

import models.enums.Phase;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2015/12/10.
 */
public class Player extends Observable implements Observer {

    private String name;
    private int lifePoint;
    private boolean PlayerTurn;

    private Field field;
    private Game game;

    public Player(Game g, Field field) {
        this.game = g;
        this.field = field;
        game.addObserver(this);
    }

    public void ChangeTurn() {
        game.changeTurnPlayer(this);
    }

    public Phase getPhase() {
        Phase p1 = field.getPhase();
        return p1;
    }

    public void setPhase(Phase p) {
        if (field.getPhase() == Phase.MAIN_PHASE_1 && p == Phase.MAIN_PHASE_2) {
        } else if (p == Phase.END_PHASE) {
            field.setPhase(p);
            setChanged();
            notifyObservers();
            ChangeTurn();
        } else {
            field.setPhase(p);
            setChanged();
            notifyObservers();
        }
    }

    public void ProgressPhase() {
        field.ProgressPhase();
    }

    public void update(Observable game, Object arg) {
        if (this == this.game.getTurnPlayer()) {
            PlayerTurn = true;
            ProgressPhase();
        } else {
            PlayerTurn = false;
            setPhase(null);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public void draw(int number) {
        field.draw(number);
    }

    public void shuffle() {

    }

    public void addLifePoint(int point) {
        lifePoint += point;
    }

    public void setCard() {

    }

    public void reverseCard() {

    }

    public void changeFormat() {

    }

    public void activateCardEffect() {

    }
}
