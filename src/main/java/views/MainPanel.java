package views;

import views.components.LoginDialog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Mikio on 2016/01/21.
 */
public class MainPanel extends JPanel {

    private JButton button;
    private LoginDialog dialog;

    public MainPanel() {
        button = new JButton("だせ");
        dialog = new LoginDialog();
        add(button);
        button.addActionListener(e -> dialog.setVisible(true));

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // TODO: プレイヤー名とDeckTypeの設定処理
            }
        });
    }
}
