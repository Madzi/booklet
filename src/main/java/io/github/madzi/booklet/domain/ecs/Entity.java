package io.github.madzi.booklet.domain.ecs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public record Entity(EntityId id, Map<Class<? extends Component>, Component> components) {

    public Entity() {
        this(new EntityId(), new HashMap<>());
    }

    public Entity(final EntityId id) {
        this(id, new HashMap<>());
    }

    private Entity(final Builder builder) {
        this(builder.id, builder.components);
    }

    public <C extends Component> boolean has(final Class<C> clazz) {
        return components.containsKey(clazz);
    }

    public <C extends Component> Optional<C> get(final Class<C> clazz) {
        return Optional.ofNullable(clazz.cast(components.get(clazz)));
    }

    public <C extends Component> C add(final C component) {
        components.put(component.getClass(), component);
        return component;
    }

    public <C extends Component> C remove(final Class<C> clazz) {
        return clazz.cast(components.remove(clazz));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(final EntityId id) {
        return new Builder(id);
    }

    public static class Builder {
        private EntityId id;
        private Map<Class<? extends Component>, Component> components = new HashMap<>();

        private Builder() {
            this(new EntityId());
        }
        private Builder(final EntityId id) {
            this.id = id;
        }

        public Builder id(final EntityId id) {
            this.id = id;
            return this;
        }
        public Builder component(final Component component) {
            this.components.put(component.getClass(), component);
            return this;
        }
        public Entity build() {
            return new Entity(this);
        }
    }
}
