package org.example.commands;

import org.example.adapters.BurnFuelAdapter;
import org.example.adapters.CheckFuelAdapter;
import org.example.adapters.MoveAdapter;
import org.example.models.Coordinate;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MacroCommandTest {

    @Test
    void execute() throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("fuel", 100);
        props.put("velocityBurnFuel", 1);
        props.put("position", new Coordinate(0,0));
        props.put("direction", 0);
        props.put("directionsNumber", 4);
        props.put("velocityMove", 1);

        UnitObject unit = new SpaceShip(props);

        Command macroCommand = new MacroCommand(List.of(
                new CheckFuelCommand(new CheckFuelAdapter(unit)),
                new MoveCommand(new MoveAdapter(unit)),
                new BurnFuelCommand(new BurnFuelAdapter(unit))
        ));

        macroCommand.execute();

        assertAll(
                () -> assertEquals(99, unit.getProperty("fuel").get()), // топливо уменьшилось
                () -> assertEquals(1, unit.getProperty("velocityBurnFuel").get()),
                () -> assertEquals(new Coordinate(1,0), unit.getProperty("position").get()), // координаты изменились
                () -> assertEquals(0, unit.getProperty("direction").get()),
                () -> assertEquals(4, unit.getProperty("directionsNumber").get()),
                () -> assertEquals(1, unit.getProperty("velocityMove").get())

        );
    }
}