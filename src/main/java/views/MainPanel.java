package views;

import views.components.LoginDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
