package org.example;

import org.example.adapters.BurnFuelAdapter;
import org.example.adapters.CheckFuelAdapter;
import org.example.adapters.MoveAdapter;
import org.example.commands.*;
import org.example.models.Coordinate;
import org.example.models.SpaceShip;
import org.example.models.UnitObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;


public class App {

    private static ArrayBlockingQueue<Command> commands = new ArrayBlockingQueue<>(1024);

    public static void main( String[] args ) throws InterruptedException {
        Map<String, Object> props = new HashMap<>();
        props.put("fuel", 100);
        props.put("velocityBurnFuel", 1);
        props.put("position", new Coordinate(0,0));
        props.put("direction", 0);
        props.put("derectionsNumber", 4);
        props.put("velocityMove", 1);

        UnitObject unit = new SpaceShip(props);

        // 4. Реализовать команду движения по прямой с расходом топлива, используя команды с предыдущих шагов.
        Command macro = new MacroCommand(List.of(
                new CheckFuelCommand(new CheckFuelAdapter(unit)),
                new MoveCommand(new MoveAdapter(unit)),
                new BurnFuelCommand(new BurnFuelAdapter(unit))
        ));

        commands.put(macro);
        while (true) {
            Command command = commands.take();
            try {
                command.execute();
            } catch (Exception e) {
                // exceptionHandler...
            }
        }
    }
}
