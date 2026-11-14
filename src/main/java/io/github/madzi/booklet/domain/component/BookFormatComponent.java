package io.github.madzi.booklet.domain.component;

import io.github.madzi.booklet.domain.BookFormat;
import io.github.madzi.booklet.domain.ecs.Component;

public record BookFormatComponent(BookFormat format) implements Component {

}
