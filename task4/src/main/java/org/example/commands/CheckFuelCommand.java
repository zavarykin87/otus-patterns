package org.example.commands;

import org.example.actions.CheckFuel;
import org.example.exceptions.CheckFuelException;
import org.example.exceptions.GetPropertyException;

// 1. Реализовать класс CheckFuelComamnd и тесты к нему.
public class CheckFuelCommand implements Command {

    private final CheckFuel checkFuel;

    public CheckFuelCommand(CheckFuel checkFuel) {
        this.checkFuel = checkFuel;
    }

    @Override
    public void execute() throws GetPropertyException, CheckFuelException {
        checkFuel.checkFuel();
    }
}
