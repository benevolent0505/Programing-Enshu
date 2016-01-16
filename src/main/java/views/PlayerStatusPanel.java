package views;

import models.Field;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by ken on 2015/12/12.
 */


public class PlayerStatusPanel extends JPanel implements Observer {
    private JLabel playerLife;
    private JLabel playerName;
    private JLabel playerLabel;
    private JLabel enemyLife;
    private JLabel enemyName;
    private JFrame askPlayerNameFrame;
    private String name1;
    private String name2;
    Player player1;
    Player player2;
    private Field field1;
    private Field field2;

    private GridBagLayout layout;
    private GridBagConstraints gbc;


    public PlayerStatusPanel(Player player1, Player player2) {

        askPlayerNameFrame = new JFrame();
        name1 = JOptionPane.showInputDialog(askPlayerNameFrame, "What is Player1's Name?");
        if (name1 == null) System.exit(0);

        askPlayerNameFrame = new JFrame();
        name2 = JOptionPane.showInputDialog(askPlayerNameFrame, "What is Player2's Name?");
        if (name2 == null) System.exit(0);

        this.player1 = player1;
        this.player2 = player2;
        player1.setName(name1);
        player2.setName(name2);

        this.field1 = player1.getField();
        this.field2 = player2.getField();
        field1.addObserver(this);
        field2.addObserver(this);

        playerLabel = new JLabel("Player Status");
        playerName = new JLabel(player1.getName() + ":");
        playerLife = new JLabel(Integer.toString(field1.getLifePoint()));
        enemyLife = new JLabel(Integer.toString(field2.getLifePoint()));
        enemyName = new JLabel(":" + player2.getName());

        layout= new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        //title
        addComponent(playerLabel, 1.0, 0.5, 0, 0, GridBagConstraints.REMAINDER, 1, new Insets(0,0,0,0));

        //playerName
        addComponent(playerName, 0.25, 0.5, 0, 1, 1, 1, new Insets(0,100,0,0));

       //lifePoint
        addComponent(playerLife, 0.25, 0.5, 1, 1, 1, 1, new Insets(0,100,0,0));

        //lifePoint
        addComponent(enemyLife, 0.25, 0.5, 3, 1, 1, 1, new Insets(0,100,0,0));

        //enemyLife
        addComponent(enemyName, 0.25, 0.5, 4, 1, 1, 1, new Insets(0,100,0,0));


    }


    private void addComponent(JComponent comp, double weightx, double weighty, int gridx, int gridy,
                              int gridwidth, int gridheight, Insets insets){
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.insets = insets;

        layout.setConstraints(comp, gbc);
        add(comp);
    }

    @Override
    public void update(Observable o, Object arg) {
        playerLife.setText(Integer.toString(field1.getLifePoint()));
        enemyLife.setText(Integer.toString(field2.getLifePoint()));

        if(field1.getLifePoint() == 0) notifySettlement(name2);
        if(field2.getLifePoint() == 0) notifySettlement(name1);
    }

    private void notifySettlement(String name){
        JOptionPane.showMessageDialog(null, name+"の勝利です。", "対戦結果", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);

    }



}
