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

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public MainPanel() {
        player = new Player("Hoge", DeckType.DECK1);

        phasePanel = new PhasePanel();
        cardStatusPanel = new CardStatusPanel(player);
        fieldPanel = new FieldPanel(player);


        // 以下レイアウト
        layout = new GridBagLayout();
        setLayout(layout);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        setComponentLayout(cardStatusPanel, 0, 0, 1, 2);
        add(cardStatusPanel);

        setComponentLayout(phasePanel, 1, 0, 1, 1);
        add(phasePanel);

        setComponentLayout(fieldPanel, 1, 1, 1, 1);
        add(fieldPanel);
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
