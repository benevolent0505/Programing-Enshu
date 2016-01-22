package views.components;

import models.Card;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by benevolent0505 on 1/21/16.
 */
public class CardButton extends JButton {

    private Card card;

    public CardButton(Card card) {
        this.card = card;
        setText(card.getName());
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
