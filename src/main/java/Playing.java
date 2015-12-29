import models.Field;
import models.Player;
import views.FieldFrame;

/**
 * Created by ken on 2015/12/10.
 */
public class Playing {

    public static void main(String[] args){
        Field field1 = new Field();
        Field field2 = new Field();

        Player player1 = new Player(field1);
        Player player2 = new Player(field2);

        FieldFrame ff = new FieldFrame(field1, player1,  field2, player2);
    }
}
