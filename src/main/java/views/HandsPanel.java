package views;

import models.Card;
import models.GameKeeper;
import models.Player;
import models.enums.Phase;
import rx.functions.Action1;
import rx.functions.Func1;
import views.components.CardButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
                        cardButton.addActionListener(new CardButtonClickListener(cardButton));
                        add(cardButton);
                        add(Box.createGlue());  // 間隔調節用
                    }
                });
    }

    private class CardButtonClickListener implements ActionListener {

        private Card card;

        public CardButtonClickListener(CardButton cardButton) {
            card = cardButton.getCard();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            player.setSelectedCard(card);
        }
    }
}