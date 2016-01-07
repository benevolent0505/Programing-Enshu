package models;

import java.util.Observable;

/**
 * Created by 信吾 on 2016/01/07.
 */
public class Game extends Observable {
    Player TurnPlayer;
    Player player1, player2;
    int turn = 1;

    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public Player getTurnPlayer() {
        return TurnPlayer;
    }

    public void changeTurnPlayer(Player p) {
        if (p == player1)
            TurnPlayer = player2;
        else {
            TurnPlayer = player1;
        }
        turn++;
        setChanged();
        notifyObservers();
    }
}
