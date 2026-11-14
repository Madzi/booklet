package io.github.madzi.booklet.cdi.i18n;

import java.util.ResourceBundle;

import io.github.madzi.booklet.i18n.I18NService;
import io.github.madzi.booklet.i18n.internal.BaseI18NService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

/**
 * I18NFactory
 */
@ApplicationScoped
public class I18NFactory {

	@Produces
	public I18NService i18nService() {
	    final var bundle = ResourceBundle.getBundle("lang/booklet");
	    return new BaseI18NService(bundle);
	}
}
