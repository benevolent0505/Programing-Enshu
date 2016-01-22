package views;

import models.Card;
import models.Player;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/22.
 */
public class CardStatusPanel extends JPanel implements Observer {

    private JLabel nameLabel = new JLabel();
    private JLabel statusLabel = new JLabel();
    private JLabel atkAndDefLabel = new JLabel();

    private JButton setButton = new JButton();

    private JButton attackButton = new JButton();
    private JButton changePositionButton = new JButton();

    private Card card;

    public CardStatusPanel(Player player) {
        this.card = player.getSelectedCard();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        add(nameLabel);

        statusLabel.setText(makeStatusStr(card));
        add(statusLabel);

        atkAndDefLabel.setText(makeAtkAndDefStr(card));
        add(atkAndDefLabel);

        
        // card text
        // set (select position)
        // do attack
        // change position
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private String makeStatusStr(Card card) {
        if (card != null) {
            return "レベル : " + card.getLevel() + "/ 属性 : " + card.getSpecies() + " / 種族 : " + card.getAttribute();
        } else {
            return "レベル : - / 属性 : - / 種族 : - ";
        }
    }

    private String makeAtkAndDefStr(Card card) {
        if (card != null) {
            return "ATK : " + card.getAttackPoint() + " / DEF : " + card.getDefensePoint();
        } else {
            return "ATK : - / DEF : - ";
        }
    }
}
