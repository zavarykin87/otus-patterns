package org.example.commands;

import org.example.actions.CheckFuel;
import org.example.adapters.CheckFuelAdapter;
import org.example.exceptions.CheckFuelException;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CheckFuelCommandTest {

    @Test
    void execute() {
        Map<String, Object> props = new HashMap<>();
        props.put("fuel", 100);
        props.put("velocityBurnFuel", 1);
        UnitObject object = new SpaceShip(props);

        CheckFuelCommand command = new CheckFuelCommand(new CheckFuelAdapter(object));

        assertDoesNotThrow(command::execute);
    }

    @Test
    void executeException() {
        Map<String, Object> props = new HashMap<>();
        props.put("fuel", 100);
        props.put("velocityBurnFuel", 101);
        UnitObject object = new SpaceShip(props);

        CheckFuelCommand command = new CheckFuelCommand(new CheckFuelAdapter(object));

        assertThrows(CheckFuelException.class, command::execute);
    }
}