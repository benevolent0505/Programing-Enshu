package views;


import models.Card;
import models.Field;
import models.Player;
import models.SelectedCard;
import models.enums.Place;
import models.enums.Side;
import views.components.CardButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ken on 2015/12/10.
 */
public class FieldPanel extends JPanel implements Observer, MouseListener {

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
    private SelectedCard selectedCard;
    private Side side;

    public FieldPanel(Player player, SelectedCard selectedCard, Side side) {


        fieldLabel = new JLabel("Player Field");
        monsterButtons = new ArrayList<>();
        magicTrapButtons = new ArrayList<>();
        deckButton = new JButton("Deck");
        cemeteryButton = new JButton("Cemetery");
        extraButton = new JButton("Extra");
        fieldMagicButton = new JButton("FieldMagic");

        this.field = player.getField();
        player.addObserver(this);
        this.selectedCard = selectedCard;

        this.side = side;


        for (int i = 0; i < MAX_MONSTERS; i++) {
            CardButton tmp = new CardButton("Monster" + i);
            tmp.addMouseListener(this);
            monsterButtons.add(tmp);
        }

        for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
            CardButton tmp = new CardButton("MagicTrap" + i);
            tmp.addMouseListener(this);
            magicTrapButtons.add(tmp);
        }


        //自分サイド
        if (side == Side.Player1) {

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
        if (side == Side.Player2) {

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


    // fieldのphase後、draw後、summon後に呼ばれる
    @Override
    public void update(Observable o, Object arg) {
        // TODO: if (field.getPhase() == Phase.MAIN_PHASE_1 || field.getPhase() == Phase.MAIN_PHASE_2) の処理が必要

        ArrayList<Card> monsters = field.getMonsterZone();

        for (int i = 0; i < monsters.size(); i++) {
            CardButton monsterButton = monsterButtons.get(i);

            monsterButton.setCard(monsters.get(i));
            monsterButton.setText(monsters.get(i).getName());
        }

        // 空のmonsterButtonsの後始末
        if (monsters.size() < monsterButtons.size()) {
            for (int i = monsters.size(); i < monsterButtons.size(); i++) {
                monsterButtons.get(i).setCard(null);
                monsterButtons.get(i).setText("");
            }
        }
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


    @Override
    public void mouseClicked(MouseEvent e) {
        CardButton button = (CardButton) e.getComponent();
        if (button.getCard() != null) {
            selectedCard.setPlace(Place.MONSTER_ZONE);
            selectedCard.setSide(side);
            selectedCard.setSelectedCard(button.getCard());

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}






