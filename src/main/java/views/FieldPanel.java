package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class FieldPanel extends JPanel {

    private static MonsterZonePanel monsterZone = new MonsterZonePanel();
    private static MagicAndTrapZonePanel magicAndTrapZone = new MagicAndTrapZonePanel();

    private static HandsPanel handsPanel = new HandsPanel();

    private static GridBagLayout layout;
    private static GridBagConstraints gbc;

    public FieldPanel() {
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
    }

    private void setCompomentLayout(JComponent comp, double weightx, double weighty, int gridx, int gridy,
                                    int gridwidth, int gridheight) {
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        layout.setConstraints(comp, gbc);
    }
}
