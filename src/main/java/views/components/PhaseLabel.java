package views.components;

import models.Player;
import models.enums.Phase;
import models.Field;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by 信吾 on 2016/01/04.
 */
public class PhaseLabel extends JLabel implements Observer {
    private Phase phase;
    private Player player1, player2;
    private Player TurnPlayer;

    public PhaseLabel(Player p1, Player p2, Phase ph) {
        this.phase = ph;
        TurnPlayer = p1;
        player1 = p1;
        player2 = p2;
        setText(phase.toString());
        setBackground(Color.WHITE);
        TurnPlayer.addObserver(this);
    }

    public void update(Observable field, Object arg) {
        if (TurnPlayer.getPlayerTurn() == false) {
            if (TurnPlayer == player1) {
                TurnPlayer = player2;
            } else TurnPlayer = player1;
        }

        Phase p2 = this.TurnPlayer.getPhase();
        if (p2 == phase) {
            this.setBackground(Color.BLUE);
        } else
            this.setBackground(Color.WHITE);
    }
}


