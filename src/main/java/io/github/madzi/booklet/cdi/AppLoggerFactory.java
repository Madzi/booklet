package io.github.madzi.booklet.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class AppLoggerFactory {

    @Produces
    public Logger createLogger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getClass());
    }
}
