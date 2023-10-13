package org.example.server.commands;

import org.example.server.interfaces.Movable;
import org.example.server.models.Position;

public class MoveCommand {

    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    public void execute() {
        Position position = movable.getPosition();
        Position velocity = movable.getVelocity();
        movable.setPosition(Position.sum(position, velocity));
    }
}
