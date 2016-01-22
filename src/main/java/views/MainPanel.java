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
    private PhasePanel phasePanel;
    private CardStatusPanel cardStatusPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        player = new Player("Hoge", DeckType.DECK1);

        phasePanel = new PhasePanel();
        cardStatusPanel = new CardStatusPanel(player);
        fieldPanel = new FieldPanel(player);

        add(phasePanel, BorderLayout.NORTH);
        add(cardStatusPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
    }
}
