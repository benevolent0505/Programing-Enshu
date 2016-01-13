package models;

import models.enums.Phase;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2015/12/10.
 */
public class Player extends Observable implements Observer {

    private String name;
    private int lifePoint;
    private boolean PlayerTurn;

    private Field field;
    private Game game;
    private int PlayerNumber;

    public Player(int pn, Field field) {
        this.PlayerNumber = pn;
        this.field = field;
        this.field.setPhase(Phase.DROW_PHASE);
    }

    public void setGame(Game game) {
        this.game = game;
        game.addObserver(this);
    }

    public void ChangeTurn() {
        game.changeTurnPlayer(PlayerNumber);
    }

    public Phase getPhase() {
        return field.getPhase();
    }

    public void setPhase(Phase p) {
        //メイン１→メイン2禁止
        if (!(field.getPhase() == Phase.MAIN_PHASE_1 && p == Phase.MAIN_PHASE_2)) {
            if (p == Phase.END_PHASE) {
                field.setPhase(p);
                setChanged();
                notifyObservers();

                System.out.print(PlayerNumber);
                System.out.println(field.getPhase());

                ChangeTurn();
            } else if (field.getPhase().compareTo(p) <= 0 || field.getPhase() == Phase.END_PHASE) {
                //逆順防止
                field.setPhase(p);

                System.out.print(PlayerNumber);
                System.out.println(field.getPhase());

                setChanged();
                notifyObservers();
            }
        }
    }

    public void ProgressPhase() {
        setPhase(Phase.DROW_PHASE);
        draw(1);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }
        setPhase(Phase.STAND_BY_PHASE);
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }
        setPhase(Phase.MAIN_PHASE_1);
    }

    public void update(Observable o, Object arg) {
        if (PlayerNumber == game.getTurnPlayer()) {
            PlayerTurn = true;
            ProgressPhase();
        } else {
            PlayerTurn = false;
            setChanged();
            notifyObservers();
        }
    }

    public boolean getPlayerTurn() {
        return PlayerTurn;
    }

    public Field getField() {
        return field;
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
