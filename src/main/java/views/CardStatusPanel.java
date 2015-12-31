package views;

import models.Card;
import models.Field;
import models.SelectedCard;
import models.enums.CardType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ken on 2015/12/10.
 */
public class CardStatusPanel extends JPanel implements Observer, ActionListener {

    private JLabel cardStatusLabel;
    private ImageIcon cardIcon;
    private JLabel cardImage;
    private JLabel name;
    private JLabel status;
    private JLabel power;
    private JLabel effect;
    private JButton summonButton;
    private JButton setButton;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private Field field;
    private SelectedCard selectedCard;

    public CardStatusPanel(Field field, SelectedCard selectedCard) {

        cardStatusLabel = new JLabel("Card Status");
        cardIcon = new ImageIcon(getClass().getResource("../normalMonster.png"));
        cardImage = new JLabel(cardIcon);

        name = new JLabel("モンスター/魔法/トラップ名");
        status = new JLabel("星/属性/種族/効果");
        power = new JLabel("ATK:0000/DEF:0000");
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
        addComponent(cardImage, 1.0, 0.45, 0, 1, 1, 1);

        //name
        addComponent(name, 1.0, 0.05, 0, 2, 1, 1);

        //status
        addComponent(status, 1.0, 0.05, 0, 3, 1, 1);

        //power
        addComponent(power, 1.0, 0.05, 0, 4, 1, 1);

        //effect
        addComponent(effect, 1.0, 0.30, 0, 5, 1, 1);


        //summonButton
        addComponent(summonButton, 1.0, 0.05, 0, 6, 1, 1);



        //setButton
        addComponent(setButton, 1.0, 0.05, 0, 7, 1, 1);


        this.field = field;
        field.addObserver(this);

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
        // TODO 以下にカードの情報をJLabelに反映させる処理を書く

        Card card = selectedCard.getSelectedCard();

        name.setText(card.getName());

        status.setText("星:"+card.getLevel()+ "/属性:"+card.getSpecies()+ "/種族:"+card.getAttribute());

        power.setText("ATK:"+card.getAttackPoint()+"/DEF:"+card.getDefensePoint());

        if(card.getCardType() == CardType.NormalMonster)
            cardIcon = new ImageIcon(getClass().getResource("../normalMonster.png"));
        if(card.getCardType() == CardType.EffectMonster)
            cardIcon = new ImageIcon(getClass().getResource("../effectiveMonster.png"));
        if(card.getCardType() == CardType.RitualMonster)
            cardIcon = new ImageIcon(getClass().getResource("../ritualMonster.png"));
        cardImage.setIcon(cardIcon);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == summonButton){

            Card card = selectedCard.getSelectedCard();
            field.summon(card);



        }


    }
}
