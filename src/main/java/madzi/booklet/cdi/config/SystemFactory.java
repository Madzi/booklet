package madzi.booklet.cdi.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SystemFactory {

    /** OS folder valid name for application */
    private static final String APP_NAME = "fx-template";

    private final Path userHome;

    public SystemFactory() {
        this.userHome = Paths.get(System.getProperty("user.home"));
    }

    public String appName() {
        return APP_NAME;
    }

    public Path userHome() {
        return userHome;
    }

    public Path appDir() {
        final var appDir = userHome().resolve("." + APP_NAME);
        if (!appDir.toFile().exists()) {
            try {
                Files.createDirectory(appDir);
            } catch (final IOException ioException) {
                throw new IllegalStateException("Unable to create application folder: " + appDir);
            }
        }
        return appDir;
    }

    public Path appConfig() {
        final var appConfig = appDir().resolve("application.conf");
        if (!appConfig.toFile().exists()) {
            try {
                Files.createFile(appConfig);
            } catch (final IOException ioException) {
                throw new IllegalStateException("Unable to create config file: " + appConfig);
            }
        }
        return appConfig;
    }
}
