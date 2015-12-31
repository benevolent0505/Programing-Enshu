package views;


import models.Card;
import models.Field;
import views.components.CardButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ken on 2015/12/10.
 */
public class FieldPanel extends JPanel implements Observer, ActionListener{

    //フィールドの構成
    private static final int MAX_MAGICS_TRAPS = 5;
    private static final int MAX_MONSTERS = 5;
    private static final int DECK = 1;
    private static final int EXTRA = 1;
    private static final int FIELD_MAGIC = 1;
    private static final int CEMETERY = 1;

    //並ぶカード
    private JLabel fieldLabel;
    private ArrayList<CardButton> monsterButtons;
    private ArrayList<CardButton> magicTrapButtons;
    private JButton deckButton;
    private JButton cemeteryButton;
    private JButton extraButton;
    private JButton fieldMagicButton;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private Field field;

    public FieldPanel(Field field, String side) {


            fieldLabel = new JLabel("Player Field");
            monsterButtons = new ArrayList<CardButton>();
            magicTrapButtons = new ArrayList<CardButton>();
            deckButton = new JButton("Deck");
            cemeteryButton = new JButton("Cemetery");
            extraButton = new JButton("Extra");
            fieldMagicButton = new JButton("FieldMagic");

            this.field = field;

            for (int i = 0; i < MAX_MONSTERS; i++) {
                CardButton tmp = new CardButton("Monster" + i);
                tmp.setCard(field.getMonsterZone().get(i));
                monsterButtons.add(tmp);
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                CardButton tmp = new CardButton("MagicTrap" + i);
                tmp.setCard(field.getMonsterZone().get(i));
                magicTrapButtons.add(tmp);
            }


        //自分サイド
        if (side.equals("self")) {

            layout = new GridBagLayout();
            setLayout(layout);
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;


            //SelfField
            addComponent(fieldLabel, 1.0, 0.2, 0, 0, GridBagConstraints.REMAINDER, 1);

            //FieldMagic
            addComponent(fieldMagicButton, 0.144, 0.4, 0, 1, 1, 1);

            //Monsters
            for (int i = 0; i < MAX_MONSTERS; i++) {
                addComponent(monsterButtons.get(i), 0.144, 0.4, i + 1, 1, 1, 1);
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                addComponent(magicTrapButtons.get(i), 0.144, 0.4, i + 1, 2, 1, 1);
            }

            //Extra
            addComponent(extraButton, 0.144, 0.4, 0, 2, 1, 1);

            //Cemetery
            addComponent(cemeteryButton, 0.144, 0.4, 6, 1, 1, 1);

            //Deck
            addComponent(deckButton, 0.144, 0.4, 6, 2, 1, 1);



        }

        //相手サイド
        if(side.equals("enemy")) {

            layout = new GridBagLayout();
            setLayout(layout);
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;


            //EnemyField
            addComponent(fieldLabel, 1.0, 0.2, 0, 0, GridBagConstraints.REMAINDER, 1);

            //FieldMagic
            addComponent(fieldMagicButton, 0.144, 0.4, 6, 2, 1, 1);

            //Monsters
            for (int i = 0; i < MAX_MONSTERS; i++) {
                addComponent(monsterButtons.get(i), 0.144, 0.4, i + 1, 2, 1, 1);
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                addComponent(magicTrapButtons.get(i), 0.144, 0.4, i + 1, 1, 1, 1);
            }

            //Extra
            addComponent(extraButton, 0.144, 0.4, 6, 1, 1, 1);

            //Cemetery
            addComponent(cemeteryButton, 0.144, 0.4, 0, 2, 1, 1);

            //Deck
            addComponent(deckButton, 0.144, 0.4, 0, 1, 1, 1);




        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void update(Observable o, Object arg) {
        monsterButtons.get(0).setText(field.getMonsterZone().get(0).getName());
    }

    private void addComponent(JComponent comp, double weightx, double weighty, int gridx, int gridy,
                              int gridwidth, int gridheight) {

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



