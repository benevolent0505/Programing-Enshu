package views;

import models.GameKeeper;
import models.Player;
import models.enums.DeckType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class MainPanel extends JPanel {

    private GameKeeper keeper;
    private Player player;

    private FieldPanel fieldPanel;
    private PhasePanel phasePanel;
    private CardStatusPanel cardStatusPanel;
    private GameStatusPanel gameStatusPanel;
    private OpponentFieldPanel opponentFieldPanel;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public MainPanel() {
        player = new Player("Hoge", DeckType.DECK1);

        keeper = new GameKeeper();
        keeper.setPlayer(player);

        phasePanel = new PhasePanel(keeper);
        cardStatusPanel = new CardStatusPanel(player);
        gameStatusPanel = new GameStatusPanel(keeper);
        fieldPanel = new FieldPanel(keeper);
        opponentFieldPanel = new OpponentFieldPanel();


        // 以下レイアウト
        layout = new GridBagLayout();
        setLayout(layout);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 30;

        // Display selecting card by player
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 4;
        layout.setConstraints(cardStatusPanel, gbc);
        add(cardStatusPanel);

        // Display player statuses(name and player's life point)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(gameStatusPanel, gbc);
        add(gameStatusPanel);

        // Display phase buttons to change player's phase
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(phasePanel, gbc);
        add(phasePanel);

        // Display player's field(deck, monsters, cemetery, hand cards, magic and trap cards, fusions, field magic)
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(fieldPanel, gbc);
        add(fieldPanel);

        // Display opponent's field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        layout.setConstraints(opponentFieldPanel, gbc);
        add(opponentFieldPanel);
    }

    private void setComponentLayout(JComponent comp, int gridx, int gridy,
                                    int gridwidth, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        layout.setConstraints(comp, gbc);
    }
}
