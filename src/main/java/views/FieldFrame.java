package views;

import models.Field;
import models.Player;
import models.SelectedCard;

import javax.swing.*;
import java.awt.*;

public class FieldFrame extends JFrame {

    private SelectedCard selectedCard;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public FieldFrame(Player player1,Player player2) {
        selectedCard = new SelectedCard();

        //以下Panelの作成
        PlayerStatusPanel player_status = new PlayerStatusPanel();
        FieldPanel selfField = new FieldPanel(player1, selectedCard, "self");
        FieldPanel enemyField = new FieldPanel(player2, selectedCard, "enemy");
        HandsPanel selfHands = new HandsPanel(player1, selectedCard, "self");
        HandsPanel enemyHands = new HandsPanel(player2, selectedCard, "enemy");
        CardStatusPanel cardStatus = new CardStatusPanel(player1, selectedCard);
        PhasePanel phaseStatus = new PhasePanel(player1,player2);
        PlayerStatusPanel playerStatus = new PlayerStatusPanel();

        //以下Panelの貼り付け
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //Status
        cardStatus.setBorder(new javax.swing.border.LineBorder(Color.RED));
        addComponent(cardStatus, 0.3, 1.0, 0, 0, 1, GridBagConstraints.REMAINDER);

        //PayerStatus
        playerStatus.setBorder(new javax.swing.border.LineBorder(Color.CYAN));
        addComponent(playerStatus, 0.7, 0.05, 1, 0, 1, 1);


        //Enemy_Hands
        enemyHands.setBorder(new javax.swing.border.LineBorder(Color.BLUE));
        addComponent(enemyHands, 0.7, 0.1, 1, 1, 1, 1);


        //Enemy_Field
        enemyField.setBorder(new javax.swing.border.LineBorder(Color.GREEN));
        addComponent(enemyField, 0.7, 0.2, 1, 2, 1, 1);


        //Phase
        phaseStatus.setBorder(new javax.swing.border.LineBorder(Color.GRAY));
        addComponent(phaseStatus, 0.7, 0.05, 1, 3, 1, 1);


        //Self_Field
        selfField.setBorder(new javax.swing.border.LineBorder(Color.ORANGE));
        addComponent(selfField, 0.7, 0.2, 1, 4, 1, 1);


        //Self_Hands
        selfHands.setBorder(new javax.swing.border.LineBorder(Color.MAGENTA));
        addComponent(selfHands, 0.7, 0.1, 1, 5, 1, 1);



        //以下、ベースの設定
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rect = env.getMaximumWindowBounds();
        setBounds(rect);
        this.setTitle("Field Frame");
        this.setLocation(683, 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }

    private void addComponent(JComponent comp, double weightx, double weighty, int gridx, int gridy,
                              int gridwidth, int gridheight){
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        layout.setConstraints(comp, gbc);
        add(comp);
    }


}