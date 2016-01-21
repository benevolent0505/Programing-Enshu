package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mikio on 2016/01/21.
 */
public class MainPanel extends JPanel {

    private static FieldPanel fieldPanel = new FieldPanel();

    public MainPanel() {
        setLayout(new BorderLayout());

        add(fieldPanel, BorderLayout.CENTER);
    }
}
