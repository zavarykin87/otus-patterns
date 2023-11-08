package org.example.commands;

import org.example.actions.Movable;
import org.example.exceptions.GetPropertyException;
import org.example.models.Coordinate;

public class MoveCommand implements Command {

    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() throws GetPropertyException {
        Coordinate current = movable.getCurrentCoordinate();
        Coordinate velocity = movable.getVelocity();
        Coordinate newCoordinate = Coordinate.sum(current, velocity);
        movable.setNewCoordinate(newCoordinate);
    }
}
