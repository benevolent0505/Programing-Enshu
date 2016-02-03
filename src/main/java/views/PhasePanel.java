package views;

import listeners.PhaseButtonListener;
import models.GameKeeper;
import models.enums.Phase;

import javax.swing.*;
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

    private GameKeeper keeper;

    public PhasePanel(GameKeeper keeper) {
        this.keeper = keeper;

        main1Button.addActionListener(new PhaseButtonListener(keeper, Phase.MAIN_PHASE_1));
        battleButton.addActionListener(new PhaseButtonListener(keeper, Phase.BATTLE_PHAES));
        main2Button.addActionListener(new PhaseButtonListener(keeper, Phase.MAIN_PHASE_2));
        endButton.addActionListener(new PhaseButtonListener(keeper, Phase.END_PHASE));

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
