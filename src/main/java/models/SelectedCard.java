package models;

import models.enums.Place;
import models.enums.Side;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by Mikio on 2015/12/29.
 */
public class SelectedCard extends Observable {

    private Place place;
    private Side side;

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    private Card selectedCard;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {

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
