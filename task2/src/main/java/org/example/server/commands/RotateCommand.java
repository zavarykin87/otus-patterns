package org.example.server.commands;

import org.example.server.interfaces.Rotable;

public class RotateCommand {

    private final Rotable rotable;

    public RotateCommand(Rotable rotable) {
        this.rotable = rotable;
    }

    public void execute() {
        rotable.setDirection(
                (rotable.getDirection() + rotable.getAngularVelocity()) % rotable.getDirectionsNumber()
        );
    }
}
