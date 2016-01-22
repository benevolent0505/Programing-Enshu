package views;

import models.Player;
import models.enums.DeckType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class MainPanel extends JPanel {

    private Player player;

    private FieldPanel fieldPanel;
    private CardStatusPanel cardStatusPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        player = new Player("Hoge", DeckType.DECK1);
        fieldPanel = new FieldPanel(player);

        add(fieldPanel, BorderLayout.CENTER);
    }
}
