package views;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by ken on 2015/12/10.
 */
public class CardStatusPanel extends JPanel {

    //ステータス用カードイメージとテキスト
    private BufferedImage card_status_image = new BufferedImage();
    private JLabel card_property_text = new JLabel();
    private JLabel card_effect_text = new JLabel();
    private JLabel card_atk_def = new JLabel();

    public CardStatusPanel(){
        JLabel card_status = new JLabel("Card Status");
        this.add(card_status);


    }
}
