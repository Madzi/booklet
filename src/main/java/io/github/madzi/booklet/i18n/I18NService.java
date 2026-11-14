package io.github.madzi.booklet.i18n;

/**
 * MessageService
 */
public interface I18NService {

	String text(Key key, Object... args);

	interface Key {
	    String key();
	}
}
