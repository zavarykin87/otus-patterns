package org.example.commands;

import org.example.adapters.BurnFuelAdapter;
import org.example.exceptions.GetPropertyException;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BurnFuelCommandTest {

    @Test
    void execute() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("fuel", 100);
        props.put("velocityBurnFuel", 1);
        UnitObject object = new SpaceShip(props);

        BurnFuelCommand command = new BurnFuelCommand(new BurnFuelAdapter(object));

        command.execute();

        assertEquals(99, object.getProperty("fuel").get());
    }
}