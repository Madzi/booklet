package io.github.madzi.booklet.domain.ecs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record World(Map<EntityId, Entity> entities) {

    public World() {
        this(new HashMap<>());
    }

    public Collection<Entity> findAll() {
        return entities.values();
    }

    public <C extends Component> Collection<Entity> findBy(final Class<C> clazz) {
        return findAll().stream().filter(entity -> entity.has(clazz)).toList();
    }

    public Entity register(final Entity entity) {
        entities.put(entity.id(), entity);
        return entity;
    }

    public Collection<Entity> registerAll(final Collection<Entity> entities) {
        if (null != entities && !entities.isEmpty()) {
            entities.forEach(this::register);
        }
        return entities;
    }

    public <C extends Component> Entity createEntity(final C... components) {
        final var builder = Entity.builder();
        if (null != components && components.length > 0) {
            for (C component : components) {
                builder.component(component);
            }
        }
        return register(builder.build());
    }

    public boolean has(final EntityId id) {
        return entities.containsKey(id);
    }

    public Optional<Entity> get(final EntityId id) {
        return Optional.ofNullable(entities.get(id));
    }

    public void remove(final EntityId id) {
        entities.remove(id);
    }

    public void clear() {
        entities.clear();
    }
}
