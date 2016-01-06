package views;

import models.Card;
import models.Field;
import models.SelectedCard;
import models.enums.CardType;
import models.enums.Place;
import models.enums.Position;
import models.enums.Side;

import java.awt.*;
import javax.swing.*;
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
    private JButton actionButton1;
    private JButton actionButton2;

    private GridBagLayout layout;
    private GridBagConstraints gbc;

    private Field field1;
    private Field field2;
    private SelectedCard selectedCard;

    public CardStatusPanel(Field field1, Field field2,  SelectedCard selectedCard) {

        cardStatusLabel = new JLabel("Card Status");
        cardIcon = new ImageIcon(getClass().getResource("../normalMonster.png"));
        cardImage = new JLabel(cardIcon);

        name = new JLabel("モンスター/魔法/トラップ名");
        status = new JLabel("星/属性/種族/効果");
        power = new JLabel("ATK:0000/DEF:0000");
        effect = new JLabel("このカード以下の効果うんたらかんたら:");

        actionButton1 = new JButton();
        actionButton2 = new JButton();
        actionButton1.addActionListener(this);
        actionButton2.addActionListener(this);

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
        addComponent(actionButton1, 1.0, 0.05, 0, 6, 1, 1);



        //setButton
        addComponent(actionButton2, 1.0, 0.05, 0, 7, 1, 1);


        this.field1 = field1;
        this.field2 = field2;
        field1.addObserver(this);
        field2.addObserver(this);

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

        // 手札・フィールドで共通な処理
        name.setText(card.getName());
        status.setText("星:" + card.getLevel() + "/属性:" + card.getSpecies() + "/種族:" + card.getAttribute());
        power.setText("ATK:" + card.getAttackPoint() + "/DEF:" + card.getDefensePoint());

        if (card.getCardType() == CardType.NormalMonster)
            cardIcon = new ImageIcon(getClass().getResource("../normalMonster.png"));
        if (card.getCardType() == CardType.EffectMonster)
            cardIcon = new ImageIcon(getClass().getResource("../effectiveMonster.png"));
        if (card.getCardType() == CardType.RitualMonster)
            cardIcon = new ImageIcon(getClass().getResource("../ritualMonster.png"));
        cardImage.setIcon(cardIcon);

        if(selectedCard.getPlace() == Place.HAND) {
            actionButton1.setText("召喚");
            actionButton2.setText("セット");
        }


        if(selectedCard.getPlace() == Place.MONSTER_ZONE){
            power.setText("ATK:" + card.getAttackPoint() + "/DEF:" + card.getDefensePoint() + "/表示形式:" + card.getPosition());
            actionButton1.setText("攻撃");
            actionButton2.setText("表示形式変更");
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Card card = selectedCard.getSelectedCard();
        Place place = selectedCard.getPlace();
        Side side = selectedCard.getSide();
        Field field = field1;

        if(side == Side.Player1) field = field1;
        if(side == Side.Player2) field = field2;


        if(e.getSource() == actionButton1){

            //手札で選択なら召喚
            if(place == Place.HAND) {
                field.summon(card);
            }

            //TODO: フィールドで選択なら攻撃
            if(place == Place.MONSTER_ZONE){
                field.attack(card);
            }

        }

        if(e.getSource() == actionButton2){

            //手札で選択ならセット
            if(place == Place.HAND) {
                field.set(card);
            }

            //フィールドで選択なら表示形式変更
            if(place == Place.MONSTER_ZONE){

                int option;
                switch(card.getPosition()){

                    case Attack:
                        option = JOptionPane.showOptionDialog(
                                null, "表示形式を守備表示へ変更しますか？", "表示形式変更",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                null,
                                null
                        );
                        if(option == JOptionPane.YES_OPTION) field.changePosition(card, Position.Deffence);
                        break;

                    case Deffence:
                        option = JOptionPane.showOptionDialog(
                                null, "表示形式を攻撃表示へ変更しますか？", "表示形式変更",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                null,
                                null
                        );
                        if(option == JOptionPane.YES_OPTION) field.changePosition(card, Position.Attack);
                        break;

                    case Set:
                        String selectValues[] = {"攻撃表示", "守備表示"};

                        option = JOptionPane.showOptionDialog(
                                null, "表示形式は何へ変更しますか？", "表示形式変更",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                selectValues,
                                selectValues[0]
                        );
                        if(option == 0) field.changePosition(card, Position.Attack);
                        if(option == 1) field.changePosition(card, Position.Deffence);
                }

            }

        }

    }
}
