package views;

import models.Field;
import models.Player;
import models.SelectedCard;
import models.enums.Side;

import javax.swing.*;
import java.awt.*;

public class FieldFrame extends JFrame {

    private Field field1;
    private Field field2;
    private SelectedCard selectedCard;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public FieldFrame(Field field1, Player player1, Field field2, Player player2) {

        this.field1 = field1;
        this.field1 = field2;
        this.selectedCard = new SelectedCard();

        Field field = new Field();

        //以下Panelの作成
        FieldPanel selfField = new FieldPanel(field1, selectedCard, Side.Player1);
        FieldPanel enemyField = new FieldPanel(field2, selectedCard, Side.Player2);
        HandsPanel selfHands = new HandsPanel(field1, selectedCard, Side.Player1);
        HandsPanel enemyHands = new HandsPanel(field2, selectedCard, Side.Player2);
        CardStatusPanel cardStatus = new CardStatusPanel(field1, field2,  selectedCard);
        PhasePanel phaseStatus = new PhasePanel(field);
        PlayerStatusPanel playerStatus = new PlayerStatusPanel(field1, field2);

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