package views;

import javax.swing.*;
import java.awt.*;


/**
 * Created by ken on 2015/12/12.
 */


public class PlayerStatusPanel extends JPanel{
    private JLabel playerLife;
    private JLabel playerName;
    private JLabel playerLabel;
    private JLabel enemyLife;
    private JLabel enemyName;

    public PlayerStatusPanel(){
        playerLabel = new JLabel("Player Status");
        playerName = new JLabel("PlayerName1:");
        playerLife = new JLabel("8000");
        enemyLife = new JLabel("8000");
        enemyName = new JLabel(":EnemyName");

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
        mainLayoutConstraints.insets = new Insets(0,100,0,0);
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
        mainLayoutConstraints.insets = new Insets(0,100,0,0);
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
        mainLayoutConstraints.insets = new Insets(0,100,0,0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(enemyLife, mainLayoutConstraints);
        add(enemyLife);


        mainLayoutConstraints.weightx = 0.25;
        mainLayoutConstraints.weighty = 0.5;
        mainLayoutConstraints.gridx = 3;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.insets = new Insets(0,100,0,0);
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(enemyName, mainLayoutConstraints);
        add(enemyName);




    }
}
