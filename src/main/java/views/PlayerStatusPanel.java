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
    private Field field1;
    private Field field2;


    public PlayerStatusPanel(Field field1, Field field2) {

        askPlayerNameFrame = new JFrame();
        name1 = JOptionPane.showInputDialog(askPlayerNameFrame, "What is Player1's Name?");
        if (name1 == null)
            System.exit(0);

        askPlayerNameFrame = new JFrame();
        name2 = JOptionPane.showInputDialog(askPlayerNameFrame, "What is Player2's Name?");
        if (name2 == null)
            System.exit(0);


        this.field1 = field1;
        this.field2 = field2;
        field1.addObserver(this);
        field2.addObserver(this);

        playerLabel = new JLabel("Player Status");
        playerName = new JLabel(name1 + ":");
        playerLife = new JLabel(Integer.toString(field1.getLifePoint()));
        enemyLife = new JLabel(Integer.toString(field2.getLifePoint()));
        enemyName = new JLabel(":" + name2);




        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);
        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;


        //title
        mainLayoutConstraints.weightx = 1.0;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(playerLabel, mainLayoutConstraints);
        add(playerLabel);

        //playerName
        mainLayoutConstraints.weightx = 0.25;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.insets = new Insets(0, 100, 0, 0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(playerName, mainLayoutConstraints);
        add(playerName);

        //lifePoint
        mainLayoutConstraints.weightx = 0.25;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.insets = new Insets(0, 100, 0, 0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(playerLife, mainLayoutConstraints);
        add(playerLife);


        //lifePoint
        mainLayoutConstraints.weightx = 0.25;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 2;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.insets = new Insets(0, 100, 0, 0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(enemyLife, mainLayoutConstraints);
        add(enemyLife);


        mainLayoutConstraints.weightx = 0.25;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 3;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.insets = new Insets(0, 100, 0, 0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(enemyName, mainLayoutConstraints);
        add(enemyName);

    }

    @Override
    public void update(Observable o, Object arg) {
        playerLife.setText(Integer.toString(field1.getLifePoint()));
        enemyLife.setText(Integer.toString(field2.getLifePoint()));
    }
}
