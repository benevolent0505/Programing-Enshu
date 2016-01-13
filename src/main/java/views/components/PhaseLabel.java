package views.components;

import models.Player;
import models.enums.Phase;
import models.Field;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by 信吾 on 2016/01/04.
 */
public class PhaseLabel extends JLabel implements Observer {
    private Phase phase;
    private Player player1, player2;

    public PhaseLabel(Player p1, Player p2, Phase ph) {
        this.phase = ph;
        player1 = p1;
        player2 = p2;
        setText(phase.toString());
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.black));
        setOpaque(true);
        player1.addObserver(this);
        player2.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        Player pl = player1;

        if (player1.getPlayerTurn()) {
            pl = player1;
        } else if (player2.getPlayerTurn()){
            pl = player2;
        }

        if (pl.getPhase() == phase) {
            setBackground(Color.BLUE);
        } else {
            setBackground(Color.WHITE);
        }

    }
}

