package views.components;

import models.Field;
import models.Player;
import models.enums.Phase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.PaintEvent;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by 信吾 on 2016/01/04.
 */
public class PhaseButton extends JButton implements Observer, ActionListener {
    private Phase phase;
    private Player player1, player2;
    private Player TurnPlayer;

    public PhaseButton(Player p1, Player p2, Phase ph) {
        this.phase = ph;
        player1 = p1;
        player2 = p2;
        setText(phase.toString());
        setBackground(Color.WHITE);
        TurnPlayer.addObserver(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Phase ph1 = this.TurnPlayer.getPhase();
        if (phase.compareTo(ph1) > 0) {
            this.setBackground(Color.WHITE);
            TurnPlayer.setPhase(phase);
        }
    }

    public void update(Observable player, Object arg) {
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


