package org.example.adapters;

import org.example.actions.Movable;
import org.example.exceptions.GetPropertyException;
import org.example.models.Coordinate;
import org.example.models.UnitObject;

public class MoveAdapter implements Movable {

    private final UnitObject unitObject;

    public MoveAdapter(UnitObject unitObject) {
        this.unitObject = unitObject;
    }

    @Override
    public Coordinate getCurrentCoordinate() throws GetPropertyException {
        return (Coordinate) unitObject.getProperty("position")
                .orElseThrow(() -> new GetPropertyException("position"));
    }

    @Override
    public Coordinate getVelocity() throws GetPropertyException {
        int d = (int) unitObject.getProperty("direction")
                .orElseThrow(() -> new GetPropertyException("direction"));

        int n = (int) unitObject.getProperty("directionsNumber")
                .orElseThrow(() -> new GetPropertyException("directionsNumber"));

        int v = (int) unitObject.getProperty("velocityMove")
                .orElseThrow(() -> new GetPropertyException("velocityMove"));

        return new Coordinate(
                (int) (v * Math.cos((double) (360 / n) * d)),
                (int) (v * Math.sin((double) (360 / n) * d))
        );
    }

    @Override
    public void setNewCoordinate(Coordinate coordinate) {
        unitObject.setProperty("position", coordinate);
    }
}
