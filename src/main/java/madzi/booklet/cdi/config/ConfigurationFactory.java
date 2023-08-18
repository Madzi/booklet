package madzi.booklet.cdi.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ConfigurationFactory {

    @Produces
    public Config config() {
        return ConfigFactory.load();
    }
}
