package views.components;

import models.Card;

import javax.swing.*;

/**
 * Created by Mikio on 2015/12/28.
 */
public class CardButton extends JButton {

    private Card card;

    public CardButton() {
        super();
    }

    public CardButton(String text) {
        super(text);
    }

    public CardButton(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
