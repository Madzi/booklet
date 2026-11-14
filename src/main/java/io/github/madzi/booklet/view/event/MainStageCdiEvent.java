package io.github.madzi.booklet.view.event;

import io.github.madzi.booklet.cdi.event.CdiEvent;
import javafx.stage.Stage;

public record MainStageCdiEvent(Stage stage) implements CdiEvent {

}
