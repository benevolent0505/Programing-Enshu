package views;

import models.Card;
import models.Player;
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

    private Player player;

    public HandsPanel(Player player) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.player = player;
        player.setHandsObserver(this);

        // 手札の初期化
        initHand();
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO: フェイズチェック
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
                        add(cardButton);
                        add(Box.createGlue());  // 間隔調節用
                    }
                });
    }
}