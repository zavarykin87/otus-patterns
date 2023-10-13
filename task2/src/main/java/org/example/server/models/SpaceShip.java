package org.example.server.models;


import org.example.server.interfaces.Uobject;

import java.util.Map;

public class SpaceShip implements Uobject {

    private final Map<String, Object> properties;

    public SpaceShip(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }
}
