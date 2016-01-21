package views.components;

import models.enums.DeckType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mikio on 2016/01/21.
 */
public class LoginDialog extends JDialog implements ActionListener {

    // For Player
    private static JPanel namePanel = new JPanel();
    private static JLabel nameLabel = new JLabel("名前");
    private static JTextField nameField = new JTextField();

    private static JPanel deckPanel = new JPanel();
    private static JLabel deckLabel = new JLabel("デッキ選択");
    private static JComboBox<String> selectDeckBox = new JComboBox<>();

    private static JPanel buttonPanel = new JPanel();
    private static JButton startButton = new JButton("完了");
    private static JButton quitButton = new JButton("やめる");

    public LoginDialog() {
        setTitle("プレイヤー設定");
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nameField.setColumns(15);
        namePanel.add(nameLabel);
        namePanel.add(nameField);


        selectDeckBox.addItem("デッキ1");
        selectDeckBox.addItem("デッキ2");
        selectDeckBox.addItem("デッキ3");

        deckPanel.add(deckLabel);
        deckPanel.add(selectDeckBox);


        startButton.addActionListener(this);
        quitButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);

        getContentPane().add(namePanel);
        getContentPane().add(deckPanel);
        getContentPane().add(buttonPanel);

        setSize(new Dimension(400, 200));
        setResizable(false);
        setModal(true);
    }

    public String getPlayerName() {
        return nameField.getText();
    }

    public DeckType getDeckType() {
        String selectedDeck = (String) selectDeckBox.getSelectedItem();

        switch (selectedDeck) {
            case "デッキ1":
                return DeckType.DECK1;
            case "デッキ2":
                return DeckType.DECK2;
            case "デッキ3":
                return DeckType.DECK3;
            default:
                return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            this.dispose();
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
