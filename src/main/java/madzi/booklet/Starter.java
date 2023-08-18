package madzi.booklet;

import javafx.application.Application;
import madzi.booklet.app.BookletApplication;
import madzi.booklet.cdi.config.SystemFactory;

/**
 * Entrypoint for application
 */
public class Starter {

    public static void main(final String... args) {
        final var sysFactory = new SystemFactory();
        System.setProperty("app.name", sysFactory.appName());
        System.setProperty("config.file", sysFactory.appConfig().toString());
        System.setProperty("org.jboss.logging.provider", "slf4j");
        Application.launch(BookletApplication.class, args);
    }
}
