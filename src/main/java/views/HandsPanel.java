package views; /**
 * Created by ken on 2015/12/10.
 */

import java.util.ArrayList;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class HandsPanel extends JPanel{

    //現実的な枚数
    private static final int MAX_HANDS = 15;

    //カードの画像データ
    private ArrayList<BufferedImage> hand_images = new ArrayList<BufferedImage>();


    public HandsPanel(String side){
        if(side.equals("self")){
            JLabel self_hands = new JLabel("Self Hands");
            this.add(self_hands);
        } else if(side.equals("enemy")){
            JLabel enemy_hands = new JLabel("Enemy Hands");
            this.add(enemy_hands);
        }
    }
}
