package models;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by Mikio on 2015/12/29.
 */
public class SelectedCard extends Observable {

    private String place;

    private Card selectedCard;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {

        this.place = place;
    }

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
