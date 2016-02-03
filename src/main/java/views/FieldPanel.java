package views;

import models.Card;
import models.GameKeeper;
import models.Player;
import models.enums.Phase;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mikio on 2016/01/21.
 */
public class FieldPanel extends JPanel {

    private Player player;

    private JPanel fieldMagicZone;
    private MonsterZonePanel monsterZone;
    private JPanel cemeteryZone;
    private JComboBox<Card> cemeteryBox;
    private JPanel fusionDeckZone;
    private MagicAndTrapZonePanel magicAndTrapZone;
    private JPanel deckZone;
    private JButton deck;
    private HandsPanel handsPanel;
    private JScrollPane scrollPane;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public FieldPanel(final GameKeeper keeper) {
        this.player = keeper.getPlayer();

        layout = new GridBagLayout();
        setLayout(layout);
        setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        gbc = new GridBagConstraints();

        fieldMagicZone = new JPanel();
        fieldMagicZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        fieldMagicZone.add(new JLabel("Field Magic Zone"));
        setComponentLayout(fieldMagicZone, 0, 0, 1, 1);
        add(fieldMagicZone);

        monsterZone = new MonsterZonePanel();
        monsterZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        gbc.weightx = 1;
        setComponentLayout(monsterZone, 1, 0, 1, 1);
        add(monsterZone);

        // reset weightx
        gbc.weightx = 0;

        cemeteryZone = new JPanel();
        cemeteryZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        cemeteryBox = new JComboBox<>();
        cemeteryZone.add(cemeteryBox);
        setComponentLayout(cemeteryZone, 2, 0, 1, 1);
        add(cemeteryZone);

        fusionDeckZone = new JPanel();
        fusionDeckZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        fusionDeckZone.add(new JLabel("Fusion Deck Zone"));
        setComponentLayout(fusionDeckZone, 0, 1, 1, 1);
        add(fusionDeckZone);

        magicAndTrapZone = new MagicAndTrapZonePanel();
        magicAndTrapZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        gbc.weightx = 1;
        setComponentLayout(magicAndTrapZone, 1, 1, 1, 1);
        add(magicAndTrapZone);

        // reset weightx
        gbc.weightx = 0;

        deckZone = new JPanel();
        deck = new JButton("Deck");
        deckZone.add(deck);
        deckZone.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        setComponentLayout(deckZone, 2, 1, 1, 1);
        add(deckZone);

        handsPanel = new HandsPanel(keeper);
        scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                // ウィンドウサイズが変更された場合のスクロールバーの動作: ref(http://www.ne.jp/asahi/hishidama/home/tech/java/swing/JScrollPane.html)
                return handsPanel.getPreferredSize();
            }
        };
        scrollPane.setViewportView(handsPanel);
        scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        setComponentLayout(scrollPane, 0, 2, 3, 1);
        add(scrollPane);


        deck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keeper.getCurrentPhase() == Phase.DROW_PHASE) {
                    player.drow(1);

                    // 本当はここにこの処理を書きたくないから別の場所に移動させるかも(Playerのdrowメソッド内に書きたい)
                    keeper.setPhase(Phase.STAND_BY_PHASE);
                }
            }
        });
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
