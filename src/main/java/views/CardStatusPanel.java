package views;

import models.Card;
import models.SelectedCard;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ken on 2015/12/10.
 */
public class CardStatusPanel extends JPanel implements Observer {

    private JLabel cardStatusLabel;
    private ImageIcon cardImage;
    private JLabel card;
    private JLabel status;
    private JLabel effect;
    private JButton summonButton;
    private JButton setButton;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private SelectedCard selectedCard;

    public CardStatusPanel(SelectedCard selectedCard) {
        cardStatusLabel = new JLabel("Card Status");
        cardImage = new ImageIcon(getClass().getResource("../normalMonster.png"));
        card = new JLabel(cardImage);


        status = new JLabel("名前/属性/種族/効果/ATK:0000/DEF:0000");
        effect = new JLabel("このカード以下の効果うんたらかんたら:");

        summonButton = new JButton("召喚");
        setButton = new JButton("セット");


        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //Title
        addComponent(cardStatusLabel, 1.0, 0.05, 0, 0, GridBagConstraints.REMAINDER, 1);



        //cardImage
        addComponent(card, 1.0, 0.45, 0, 1, 1, 1);


        //status
        addComponent(status, 1.0, 0.05, 0, 2, 1, 1);



        //effect
        addComponent(effect, 1.0, 0.30, 0, 3, 1, 1);


        //summonButton
        addComponent(summonButton, 1.0, 0.05, 0, 4, 1, 1);



        //setButton
        addComponent(setButton, 1.0, 0.05, 0, 5, 1, 1);
        


        this.selectedCard = selectedCard;
        selectedCard.addObserver(this);
    }

    private void addComponent(JComponent comp, double weightx, double weighty, int gridx, int gridy,
                         int gridwidth, int gridheight){
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        layout.setConstraints(comp, gbc);
        add(comp);
    }


    @Override
    public void update(Observable o, Object arg) {
        Card card = selectedCard.getSelectedCard();

        // TODO 以下にカードの情報をJLabelに反映させる処理を書く
    }
}
