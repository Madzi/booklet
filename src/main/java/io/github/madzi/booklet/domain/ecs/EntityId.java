package io.github.madzi.booklet.domain.ecs;

import java.util.UUID;

public record EntityId(UUID id) {

    public EntityId() {
        this(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
