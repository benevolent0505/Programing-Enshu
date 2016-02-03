package models;

import models.enums.Phase;

import java.util.Observable;

/**
 * Created by Mikio on 2016/01/22.
 */
public class GameKeeper extends Observable {

    private Phase currentPhase;

    public GameKeeper() {
        currentPhase = Phase.DROW_PHASE;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase phase) {
          
        this.currentPhase = phase;
        setChanged();
        notifyObservers();
    }
}
