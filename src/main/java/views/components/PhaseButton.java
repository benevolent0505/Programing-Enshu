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
    private Player player;

    public PhaseButton(Player pl,Phase ph) {
        this.phase = ph;
        player = pl;
        setText(phase.toString());
        setBackground(Color.WHITE);
        player.addObserver(this);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Phase p1 = this.player.getPhase();
        if (phase.compareTo(p1)>0) {
            this.setBackground(Color.WHITE);
            player.setPhase(phase);
        }
    }

    public void update(Observable player, Object arg) {
        Phase p2 = this.player.getPhase();
        if(p2 == phase) {
            this.setBackground(Color.BLUE);
        }
        else
            this.setBackground(Color.WHITE);
    }
}


