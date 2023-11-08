package org.example.models;



import java.util.Optional;

public interface UnitObject {
    Optional<Object> getProperty(String key);

    void setProperty(String key, Object value);
}
