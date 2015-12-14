package views;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
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

    //カードの画像データ
    private ArrayList<BufferedImage> monster_card_images = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> magic_trap_card_images = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> cemetery_card_iamges = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> deck_card_images = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> field_magic_card_images = new ArrayList<BufferedImage>();
    private ArrayList<BufferedImage> extra_card_images  = new ArrayList<BufferedImage>();






    public FieldPanel(String side){

        if(side.equals("self")){
            JLabel self_field = new JLabel("Self Field");
            this.add(self_field);
        } else if(side.equals("enemy")){
            JLabel enemy_field = new JLabel("Enemy Field");
            this.add(enemy_field);
        }
    }



}
