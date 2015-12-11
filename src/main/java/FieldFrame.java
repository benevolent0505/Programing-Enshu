import java.awt.*;
import javax.swing.*;



public class FieldFrame extends JFrame{

    public FieldFrame() {
        //以下Panelの作成
        FieldPanel my_field = new FieldPanel();
        FieldPanel enemy_field = new FieldPanel();
        HandsPanel my_hands = new HandsPanel();
        HandsPanel enemy_hands = new HandsPanel();
        StatusPanel card_status = new StatusPanel();
        PhasePanel turn_phase = new PhasePanel();

        //以下Panelの貼り付け
        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);
        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;

        //Status
        card_status.setBorder(new javax.swing.border.LineBorder(Color.RED));
        mainLayoutConstraints.weightx = 0.3;  //横の辺の比
        mainLayoutConstraints.weighty = 1.0;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = GridBagConstraints.REMAINDER; //左端宣言
        mainLayout.setConstraints(card_status, mainLayoutConstraints);
        add(card_status);

        //Enemy_Hands
        enemy_hands.setBorder(new javax.swing.border.LineBorder(Color.BLUE));
        mainLayoutConstraints.weightx = 0.7;
        mainLayoutConstraints.weighty = 0.15;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayout.setConstraints(enemy_hands, mainLayoutConstraints);
        add(enemy_hands);

        //Enemy_Field
        enemy_field.setBorder(new javax.swing.border.LineBorder(Color.GREEN));
        mainLayoutConstraints.weightx = 0.7;
        mainLayoutConstraints.weighty = 0.3;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayout.setConstraints(enemy_field, mainLayoutConstraints);
        add(enemy_field);


        //Phase
        turn_phase.setBorder(new javax.swing.border.LineBorder(Color.GRAY));
        mainLayoutConstraints.weightx = 0.7;
        mainLayoutConstraints.weighty = 0.05;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 2;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayout.setConstraints(turn_phase, mainLayoutConstraints);
        add(turn_phase);


        //My_Field
        my_field.setBorder(new javax.swing.border.LineBorder(Color.ORANGE));
        mainLayoutConstraints.weightx = 0.7;
        mainLayoutConstraints.weighty = 0.3;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 3;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayout.setConstraints(my_field, mainLayoutConstraints);
        add(my_field);

        //My_Hands
        my_hands.setBorder(new javax.swing.border.LineBorder(Color.MAGENTA));
        mainLayoutConstraints.weightx = 0.15;
        mainLayoutConstraints.weighty = 0.1;
        mainLayoutConstraints.gridx = 1;
        mainLayoutConstraints.gridy = 4;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayout.setConstraints(my_hands, mainLayoutConstraints);
        add(my_hands);



        //以下、ベースの設定
        this.setTitle("Field Frame");
        this.setSize(683, 768);
        this.setLocation(683, 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
