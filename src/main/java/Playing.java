import models.Field;
import views.FieldFrame;

/**
 * Created by ken on 2015/12/10.
 */
public class Playing {

    public static void main(String[] args){
        Field field1 = new Field();
        Field field2 = new Field();

        FieldFrame ff = new FieldFrame(field1, field2);
    }
}
