package org.example.commands;

import org.example.actions.BurnFuel;
import org.example.exceptions.GetPropertyException;

// 2. Реализовать класс BurnFuelCommand и тесты к нему.
public class BurnFuelCommand implements Command {

    private final BurnFuel burnFuel;

    public BurnFuelCommand(BurnFuel burnFuel) {
        this.burnFuel = burnFuel;
    }

    @Override
    public void execute() throws GetPropertyException {
        burnFuel.burn();
    }
}
