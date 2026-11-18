package io.github.madzi.booklet.i18n;

public enum Text implements I18NService.Key {
    ERROR_FXML_LOAD("fxml.load.error"),
	APP_TITLE("application.title");

	private final String key;

	Text(final String key) {
	    this.key = key;
	}

	public String key() {
	    return key;
	}
}
