package models;

import models.enums.DeckType;
import models.enums.Field;

/**
 * Created by Mikio on 2016/01/21.
 * PlayerはFieldのラッパーようなものだととらえる.より現実の操作に近い処理を記述する.
 */
public class Player {

    private String name;
    private int lifePoint;

    private Field field;

    public Player(String name, DeckType deckType) {
        this.name = name;

        field = new Field(deckType);
        lifePoint = field.getLifePoint();
    }
}
