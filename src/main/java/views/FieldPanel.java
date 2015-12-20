package views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by ken on 2015/12/10.
 */
public class FieldPanel extends JPanel {

    //フィールドの構成
    private static final int MAX_MAGICS_TRAPS = 5;
    private static final int MAX_MONSTERS = 5;
    private static final int DECK = 1;
    private static final int EXTRA = 1;
    private static final int FIELD_MAGIC = 1;
    private static final int CEMETERY = 1;

    //並ぶカード
    private JLabel FieldLabel;
    private ArrayList<JButton> MonsterButton;
    private ArrayList<JButton> MagicTrapButton;
    private JButton DeckButton;
    private JButton CemeteryButton;
    private JButton ExtraButton;
    private JButton FieldMagicButton;

    public FieldPanel(String side) {

        if (side.equals("self")) {
             FieldLabel = new JLabel("Self Field");
        } else if (side.equals("enemy")) {
            FieldLabel = new JLabel("Enemy Field");
        }

        MonsterButton = new ArrayList<JButton>();
        MagicTrapButton = new ArrayList<JButton>();
        DeckButton = new JButton("Deck");
        CemeteryButton = new JButton("Cemetery");
        ExtraButton = new JButton("Extra");
        FieldMagicButton = new JButton("FieldMagic");

        for(int i = 0; i < MAX_MONSTERS; i++){
            JButton tmp = new JButton("Monster"+ i);
            MonsterButton.add(tmp);
        }

        for(int i = 0; i < MAX_MAGICS_TRAPS; i++){
            JButton tmp = new JButton("MagicTrap"+ i);
            MagicTrapButton.add(tmp);
        }


        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);
        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;


        //SelfField
        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.2;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(FieldLabel, mainLayoutConstraints);
        add(FieldLabel);

        //FieldMagic
        mainLayoutConstraints.weightx = 0.144;
        mainLayoutConstraints.weighty = 0.4;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(FieldMagicButton, mainLayoutConstraints);
        add(FieldMagicButton);

        //Monsters
        for(int i = 0; i < MAX_MONSTERS; i++) {
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = i + 1;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(MonsterButton.get(i), mainLayoutConstraints);
            add(MonsterButton.get(i));
        }

        for(int i = 0; i < MAX_MAGICS_TRAPS; i++) {
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = i + 1;
            mainLayoutConstraints.gridy = 2;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(MagicTrapButton.get(i), mainLayoutConstraints);
            add(MagicTrapButton.get(i));
        }






        //Extra
        mainLayoutConstraints.weightx = 0.144;
        mainLayoutConstraints.weighty = 0.4;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 2;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(ExtraButton, mainLayoutConstraints);
        add(ExtraButton);


        //Cemetery
        mainLayoutConstraints.weightx = 0.144;
        mainLayoutConstraints.weighty = 0.4;
        mainLayoutConstraints.gridx = 6;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(CemeteryButton, mainLayoutConstraints);
        add(CemeteryButton);

        //Deck
        mainLayoutConstraints.weightx = 0.144;
        mainLayoutConstraints.weighty = 0.4;
        mainLayoutConstraints.gridx = 6;
        mainLayoutConstraints.gridy = 2;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(DeckButton, mainLayoutConstraints);
        add(DeckButton);








    }


}
