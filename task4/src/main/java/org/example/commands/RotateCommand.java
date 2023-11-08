package org.example.commands;

import org.example.actions.Rotable;
import org.example.exceptions.GetPropertyException;

// 6. Реализовать команду поворота, которая еще и меняет вектор мгновенной скорости, если есть.
public class RotateCommand implements Command {

    private final Rotable rotable;

    public RotateCommand(Rotable rotable) {
        this.rotable = rotable;
    }

    @Override
    public void execute() throws GetPropertyException {
        int d = rotable.getDirection();
        int v = rotable.getAngularVelocity();
        int n = rotable.getDirectionsNumber();
        int newDirection = (d + v) % n;
        rotable.setDirection(newDirection);
    }
}
