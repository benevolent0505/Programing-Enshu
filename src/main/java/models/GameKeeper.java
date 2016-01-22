package models;

import models.enums.Phase;

/**
 * Created by Mikio on 2016/01/22.
 */
public class GameKeeper {

    private Phase currentPhase;

    public GameKeeper() {

    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(Phase phase) {
        this.currentPhase = phase;
    }
}
