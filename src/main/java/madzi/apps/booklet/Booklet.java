package madzi.apps.booklet;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Booklet extends Application {

    private static final Logger logger = LoggerFactory.getLogger(Booklet.class);

    private SeContainer container;

    @Override
    public void init() {
        logger.info("Strarting...");
        container = SeContainerInitializer.newInstance().initialize();
    }

    @Override
    public void start(final Stage stage) {
        stage.setScene(new Scene(new BorderPane(), 800.0, 600.0));
        stage.setTitle("Booklet");
        stage.show();
    }

    @Override
    public void stop() {
        logger.info("Finishing");
        container.close();
    }

    public static void main(final String... args) {
        logger.info("-< Booklet >-");
        launch(Booklet.class, args);
    }
}
