package views;

import models.Card;
import models.Player;
import models.enums.CardStatus;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mikio on 2016/01/22.
 */
public class CardStatusPanel extends JPanel implements Observer {

    private Player player;
    private Card selectedCard;

    private JLabel nameLabel = new JLabel(" -- ");
    private JLabel attrLabel = new JLabel(" -- ");
    private JLabel levelLabel = new JLabel("Level : -- ");
    private JLabel speciesLabel = new JLabel(" -- ");
    private JLabel atkPtLabel = new JLabel("ATK / -- ");
    private JLabel defPtLabel = new JLabel("DEF / -- ");

    private JPanel btnPanel = new JPanel();

    private JButton setButton = new JButton("召喚");
    private JButton attackButton = new JButton("攻撃");
    private JButton changePosButton = new JButton("表示形式変更");

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private JPanel parent = this;

    public CardStatusPanel(Player player) {
        this.player = player;
        player.addObserver(this);

        // layout setting
        layout = new GridBagLayout();
        setLayout(layout);

        setBackground(new Color(195, 145, 67));
        setBorder(new EtchedBorder(EtchedBorder.RAISED));

        gbc = new GridBagConstraints();

        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Display card name
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setOpaque(true);
        setComponentLayout(nameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        add(nameLabel);

        // Display card attribute
        attrLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        attrLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        attrLabel.setHorizontalAlignment(JLabel.CENTER);
        attrLabel.setOpaque(true);
        setComponentLayout(attrLabel, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        add(attrLabel);

        // Display card level
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
        speciesLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        speciesLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        speciesLabel.setHorizontalAlignment(JLabel.CENTER);
        speciesLabel.setOpaque(true);
        setComponentLayout(speciesLabel, 0, 3, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        add(speciesLabel);

        // Display card attack point
        atkPtLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        atkPtLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        atkPtLabel.setHorizontalAlignment(JLabel.CENTER);
        atkPtLabel.setOpaque(true);
        setComponentLayout(atkPtLabel, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        add(atkPtLabel);

        // Display card defense point
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
        setButton.addActionListener(new SetButtonClickListener());
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
        selectedCard = player.getSelectedCard();

        nameLabel.setText(selectedCard.getName());
        attrLabel.setText(selectedCard.getAttribute().toString());
        levelLabel.setText("Level : " + selectedCard.getLevel());
        speciesLabel.setText(selectedCard.getSpecies().toString());
        atkPtLabel.setText("ATK / " + selectedCard.getAttackPoint());
        defPtLabel.setText("DEF / " + selectedCard.getDefensePoint());
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

    private class SetButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedCard.getStatus() == CardStatus.HAND) {
                String values[] = {"攻撃表示", "裏側守備表示"};
                int res = JOptionPane.showOptionDialog(parent, "", "表示形式を選んでください",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, values, values[0]);

                // valuesの順番に対応 (0 = 攻撃表示, 1 = 裏側守備表示)
                if (res == 0) {
                    player.summon(selectedCard, CardStatus.ATTACK_POSITION);
                } else if (res == 1) {
                    player.summon(selectedCard, CardStatus.FACE_DOWN_DEFENSE_POSITION);
                }
            }
        }
    }
}
