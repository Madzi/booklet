package io.github.madzi.booklet.i18n.internal;

import java.util.ResourceBundle;

import io.github.madzi.booklet.i18n.I18NService;

public record BaseI18NService(ResourceBundle bundle) implements I18NService {

    @Override
    public String text(final Key key, final Object... args) {
        return bundle.getString(key.key()).formatted(args);
    }
}
