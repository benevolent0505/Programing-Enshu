import views.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Yu-Gi-Oh Game");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.add(new MainPanel(), BorderLayout.CENTER);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
