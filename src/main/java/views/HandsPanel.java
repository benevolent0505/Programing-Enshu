package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class HandsPanel extends JPanel {

    private static final int MAX_HAND_SIZE = 7;

    private static GridBagLayout layout;
    private static GridBagConstraints gbc;

    public HandsPanel() {
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
    }

    private void setComponentLayout(JComponent comp, double weightx, double weighty, int gridx, int gridy,
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
