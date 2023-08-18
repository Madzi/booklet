package madzi.booklet.cdi.view;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import madzi.booklet.cdi.lang.MessageService;
import madzi.booklet.cdi.view.annotation.AboutFxmlView;
import madzi.booklet.cdi.view.annotation.MainFxmlView;
import madzi.booklet.cdi.view.event.ViewEvent;
import madzi.booklet.lang.Message;


@ApplicationScoped
public class FxmlViewFactory {

    @Inject
    private Logger logger;
    @Inject
    private Instance<Object> instance;
    @Inject
    private MessageService messageService;

    public void mainView(final @Observes @MainFxmlView ViewEvent<?> viewEvent) {
        logger.info("Main View");
        final var stage = viewEvent.stage();
        stage.setScene(new Scene(loadView("./view/main.fxml")));
        stage.setTitle(messageService.message(Message.APP_VIEW_MAIN));
        stage.show();
    }

    public void aboutView(final @Observes @AboutFxmlView ViewEvent<?> viewEvent) {
        logger.info("About View");
        final var stage = viewEvent.stage();
        stage.setScene(new Scene(loadView("./view/about.fxml")));
        stage.setTitle(messageService.message(Message.APP_VIEW_ABOUT));
        stage.showAndWait();
    }

    private Parent loadView(final String path) {
        final var fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(param -> instance.select(param).get());
        fxmlLoader.setResources(messageService.resources());
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(path)) { 
            return fxmlLoader.load(fxmlStream);
        } catch (final IOException ioException) {
            logger.error("Unable to load view: {}", path, ioException);
            throw new IllegalStateException("Unable to load view");
        }
    }
}
