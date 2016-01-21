package views;

import views.components.CardButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/21.
 */
public class HandsPanel extends JPanel implements Observer {

    private static final int MAX_HAND_SIZE = 7;
    private static final int START_HAND_SIZE = 5;

    private static ArrayList<CardButton> handbuttons = new ArrayList<>();
    private static ArrayList<JButton> buttons = new ArrayList<>();

    public HandsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // 手札の初期化
        // List process chance!!
        for (int i = 0; i < START_HAND_SIZE; i++) {
            buttons.add(new JButton("Hoge"));
        }
        for (JButton button : buttons) {
            add(button);
            add(Box.createGlue());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // ドロー時の手札更新処理をやりたい
    }
}