package views;

import listeners.CardButtonClickListener;
import models.Card;
import models.GameKeeper;
import models.Player;
import rx.functions.Action1;
import rx.functions.Func1;
import views.components.CardButton;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by benevolent0505 on 1/21/16.
 */
public class MonsterZonePanel extends JPanel implements Observer {

    private Player player;

    public MonsterZonePanel(GameKeeper keeper) {
        this.player = keeper.getPlayer();
        player.setMonsterZoneObserver(this);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setMonsters();
    }

    @Override
    public void update(Observable o, Object arg) {
        setMonsters();
    }

    private void setMonsters() {
        rx.Observable.from(player.getMonsterZone())
                .map(new Func1<Card, CardButton>() {
                    @Override
                    public CardButton call(Card card) {
                        return new CardButton(card);
                    }
                })
                .subscribe(new Action1<CardButton>() {
                    @Override
                    public void call(CardButton cardButton) {
                        cardButton.addActionListener(new CardButtonClickListener(player, cardButton));
                        add(cardButton);
                        add(Box.createGlue());  // 間隔調節用
                    }
                });
    }
}
