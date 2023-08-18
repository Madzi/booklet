package madzi.booklet.cdi.view.event;

import javafx.stage.Stage;

public record VoidViewEvent(Stage stage) implements ViewEvent<Void> {

    public Void data() {
        return null;
    }
}
