package views;

import listeners.PhaseButtonListener;
import models.GameKeeper;
import models.enums.Phase;
import rx.functions.Action1;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/22.
 */
public class PhasePanel extends JPanel implements Observer {

    private JButton drowButton = new JButton("Drow");
    private JButton standByButton = new JButton("Stand By");
    private JButton main1Button = new JButton("Main 1");
    private JButton battleButton = new JButton("Battle");
    private JButton main2Button = new JButton("Main 2");
    private JButton endButton = new JButton("End");

    private GameKeeper keeper;

    public PhasePanel(GameKeeper keeper) {
        this.keeper = keeper;
        keeper.addObserver(this);

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

    @Override
    public void update(Observable o, Object arg) {
        GameKeeper keeper = (GameKeeper)o;

        resetSelectBorder();
        switch (keeper.getCurrentPhase()) {
            case DROW_PHASE:
                setSelectBorder(drowButton);
                break;
            case STAND_BY_PHASE:
                setSelectBorder(standByButton);
                break;
            case MAIN_PHASE_1:
                setSelectBorder(main1Button);
                break;
            case BATTLE_PHAES:
                setSelectBorder(battleButton);
                break;
            case MAIN_PHASE_2:
                setSelectBorder(main2Button);
                break;
            case END_PHASE:
                setSelectBorder(endButton);
                break;
        }
    }

    private void setSelectBorder(JButton button) {
        button.setForeground(new Color(194, 32, 71));
    }

    private void resetSelectBorder() {
        rx.Observable.from(this.getComponents())
                .subscribe(new Action1<Component>() {
                    @Override
                    public void call(Component component) {
                        component.setForeground(Color.BLACK);
                    }
                });
    }
}
