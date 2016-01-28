package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/22.
 */
public class PhasePanel extends JPanel {

    private JButton drowButton = new JButton("Drow");
    private JButton standByButton = new JButton("Stand By");
    private JButton main1Button = new JButton("Main 1");
    private JButton battleButton = new JButton("Battle");
    private JButton main2Button = new JButton("Main 2");
    private JButton endButton = new JButton("End");

    public PhasePanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(drowButton);
        add(Box.createGlue());
        add(standByButton);
        add(Box.createGlue());
        add(main1Button);
        add(Box.createGlue());
        add(battleButton);
        add(Box.createGlue());
        add(main2Button);
        add(Box.createGlue());
        add(endButton);

        setSelectBorder(drowButton);
    }

    private void setSelectBorder(JButton button) {
        button.setForeground(new Color(194, 32, 71));
    }
}
