package views;

import models.GameKeeper;
import models.Player;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/02/02.
 */
public class GameStatusPanel extends JPanel implements Observer {

    private Player player;

    private JLabel playerNameLabel = new JLabel();
    private JLabel playerLifeLabel = new JLabel();
    private JLabel vsLabel = new JLabel("VS");
    private JLabel opponentNameLabel = new JLabel();
    private JLabel opponentLifeLabel = new JLabel();

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public GameStatusPanel(GameKeeper keeper) {
        this.player = keeper.getPlayer();
        player.setLifePointObserver(this);

        layout = new GridBagLayout();
        setLayout(layout);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        playerNameLabel.setText(player.getName());
        playerNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        playerNameLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(playerNameLabel, gbc);
        add(playerNameLabel);

        playerLifeLabel.setText(Integer.toString(player.getLifePoint()));
        playerLifeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        playerLifeLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        playerLifeLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(playerLifeLabel, gbc);
        add(playerLifeLabel);

        vsLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        vsLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        layout.setConstraints(vsLabel, gbc);
        add(vsLabel);

        opponentNameLabel.setText(keeper.getOpponent().getName());
        opponentNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        opponentNameLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(opponentNameLabel, gbc);
        add(opponentNameLabel);

        opponentLifeLabel.setText(Integer.toString(keeper.getOpponent().getLifePoint()));
        opponentLifeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        opponentLifeLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        opponentLifeLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(opponentLifeLabel, gbc);
        add(opponentLifeLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        playerLifeLabel.setText(Integer.toString(player.getLifePoint()));
    }
}