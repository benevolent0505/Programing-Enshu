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

    public PhaseButton(Player p1, Player p2, Phase ph) {
        this.phase = ph;
        player1 = p1;
        player2 = p2;
        setText(phase.toString());
        setBackground(Color.WHITE);
        player1.addObserver(this);
        player2.addObserver(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (player1.getPlayerTurn()) {
            player1.setPhase(phase);
        } else if(player2.getPlayerTurn()){
            player2.setPhase(phase);
        }
    }

    public void update(Observable o, Object arg) {
        Player pl = player1;

        if (player1.getPlayerTurn()) {
            pl = player1;
        } else if (player2.getPlayerTurn()) {
            pl = player2;
        }

        if (pl.getPhase() == phase) {
            setBackground(Color.BLUE);
        } else if (pl.getPhase() != phase){
            setBackground(Color.WHITE);
        }

    }
}


