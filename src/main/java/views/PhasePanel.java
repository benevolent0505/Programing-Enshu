package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by ken on 2015/12/11.
 */

public class PhasePanel extends JPanel{
    private ArrayList<String> phaseNames;
    private ArrayList<JButton> phaseButtons;


    public PhasePanel(){
        //タイトル
        JLabel phase = new JLabel("Phase");

        //フェイズラベル作成
        phaseNames = new ArrayList<String>();
        phaseNames.add("Draw");
        phaseNames.add("Main1");
        phaseNames.add("Battle");
        phaseNames.add(("Main2"));
        phaseNames.add("End");

        phaseButtons = new ArrayList<JButton>();
        for(String s: phaseNames){
            JButton tmp = new JButton(s);
            phaseButtons.add(tmp);
        }


        GridBagLayout mainLayout = new GridBagLayout();
        setLayout(mainLayout);
        GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
        mainLayoutConstraints.fill = GridBagConstraints.BOTH;

        //Phases
        mainLayoutConstraints.weightx = 1.0;  //横の辺の比
        mainLayoutConstraints.weighty = 0.3;
        mainLayoutConstraints.gridx = 0;
        mainLayoutConstraints.gridy = 0;
        mainLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(phase, mainLayoutConstraints);
        add(phase);

        for(int i = 0; i < 5; i++) {
            mainLayoutConstraints.weightx = 0.2;  //横の辺の比
            mainLayoutConstraints.weighty = 0.7;
            mainLayoutConstraints.gridx = i;
            mainLayoutConstraints.gridy = 1;
            mainLayoutConstraints.gridwidth = 1;
            mainLayoutConstraints.gridheight = 1;
            mainLayoutConstraints.anchor = GridBagConstraints.EAST;
            mainLayout.setConstraints(phaseButtons.get(i), mainLayoutConstraints);
            add(phaseButtons.get(i));
        }





        //フェイズラべルのレイアウト




    }
}
