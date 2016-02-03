package models;

import models.enums.DeckType;
import models.enums.Phase;

import java.util.Observable;

/**
 * Created by Mikio on 2016/01/22.
 */
public class GameKeeper extends Observable {

    private Phase currentPhase;

    private Player player;
    private Player opponent = new Player("Opponent", DeckType.DECK2);

    public GameKeeper() {
        currentPhase = Phase.DROW_PHASE;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        player.setGameKeeper(this);
    }

    public Player getOpponent() {
        return opponent;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public void setPhase(Phase phase) {
        // 現在のフェイズより後のフェイズを選択した場合のみ更新可能
        if (currentPhase.compareTo(phase) < 0) {
            this.currentPhase = phase;
            setChanged();
            notifyObservers();
        }
    }
}
