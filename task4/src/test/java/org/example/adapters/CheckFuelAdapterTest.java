package org.example.adapters;

import org.example.actions.CheckFuel;
import org.example.exceptions.CheckFuelException;
import org.example.exceptions.GetPropertyException;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CheckFuelAdapterTest {

    @Test
    void checkFuelTest() {
        Map<String, Object> prop = new HashMap<>();
        prop.put("fuel", 100);
        prop.put("velocityBurnFuel", 1);
        UnitObject unitObject = new SpaceShip(prop);
        CheckFuel check = new CheckFuelAdapter(unitObject);
        assertDoesNotThrow(check::checkFuel);
    }

    @Test
    void checkFuelExceptionTest() {
        Map<String, Object> prop = new HashMap<>();
        prop.put("fuel", 100);
        prop.put("velocityBurnFuel", 101);
        UnitObject unitObject = new SpaceShip(prop);
        CheckFuel check = new CheckFuelAdapter(unitObject);
        assertThrows(CheckFuelException.class, check::checkFuel);
    }

    @Test
    void getFuelException() {
        Map<String, Object> prop = new HashMap<>();
        UnitObject unitObject = new SpaceShip(prop);
        CheckFuel check = new CheckFuelAdapter(unitObject);
        Exception exception = assertThrows(GetPropertyException.class, check::checkFuel);
        assertEquals("Property not found: fuel", exception.getMessage());
    }

    @Test
    void getVelocityBurnFuelException() {
        Map<String, Object> prop = new HashMap<>();
        prop.put("fuel", 100);
        UnitObject unitObject = new SpaceShip(prop);
        CheckFuel check = new CheckFuelAdapter(unitObject);
        Exception exception = assertThrows(GetPropertyException.class, check::checkFuel);
        assertEquals("Property not found: velocityBurnFuel", exception.getMessage());
    }

}