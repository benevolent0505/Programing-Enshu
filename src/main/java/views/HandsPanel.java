package views; /**
 * Created by ken on 2015/12/10.
 */

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;


public class HandsPanel extends JPanel implements MouseListener {

    //現実的な枚数
    private static final int MAX_HANDS = 7;

    //カードの画像データ
    private ArrayList<JButton> handsButton;
    private JLabel handsLabel;
    private JPopupMenu actionPopup;

    public HandsPanel(String side) {
        if (side.equals("self")) {
            handsLabel = new JLabel("Self Hands");
        } else if (side.equals("enemy")) {
            handsLabel = new JLabel("Enemy Hands");
        }

        actionPopup = new JPopupMenu();
        JMenuItem summonItem = new JMenuItem("召喚");
        JMenuItem setItem = new JMenuItem("セット");
        actionPopup.add(summonItem);
        actionPopup.add(setItem);




    handsButton=new ArrayList<JButton>();

    for(
    int i = 0;
    i<MAX_HANDS;i++)

    {
        JButton tmp = new JButton("Hand" + i);
        tmp.addMouseListener(this);
        handsButton.add(tmp);
    }

    GridBagLayout mainLayout = new GridBagLayout();

    setLayout(mainLayout);

    GridBagConstraints mainLayoutConstraints = new GridBagConstraints();
    mainLayoutConstraints.fill=GridBagConstraints.BOTH;

    //handsLabel
    mainLayoutConstraints.weightx=1.0;  //横の辺の比
    mainLayoutConstraints.weighty=0.3;
    mainLayoutConstraints.gridx=0;
    mainLayoutConstraints.gridy=0;
    mainLayoutConstraints.gridwidth=GridBagConstraints.REMAINDER;
    mainLayoutConstraints.gridheight=1;
    mainLayoutConstraints.anchor=GridBagConstraints.CENTER;
    mainLayout.setConstraints(handsLabel,mainLayoutConstraints);

    add(handsLabel);

    //handsButton
    for(
    int i = 0;
    i<MAX_HANDS;i++)

    {
        mainLayoutConstraints.weightx = 0.144;
        mainLayoutConstraints.weighty = 0.7;
        mainLayoutConstraints.gridx = i;
        mainLayoutConstraints.gridy = 1;
        mainLayoutConstraints.gridwidth = 1;
        mainLayoutConstraints.gridheight = 1;
        mainLayoutConstraints.anchor = GridBagConstraints.CENTER;
        mainLayout.setConstraints(handsButton.get(i), mainLayoutConstraints);
        add(handsButton.get(i));
    }


}

    public void mousePressed(java.awt.event.MouseEvent e) {
        showPopup(e);
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
        showPopup(e);
    }


    private void showPopup(java.awt.event.MouseEvent e) {
        if (e.isPopupTrigger()) {
            actionPopup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
