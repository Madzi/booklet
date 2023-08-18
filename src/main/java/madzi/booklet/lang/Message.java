package madzi.booklet.lang;

import madzi.booklet.cdi.lang.MessageService.Key;

public enum Message implements Key {
    APP_VIEW_MAIN("app.view.main"),
    APP_VIEW_ABOUT("app.view.about");

    Message(final String key) {
        this.key = key;
    }

    private final String key;

    @Override
    public String key() {
        return key;
    }
}
