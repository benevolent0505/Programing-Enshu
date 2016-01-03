package views;

import models.Card;
import models.Field;
import models.SelectedCard;
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

public class HandsPanel extends JPanel implements MouseListener, Observer {

    //現実的な枚数
    private static final int MAX_HANDS = 7;
    private static final int START_HANDS = 5;

    //カードの画像データ
    private ArrayList<CardButton> handButtons;
    private JLabel handsLabel;
    private JPopupMenu actionPopup;

    private GridBagLayout layout;
    private GridBagConstraints gbc;


    private Field field;
    private SelectedCard selectedCard;

    public HandsPanel(Field field, SelectedCard selectedCard, String side) {
        this.field = field;
        field.addObserver(this);
        this.selectedCard = selectedCard;
        selectedCard.addObserver(this);


        if (side.equals("self")) {
            handsLabel = new JLabel("Self Hands");
        } else if (side.equals("enemy")) {
            handsLabel = new JLabel("Enemy Hands");
        }

        actionPopup = new JPopupMenu();
        JMenuItem summonItem = new JMenuItem("召喚");
        JMenuItem setItem = new JMenuItem("セット");
        actionPopup.add(summonItem);
        actionPopup.add(setItem);


        handButtons = new ArrayList();

        for (int i = 0; i < MAX_HANDS; i++) {
            CardButton tmp = new CardButton("Hand" + i);
            tmp.addMouseListener(this);

            if (i < START_HANDS) {
                tmp.setCard(field.getHands().get(i));
            }

            handButtons.add(tmp);
        }

        //初期手札のテキストを表示
        for (int i = 0; i < START_HANDS; i++) {
            handButtons.get(i).setText(handButtons.get(i).getCard().getName());
        }


        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;


        //handsLabel
        addComponent(handsLabel, 1.0, 0.3, 0, 0, GridBagConstraints.REMAINDER, 1);


        //handsButton
        for (int i = 0; i < MAX_HANDS; i++) {
            addComponent(handButtons.get(i), 0.144, 0.7, i, 1, 1, 1);
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

    // fieldのphase後、draw後、summon後に呼ばれる
    @Override
    public void update(Observable o, Object arg) {

        ArrayList<Card> hands = field.getHands();

        for (int i = 0; i < hands.size(); i++) {
            CardButton handButton = handButtons.get(i);

            handButton.setCard(hands.get(i));
            handButton.setText(hands.get(i).getName());
        }

        // 空のhandButtonの後始末
        if (hands.size() < handButtons.size()) {
            for (int i = hands.size(); i < handButtons.size(); i++) {
                handButtons.get(i).setCard(null);
                handButtons.get(i).setText("");
            }
        }
    }



    public void mousePressed(MouseEvent e) {
        showPopup(e);
    }

    public void mouseClicked(MouseEvent e) {
        CardButton button = (CardButton) e.getComponent();
        if (button.getCard() != null) {
            selectedCard.setPlace("Hand");
            selectedCard.setSelectedCard(button.getCard());

        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        showPopup(e);
    }

    private void showPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            actionPopup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

}
