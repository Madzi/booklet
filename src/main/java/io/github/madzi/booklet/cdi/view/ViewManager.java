package io.github.madzi.booklet.cdi.view;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;

import io.github.madzi.booklet.i18n.I18NService;
import io.github.madzi.booklet.i18n.Text;
import io.github.madzi.booklet.view.event.MainStageCdiEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@ApplicationScoped
public class ViewManager {

    private final Logger logger;
    private final Instance<Object> instance;
    private final I18NService i18nService;

    @Inject
    public ViewManager(final Logger logger, final Instance<Object> instance, final I18NService i18nService) {
        this.logger = logger;
        this.instance = instance;
        this.i18nService = i18nService;
    }

    public void mainView(final @Observes MainStageCdiEvent event) {
        logger.info("Start main view");
        final var stage = event.stage();
        stage.setScene(new Scene(loadView("main")));
        stage.setTitle(i18nService.text(Text.APP_TITLE, "1.0"));
        stage.show();
    }

    private Parent loadView(final String path) {
        final var fullPath = "./view/" + path + ".fxml";
        try (final InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(fullPath)) {
            final var fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(bean -> instance.select(bean).get());
            return fxmlLoader.load(fxmlStream);
        } catch (final IOException exception) {
            throw new IllegalStateException(i18nService.text(Text.ERROR_FXML_LOAD, fullPath), exception);
        }
    }
}
