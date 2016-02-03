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
 * Created by Mikio on 2016/01/21.
 */
public class HandsPanel extends JPanel implements Observer {

    private GameKeeper keeper;
    private Player player;

    public HandsPanel() {
    }

    public HandsPanel(GameKeeper keeper) {
        this.keeper = keeper;
        this.player = keeper.getPlayer();
        player.setHandsObserver(this);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        initHand();
    }

    @Override
    public void update(Observable o, Object arg) {
        removeAll();
        initHand();
    }

    private void initHand() {
        rx.Observable.from(player.getHands())
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