package models;

import models.enums.Attribute;
import models.enums.CardType;
import models.enums.Phase;
import models.enums.Species;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Mikio on 2015/12/17.
 */
public class Field extends Observable {

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
        initMonsterZone();

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

    private void initMonsterZone() {
        for(int i = 0; i < 5; i++){
            monsterZone.add(null);
        }
    }


    public void summon(Card card) {
        // 召喚するカードが手札にあったら
        if (hands.contains(card)) {
            // 手札から召喚するカードを取り除く処理
            hands.remove(hands.indexOf(card));
            // TODO: モンスターカードゾーンに追加する処理
            for(int i = 0; i < 5; i++) {
                if(monsterZone.get(i) == null) {
                    monsterZone.set(i, card);
                    break;
                }
            }
            // 通知
            setChanged();
            notifyObservers();
        }
    }

}
