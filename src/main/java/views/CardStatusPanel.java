package views;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

/**
 * Created by ken on 2015/12/10.
 */
public class CardStatusPanel extends JPanel {


    private JLabel cardStatusLabel;
    private ImageIcon cardImage;
    private JLabel card;
    private JLabel status;
    private JLabel effect;



    public CardStatusPanel() {
        cardStatusLabel = new JLabel("Card Status");
        cardImage = new ImageIcon(getClass().getResource("../normalMonster.png"));
        card = new JLabel(cardImage);


        status = new JLabel("名前/属性/種族/効果/ATK:0000/DEF:0000");
        effect = new JLabel("このカード以下の効果うんたらかんたら:");


        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);
        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;

        //Title
        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.05;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(cardStatusLabel, mainLayoutConstraints);
        add(cardStatusLabel);


        //cardImage
        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.45;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(card, mainLayoutConstraints);
        add(card);


        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.05;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 2;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(status, mainLayoutConstraints);
        add(status);


        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.45;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 3;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(effect, mainLayoutConstraints);
        add(effect);



    }
}
