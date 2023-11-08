package org.example.commands;

import org.example.adapters.RotateAdapter;
import org.example.exceptions.GetPropertyException;
import org.example.models.Coordinate;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RotateCommandTest {

    @Test
    void execute() throws GetPropertyException {
        Map<String, Object> props = new HashMap<>();
        props.put("position", new Coordinate(0,0));
        props.put("direction", 0);
        props.put("directionsNumber", 4);
        props.put("velocityMove", 1);
        props.put("velocityAngular", 1);

        UnitObject unit = new SpaceShip(props);

        RotateCommand command = new RotateCommand(new RotateAdapter(unit));
        command.execute();

        assertEquals(1, unit.getProperty("direction").get());

    }
}