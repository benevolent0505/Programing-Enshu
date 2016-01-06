package views;

import models.Field;
import models.enums.Phase;
import views.components.PhaseButton;
import views.components.PhaseLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ken on 2015/12/11.
 */

public class PhasePanel extends JPanel {

    private final ArrayList<JButton> phaseButtons = new ArrayList<>();
    private final ArrayList<JLabel> phaseLabels = new ArrayList<>();

    private JLabel phase;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public PhasePanel(Field field) {
        // タイトル
        phase = new JLabel("Phase");

        // フェイズボタン作成
        phaseLabels.add(new PhaseLabel(field, Phase.DROW_PHASE));
        phaseLabels.add(new PhaseLabel(field, Phase.STAND_BY_PHASE));
        phaseLabels.add(new PhaseLabel(field, Phase.MAIN_PHASE_1));
        phaseButtons.add(new PhaseButton(field, Phase.BATTLE_PHAES));
        phaseButtons.add(new PhaseButton(field, Phase.MAIN_PHASE_2));
        phaseButtons.add(new PhaseButton(field, Phase.END_PHASE));

        layout = new GridBagLayout();
        gbc = new GridBagConstraints();

        setLayout(layout);
        gbc.fill = GridBagConstraints.BOTH;

        // Phases
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        layout.setConstraints(phase, gbc);
        add(phase);

        for (int i = 0; i < phaseButtons.size(); i++) {
            addComponent(phaseButtons.get(i), i, 1, 1, 1, 0.2, 0.7,
                    GridBagConstraints.EAST, new Insets(0, 50, 0, 50));
            add(phaseButtons.get(i));
        }


        for (int i = 0; i < phaseLabels.size(); i++) {
            addComponent(phaseLabels.get(i), i, 1, 1, 1, 0.2, 0.7,
                    GridBagConstraints.EAST, new Insets(0, 50, 0, 50));
            add(phaseLabels.get(i));
        }
    }

    private void addComponent(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight,
                              double weightx, double weighty, int anchor, Insets insets) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.anchor = anchor;
        gbc.insets = insets;
        layout.setConstraints(comp, gbc);
    }
}
