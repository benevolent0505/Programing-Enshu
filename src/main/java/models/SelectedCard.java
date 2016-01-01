package models;

import java.util.Observable;

/**
 * Created by Mikio on 2015/12/29.
 */
public class SelectedCard extends Observable {

    private Card selectedCard;


    public SelectedCard() {}


    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
        setChanged();
        notifyObservers();
    }
}
