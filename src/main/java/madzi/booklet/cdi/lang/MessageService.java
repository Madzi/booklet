package madzi.booklet.cdi.lang;

import java.util.ResourceBundle;

public interface MessageService {

    String message(Key key);

    ResourceBundle resources();

    @FunctionalInterface
    interface Key {

        String key();
    }
}
