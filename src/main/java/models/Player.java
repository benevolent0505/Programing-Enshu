package models;

/**
 * Created by Mikio on 2015/12/10.
 */
public class Player {

    private String name;
    private int lifePoint;

    private Field field;

    public Player(Field field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public void draw(int number) {
        field.draw(number);
    }

    public void shuffle() {

    }

    public void addLifePoint(int point) {
        lifePoint += point;
    }

    public void setCard() {

    }

    public void reverseCard() {

    }

    public void changeFormat() {

    }

    public void activateCardEffect() {

    }
}
