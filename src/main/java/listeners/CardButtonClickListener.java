package listeners;

import models.Card;
import models.Player;
import views.components.CardButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mikio on 2016/02/03.
 */
public class CardButtonClickListener implements ActionListener {

    private Player player;
    private Card card;

    public CardButtonClickListener(Player player, CardButton cardButton) {
        this.player = player;
        card = cardButton.getCard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.setSelectedCard(card);
    }
}
