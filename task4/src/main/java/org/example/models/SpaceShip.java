package org.example.models;

import java.util.Map;
import java.util.Optional;

public class SpaceShip implements UnitObject {

    private final Map<String, Object> properties;

    public SpaceShip(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public Optional<Object> getProperty(String key) {
        return Optional.ofNullable(properties.get(key));
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

}
