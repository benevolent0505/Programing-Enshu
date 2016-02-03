package views;

import models.Player;
import rx.functions.Action1;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/22.
 */
public class CardStatusPanel extends JPanel implements Observer {

    private JLabel nameLabel = new JLabel();
    private JLabel attrLabel = new JLabel();
    private JLabel levelLabel = new JLabel();
    private JLabel speciesLabel = new JLabel();
    private JLabel atkPtLabel = new JLabel();
    private JLabel defPtLabel = new JLabel();

    private JPanel btnPanel = new JPanel();

    private JButton setButton = new JButton("Set");
    private JButton attackButton = new JButton("Attack");
    private JButton changePosButton = new JButton("Change Pos");

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private Player player;

    public CardStatusPanel(Player player) {
        this.player = player;

        // layout setting
        layout = new GridBagLayout();
        setLayout(layout);

        // background setting for this panel
        setBackground(new Color(195, 145, 67));
        // border setting for this panel
        setBorder(new EtchedBorder(EtchedBorder.RAISED));

        gbc = new GridBagConstraints();

        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Display card name
        nameLabel.setText(" -- ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setOpaque(true);
        setComponentLayout(nameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        add(nameLabel);

        // Display card attribute
        attrLabel.setText(" -- ");
        attrLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        attrLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        attrLabel.setHorizontalAlignment(JLabel.CENTER);
        attrLabel.setOpaque(true);
        setComponentLayout(attrLabel, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        add(attrLabel);

        // Display card level
        levelLabel = new JLabel("Level : -- ");
        levelLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        levelLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        levelLabel.setHorizontalAlignment(JLabel.CENTER);
        levelLabel.setOpaque(true);
        setComponentLayout(levelLabel, 0, 1, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        add(levelLabel);

        // Display card illustration
        JPanel illustPanel = new JPanel();
        illustPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        gbc.weighty = 1.0;
        setComponentLayout(illustPanel, 0, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        add(illustPanel);

        // Reset gbc val
        gbc.weighty = 0;

        // Display card species
        speciesLabel = new JLabel(" -- ");
        speciesLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        speciesLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        speciesLabel.setHorizontalAlignment(JLabel.CENTER);
        speciesLabel.setOpaque(true);
        setComponentLayout(speciesLabel, 0, 3, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        add(speciesLabel);

        // Display card attack point
        atkPtLabel = new JLabel("ATK / -- ");
        atkPtLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        atkPtLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        atkPtLabel.setHorizontalAlignment(JLabel.CENTER);
        atkPtLabel.setOpaque(true);
        setComponentLayout(atkPtLabel, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        add(atkPtLabel);

        // Display card defense point
        defPtLabel = new JLabel("DEF / -- ");
        defPtLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        defPtLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        defPtLabel.setHorizontalAlignment(JLabel.CENTER);
        defPtLabel.setOpaque(true);
        setComponentLayout(defPtLabel, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        add(defPtLabel);


        // Buttons layout setting
        setComponentLayout(btnPanel, 0, 5, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        add(btnPanel);
        btnPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        btnPanel.setLayout(layout);

        // Display button to set card (select position)
        setComponentLayout(setButton, 0, 5, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        btnPanel.add(setButton);

        // Display button to attack opponent side monster or opponent player
        setComponentLayout(attackButton, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        btnPanel.add(attackButton);

        // Display button to change monster position
        setComponentLayout(changePosButton, 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        btnPanel.add(changePosButton);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private void setComponentLayout(JComponent comp, int gridx, int gridy,
                                    int gridweigt, int gridheight, int anchor, int fill) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridweigt;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.fill = fill;

        layout.setConstraints(comp, gbc);
    }
}
