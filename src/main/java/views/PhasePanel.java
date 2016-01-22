package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/22.
 */
public class PhasePanel extends JPanel {

    private JLabel drowLabel = new JLabel("Drow");
    private JLabel standByLabel = new JLabel("Stand By");
    private JLabel main1Label = new JLabel("Main 1");
    private JLabel battleLabel = new JLabel("Battle");
    private JLabel main2Label = new JLabel("Main 2");
    private JLabel endLabel = new JLabel("End");

    public PhasePanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(drowLabel);
        add(Box.createGlue());
        add(standByLabel);
        add(Box.createGlue());
        add(main1Label);
        add(Box.createGlue());
        add(battleLabel);
        add(Box.createGlue());
        add(main2Label);
        add(Box.createGlue());
        add(endLabel);

        setSelectBorder(drowLabel);
    }

    private void setSelectBorder(JLabel label) {
        label.setBorder(new LineBorder(new Color(144, 238, 144), 5));
    }
}
