package views;


import javax.swing.*;
import java.awt.*;
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
    private JLabel fieldLabel;
    private ArrayList<JButton> monsterButtons;
    private ArrayList<JButton> magicTrapButtons;
    private JButton deckButton;
    private JButton cemeteryButton;
    private JButton extraButton;
    private JButton fieldMagicButton;

    public FieldPanel(String side) {


            fieldLabel = new JLabel("Player Field");
            monsterButtons = new ArrayList<JButton>();
            magicTrapButtons = new ArrayList<JButton>();
            deckButton = new JButton("Deck");
            cemeteryButton = new JButton("Cemetery");
            extraButton = new JButton("Extra");
            fieldMagicButton = new JButton("FieldMagic");

            for (int i = 0; i < MAX_MONSTERS; i++) {
                JButton tmp = new JButton("Monster" + i);
                monsterButtons.add(tmp);
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                JButton tmp = new JButton("MagicTrap" + i);
                magicTrapButtons.add(tmp);
            }


        //自分サイド
        if (side.equals("self")) {

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
            mainLayout.setConstraints(fieldLabel, mainLayoutConstraints);
            add(fieldLabel);

            //FieldMagic
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 0;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(fieldMagicButton, mainLayoutConstraints);
            add(fieldMagicButton);

            //Monsters
            for (int i = 0; i < MAX_MONSTERS; i++) {
                mainLayoutConstraints.weightx = 0.144;
                mainLayoutConstraints.weighty = 0.4;
                mainLayoutConstraints.gridx = i + 1;
                mainLayoutConstraints.gridy = 1;
                mainLayoutConstraints.gridwidth = 1;
                mainLayoutConstraints.gridheight = 1;
                mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
                mainLayout.setConstraints(monsterButtons.get(i), mainLayoutConstraints);
                add(monsterButtons.get(i));
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                mainLayoutConstraints.weightx = 0.144;
                mainLayoutConstraints.weighty = 0.4;
                mainLayoutConstraints.gridx = i + 1;
                mainLayoutConstraints.gridy = 2;
                mainLayoutConstraints.gridwidth = 1;
                mainLayoutConstraints.gridheight = 1;
                mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
                mainLayout.setConstraints(magicTrapButtons.get(i), mainLayoutConstraints);
                add(magicTrapButtons.get(i));
            }


            //Extra
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 0;
            mainLayoutConstraints.gridy = 2;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(extraButton, mainLayoutConstraints);
            add(extraButton);


            //Cemetery
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 6;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(cemeteryButton, mainLayoutConstraints);
            add(cemeteryButton);

            //Deck
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 6;
            mainLayoutConstraints.gridy = 2;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(deckButton, mainLayoutConstraints);
            add(deckButton);

        }

        //相手サイド
        if(side.equals("enemy")){

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
            mainLayout.setConstraints(fieldLabel, mainLayoutConstraints);
            add(fieldLabel);

            //FieldMagic
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 6;
            mainLayoutConstraints.gridy = 2;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(fieldMagicButton, mainLayoutConstraints);
            add(fieldMagicButton);

            //Monsters
            for (int i = 0; i < MAX_MONSTERS; i++) {
                mainLayoutConstraints.weightx = 0.144;
                mainLayoutConstraints.weighty = 0.4;
                mainLayoutConstraints.gridx = i + 1;
                mainLayoutConstraints.gridy = 2;
                mainLayoutConstraints.gridwidth = 1;
                mainLayoutConstraints.gridheight = 1;
                mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
                mainLayout.setConstraints(monsterButtons.get(i), mainLayoutConstraints);
                add(monsterButtons.get(i));
            }

            for (int i = 0; i < MAX_MAGICS_TRAPS; i++) {
                mainLayoutConstraints.weightx = 0.144;
                mainLayoutConstraints.weighty = 0.4;
                mainLayoutConstraints.gridx = i + 1;
                mainLayoutConstraints.gridy = 1;
                mainLayoutConstraints.gridwidth = 1;
                mainLayoutConstraints.gridheight = 1;
                mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
                mainLayout.setConstraints(magicTrapButtons.get(i), mainLayoutConstraints);
                add(magicTrapButtons.get(i));
            }


            //Extra
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 6;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(extraButton, mainLayoutConstraints);
            add(extraButton);


            //Cemetery
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 0;
            mainLayoutConstraints.gridy = 2;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(cemeteryButton, mainLayoutConstraints);
            add(cemeteryButton);

            //Deck
            mainLayoutConstraints.weightx = 0.144;
            mainLayoutConstraints.weighty = 0.4;
            mainLayoutConstraints.gridx = 0;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
            mainLayout.setConstraints(deckButton, mainLayoutConstraints);
            add(deckButton);
        }
    }
}
