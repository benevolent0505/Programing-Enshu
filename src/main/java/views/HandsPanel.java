package views;

import models.Field;
import models.SelectedCard;
import views.components.CardButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by ken on 2015/12/10.
 */

public class HandsPanel extends JPanel implements MouseListener {

    //現実的な枚数
    private static final int MAX_HANDS = 7;
    private static final int START_HANDS = 5;

    //カードの画像データ
    private ArrayList<CardButton> handsButton;
    private JLabel handsLabel;
    private JPopupMenu actionPopup;

    private Field field;
    private SelectedCard selectedCard;

    public HandsPanel(Field field, SelectedCard selectedCard, String side) {
        this.field = field;
        this.selectedCard = selectedCard;

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


        handsButton = new ArrayList();

        for (int i = 0; i < MAX_HANDS; i++) {
            CardButton tmp = new CardButton("Hand" + i);
            tmp.addMouseListener(this);

            if (i < START_HANDS) {
                tmp.setCard(field.getHands().get(i));
            }

            handsButton.add(tmp);
        }

        GridBagLayout mainLayout = new GridBagLayout();

        setLayout(mainLayout);

        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;

        //handsLabel
        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.3;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(handsLabel, mainLayoutConstraints);

        add(handsLabel);

        //handsButton
        for (int i = 0; i < MAX_HANDS; i++) {
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.7;
            mainLayoutConstraints.gridx = i;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(handsButton.get(i), mainLayoutConstraints);
            add(handsButton.get(i));
        }
    }

    public void mousePressed(MouseEvent e) {
        showPopup(e);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        CardButton button = (CardButton) e.getComponent();
        if (button.getCard() != null) {
            selectedCard.setSelectedCard(button.getCard());
        }
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
