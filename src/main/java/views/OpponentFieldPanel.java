package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/28.
 */
public class OpponentFieldPanel extends JPanel {

    private static MonsterZonePanel monsterZone = new MonsterZonePanel();
    private static MagicAndTrapZonePanel magicAndTrapZone = new MagicAndTrapZonePanel();
    private static HandsPanel handsPanel;

    private static JButton deckZone = new JButton("Deck");
    private static JPanel cemeteryZone = new JPanel();
    private static JPanel fieldMagicZone = new JPanel();
    private static JPanel fusionDeckZone = new JPanel();

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public OpponentFieldPanel() {
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        setComponentLayout(fieldMagicZone, 0, 0, 1, 1, 0.144, 0.4);
        fieldMagicZone.setBorder(new LineBorder(Color.black));
        add(fieldMagicZone);

        setComponentLayout(fusionDeckZone, 0, 1, 1, 1, 0.144, 0.4);
        fusionDeckZone.setBorder(new LineBorder(Color.black));
        add(fusionDeckZone);

        handsPanel = new HandsPanel();
        setComponentLayout(handsPanel, 0, 2, 3, 1, 0.7, 0.1);
        handsPanel.setBorder(new LineBorder(Color.black));
        add(handsPanel);

        setComponentLayout(monsterZone, 1, 0, 1, 1, 0.7, 0.2);
        monsterZone.setBorder(new LineBorder(Color.black));
        add(monsterZone);

        setComponentLayout(magicAndTrapZone, 1, 1, 1, 1, 0.7, 0.2);
        magicAndTrapZone.setBorder(new LineBorder(Color.black));
        add(magicAndTrapZone);

        setComponentLayout(cemeteryZone, 2, 0, 1, 1, 0.144, 0.4);
        cemeteryZone.setBorder(new LineBorder(Color.black));
        add(cemeteryZone);

        setComponentLayout(deckZone, 2, 1, 1, 1, 0.144, 0.4);
        deckZone.setBorder(new LineBorder(Color.BLUE));
        add(deckZone);
    }

    private void setComponentLayout(JComponent comp, int gridx, int gridy,
                                    int gridwidth, int gridheight,
                                    double weightx, double weighty) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        layout.setConstraints(comp, gbc);
    }
}
