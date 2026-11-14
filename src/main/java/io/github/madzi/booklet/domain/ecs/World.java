package io.github.madzi.booklet.domain.ecs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Управление сущностями.
 */
public record World(Map<EntityId, Entity> entities) {

    public World() {
        this(new HashMap<>());
    }

    /**
     * Возвращает все сущности.
     */
    public Collection<Entity> findAll() {
        return entities.values();
    }

    /**
     * Возващает все сущности у которых есть указанный компонент.
     */
    public <C extends Component> Collection<Entity> findBy(final Class<C> clazz) {
        return findAll().stream().filter(entity -> entity.has(clazz)).toList();
    }

    /**
     * Регистрирует сущность.
     * Нужно для сущностей созданных не с помощью данного класса
     */
    public Entity register(final Entity entity) {
        entities.put(entity.id(), entity);
        return entity;
    }

    /**
     * Регистрирует список сущностей.
     */
    public Collection<Entity> registerAll(final Collection<Entity> entities) {
        if (null != entities && !entities.isEmpty()) {
            entities.forEach(this::register);
        }
        return entities;
    }

    /**
     * Создаёт сущность с указанными компонентами.
     */
    public <C extends Component> Entity createEntity(final C... components) {
        final var builder = Entity.builder();
        if (null != components && components.length > 0) {
            for (C component : components) {
                builder.component(component);
            }
        }
        return register(builder.build());
    }

    /**
     * Проверяет что сущность с переданным id зарегистрирована.
     */
    public boolean has(final EntityId id) {
        return entities.containsKey(id);
    }

    /**
     * Возвращает контейнер содержащий сущность с указанным id, или пустой.
     */
    public Optional<Entity> get(final EntityId id) {
        return Optional.ofNullable(entities.get(id));
    }

    /**
     * Удаляет из реестра сущность с указанным id.
     */
    public void remove(final EntityId id) {
        entities.remove(id);
    }

    /**
     * Очищает реестр от всех сущностей.
     */
    public void clear() {
        entities.clear();
    }
}
