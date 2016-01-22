package models;

import models.enums.DeckType;

/**
 * Created by Mikio on 2016/01/21.
 * PlayerはFieldのラッパーようなものだととらえる.より現実の操作に近い処理を記述する.
 */
public class Player {

    private String name;
    private int lifePoint;

    private Field field;

    private Card selectedCard;

    public Player(String name, DeckType deckType) {
        this.name = name;

        field = new Field(deckType);
        lifePoint = field.getLifePoint();
    }

    public void drow(int number) {
        for (int i = 0; i < number; i++) {
            field.drow();
        }
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }
}
