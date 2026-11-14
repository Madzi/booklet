package io.github.madzi.booklet.domain.ecs;

import java.util.UUID;

/**
 * Идентификатор сущности.
 * Создан для удобства замены самого идентификатора.
 * В данный момент используется UUID, но может быть заменён на long или другой класс.
 * При этом основная масса кода использует не UUID, а EntityId.
 */
public record EntityId(UUID id) {

    public EntityId() {
        this(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
