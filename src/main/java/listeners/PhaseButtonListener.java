package listeners;

import models.GameKeeper;
import models.enums.Phase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mikio on 2016/02/03.
 */
public class PhaseButtonListener implements ActionListener {

    private GameKeeper keeper;
    private Phase phase;

    public PhaseButtonListener(GameKeeper keeper, Phase phase) {
        this.keeper = keeper;
        this.phase = phase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keeper.setPhase(phase);
    }
}
