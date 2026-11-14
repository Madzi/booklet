package io.github.madzi.booklet.app;

import org.slf4j.bridge.SLF4JBridgeHandler;

import io.github.madzi.booklet.view.event.MainStageCdiEvent;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookletApp extends Application {

    private SeContainer container;

    @Override
    public void init() throws Exception {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        container = SeContainerInitializer.newInstance().initialize();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        container.getBeanManager().getEvent().fire(new MainStageCdiEvent(stage));
    }

    @Override
    public void stop() throws Exception {
        if (null != container) {
            container.close();
        }
    }
}
