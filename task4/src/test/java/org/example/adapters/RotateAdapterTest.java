package org.example.adapters;

import org.example.exceptions.GetPropertyException;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RotateAdapterTest {

    @Test
    void getDirection() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("direction", 1);
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        assertEquals(1, adapter.getDirection());
    }

    @Test
    void getDirectionException() {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        Exception exception = assertThrows(GetPropertyException.class, adapter::getDirection);

        assertEquals("Property not found: direction", exception.getMessage());
    }

    @Test
    void getAngularVelocity() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("velocityAngular", 1);
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        assertEquals(1, adapter.getAngularVelocity());
    }

    @Test
    void getAngularVelocityException() {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        Exception exception = assertThrows(GetPropertyException.class, adapter::getAngularVelocity);

        assertEquals("Property not found: velocityAngular", exception.getMessage());
    }

    @Test
    void getDirectionsNumber() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("directionsNumber", 4);
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        assertEquals(4, adapter.getDirectionsNumber());
    }

    @Test
    void getDirectionsNumberException() {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        Exception exception = assertThrows(GetPropertyException.class, adapter::getDirectionsNumber);

        assertEquals("Property not found: directionsNumber", exception.getMessage());
    }

    @Test
    void setDirection() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        RotateAdapter adapter = new RotateAdapter(object);

        adapter.setDirection(2);

        assertEquals(2, adapter.getDirection());
    }
}