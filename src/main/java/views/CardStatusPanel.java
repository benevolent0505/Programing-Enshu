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


    public CardStatusPanel(){
        cardStatusLabel = new JLabel("Card Status");
        this.add(cardStatusLabel);
        cardImage = new ImageIcon("~/programs/YuGiOh/Programing-Enshu/build/classes/main/views/c.png");
        card = new JLabel(cardImage);


        super.add(card);







    }





}
