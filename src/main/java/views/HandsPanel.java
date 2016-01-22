package views;

import models.Player;
import views.components.CardButton;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/21.
 */
public class HandsPanel extends JPanel implements Observer {

    private ArrayList<CardButton> handbuttons = new ArrayList<>();

    private Player player;

    public HandsPanel(Player player) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.player = player;
        player.setHandsObserver(this);

        // 手札の初期化
        player.getHands().stream().forEach(card -> {
            CardButton button = new CardButton(card);
            handbuttons.add(button);
            add(button);
            add(Box.createGlue());
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO: フェイズチェック
        
    }
}