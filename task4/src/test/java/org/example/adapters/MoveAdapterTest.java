package org.example.adapters;

import org.example.exceptions.GetPropertyException;
import org.example.models.Coordinate;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MoveAdapterTest {

    @Test
    void getCurrentCoordinate() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("position", new Coordinate(1,1));
        UnitObject object = new SpaceShip(props);
        MoveAdapter moveAdapter = new MoveAdapter(object);

        Coordinate actual = moveAdapter.getCurrentCoordinate();

        assertEquals(new Coordinate(1,1), actual);
    }

    @Test
    void getCurrentCoordinateException() {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        MoveAdapter moveAdapter = new MoveAdapter(object);

        Exception exception = assertThrows(GetPropertyException.class, moveAdapter::getCurrentCoordinate);
        assertEquals("Property not found: position", exception.getMessage());
    }

    @Test
    void getVelocity() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("direction", 0);
        props.put("directionsNumber", 4);
        props.put("velocityMove", 1);
        UnitObject object = new SpaceShip(props);
        MoveAdapter moveAdapter = new MoveAdapter(object);

        Coordinate actual = moveAdapter.getVelocity();

        assertEquals(new Coordinate(1,0), actual);
    }

    @Test
    void setNewCoordinate() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        UnitObject object = new SpaceShip(props);
        MoveAdapter moveAdapter = new MoveAdapter(object);

        Coordinate expected = new Coordinate(1,1);
        moveAdapter.setNewCoordinate(expected);

        assertEquals(expected, moveAdapter.getCurrentCoordinate());

    }
}