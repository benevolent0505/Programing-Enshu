package models;

import views.FieldFrame;

import java.util.Observable;

/**
 * Created by 信吾 on 2016/01/07.
 */
public class Game extends Observable {
    private int TurnPlayer;
    int turn = 1;

    public Game() {
    }

    public void startGame(){
        TurnPlayer = 1;
        setChanged();
        notifyObservers();
    }

    public int getTurnPlayer() {
        return TurnPlayer;
    }

    public void changeTurnPlayer(int pn) {
        if (pn == 1)
            TurnPlayer = 2;
        else if(pn == 2){
            TurnPlayer = 1;
        }
        turn++;
        setChanged();
        notifyObservers();
    }
}
