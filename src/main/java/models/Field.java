package models;

import models.enums.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Field extends Observable {

    private static final int MAX_MONSTER_ZONE_SIZE = 5;

    private Phase phase;

    private ArrayList<Card> deck;
    private ArrayList<Card> hands;
    private ArrayList<Card> monsterZone;
    private ArrayList<Card> cemeteryZone;
    private Card fieldMagicZone;
    private ArrayList<Card> fusionDeck;

    public Field() {
        deck = new ArrayList();
        hands = new ArrayList();
        monsterZone = new ArrayList();
        cemeteryZone = new ArrayList();

        initDeck();
        initHand();

        phase = Phase.DROW_PHASE;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        setChanged();
        notifyObservers();
    }

    public ArrayList<Card> getHands() {
        return hands;
    }

    public ArrayList<Card> getMonsterZone() {
        return monsterZone;
    }

    public void setMonsterZone(ArrayList<Card> monsterZone) {
        this.monsterZone = monsterZone;
    }

    public ArrayList<Card> getCemeteryZone() {
        return cemeteryZone;
    }

    public void setCemeteryZone(ArrayList<Card> cemeteryZone) {
        this.cemeteryZone = cemeteryZone;
    }

    public Card getFieldMagicZone() {
        return fieldMagicZone;
    }

    public void setFieldMagicZone(Card fieldMagicZone) {
        this.fieldMagicZone = fieldMagicZone;
    }

    public ArrayList draw(int number) {
        ArrayList<Card> tmp = new ArrayList();

        for (int i = 0; i < number; i++) {
            tmp.add(deck.get(0));
            deck.remove(0);
        }

        if (phase == Phase.DROW_PHASE) {
            phase = Phase.STAND_BY_PHASE;
            setChanged();
            notifyObservers();
        }

        return tmp;
    }

    private void initDeck() {

        deck.add(new Card("青眼の白龍", Species.Dragon, Attribute.Light, 8, 3000, 2500, CardType.NormalMonster));
        deck.add(new Card("クリボー", Species.Devil, Attribute.Dark, 1, 300, 200, CardType.EffectMonster));
        deck.add(new Card("カオス・ソルジャー", Species.Soldier, Attribute.Dark, 8, 2500, 2000, CardType.RitualMonster));
        deck.add(new Card("バスターブレイダー", Species.Soldier, Attribute.Graund, 7, 2400, 2000, CardType.EffectMonster));
        deck.add(new Card("ブラック・マジシャン", Species.Magician, Attribute.Dark, 8, 2500, 2000, CardType.NormalMonster));


        for (int i = 5; i < 40; i++) {
            deck.add(new Card("青眼の白龍", Species.Dragon, Attribute.Light, 8, 3000, 2500, CardType.NormalMonster));
        }
    }

    private void initHand() {
        for (int i = 0; i < 5; i++) {
            hands.add(deck.get(0));
            deck.remove(0);
        }
    }

    public void summon(Card card) {
        // モンスターカードゾーンに召喚できる条件
        if (hands.contains(card) && monsterZone.size() < MAX_MONSTER_ZONE_SIZE) {
            hands.remove(hands.indexOf(card));
            card.setPosition(Position.Attack);
            monsterZone.add(card);

            setChanged();
            notifyObservers();
        }
    }

    public void set(Card card){
        // モンスターカードゾーンに召喚できる条件
        if (hands.contains(card) && monsterZone.size() < MAX_MONSTER_ZONE_SIZE) {
            hands.remove(hands.indexOf(card));
            card.setPosition(Position.Set);
            monsterZone.add(card);

            setChanged();
            notifyObservers();
        }
    }

    public void changePosition(Card card){

        int option;
        switch(card.getPosition()){

            case Attack:
                option = JOptionPane.showOptionDialog(
                        null, "表示形式を守備表示へ変更しますか？", "表示形式変更",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null
                );
                if(option == JOptionPane.YES_OPTION) card.setPosition(Position.Deffence);
                break;

            case Deffence:
                    option = JOptionPane.showOptionDialog(
                        null, "表示形式を攻撃表示へ変更しますか？", "表示形式変更",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        null
                );
                if(option == JOptionPane.YES_OPTION) card.setPosition(Position.Attack);
                break;

            case Set:
                String selectValues[] = {"攻撃表示", "守備表示"};

                    option = JOptionPane.showOptionDialog(
                        null, "表示形式は何へ変更しますか？", "表示形式変更",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        selectValues,
                        selectValues[0]
                    );
                if(option == 0) card.setPosition(Position.Attack);
                if(option == 1) card.setPosition(Position.Deffence);
        }

        setChanged();
        notifyObservers();
    }


}
