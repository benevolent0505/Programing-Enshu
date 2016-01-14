import models.Field;
import models.Game;
import models.Player;
import views.FieldFrame;

/**
 * Created by ken on 2015/12/10.
 */
public class Playing {

    public static void main(String[] args) {
        Field field1 = new Field();
        Field field2 = new Field();

        Player player1 = new Player(1,field1);
        Player player2 = new Player(2,field2);

        new FieldFrame(player1, player2);

        Game game = new Game();
        player1.setGame(game);
        player2.setGame(game);

        game.startGame();
    }
}
