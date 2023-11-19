package org.example.adapters;

import org.example.exceptions.GetPropertyException;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class BurnFuelAdapterTest {

    @Test
    void testBurnFuel() throws GetPropertyException {
        Map<String, Object> prop = new HashMap<>();
        prop.put("fuel", 100);
        prop.put("velocityBurnFuel", 1);
        UnitObject unitObject = new SpaceShip(prop);

        BurnFuelAdapter burnFuelAdapter = new BurnFuelAdapter(unitObject);
        burnFuelAdapter.burn();

        assertEquals(99, unitObject.getProperty("fuel").get());
    }

    @Test
    void getFuelException() {
        Map<String, Object> prop = new HashMap<>();
        UnitObject unitObject = new SpaceShip(prop);

        BurnFuelAdapter burnFuelAdapter = new BurnFuelAdapter(unitObject);
        Exception exception = assertThrows(GetPropertyException.class, burnFuelAdapter::burn);
        assertEquals("Property not found: fuel", exception.getMessage());
    }

    @Test
    void getVelocityBurnFuelException() {
        Map<String, Object> prop = new HashMap<>();
        prop.put("fuel", 100);
        UnitObject unitObject = new SpaceShip(prop);

        BurnFuelAdapter burnFuelAdapter = new BurnFuelAdapter(unitObject);
        Exception exception = assertThrows(GetPropertyException.class, burnFuelAdapter::burn);
        assertEquals("Property not found: velocityBurnFuel", exception.getMessage());
    }

}