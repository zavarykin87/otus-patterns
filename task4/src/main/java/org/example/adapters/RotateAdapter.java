package org.example.adapters;

import org.example.actions.Rotable;
import org.example.exceptions.GetPropertyException;
import org.example.models.UnitObject;

public class RotateAdapter implements Rotable {

    private final UnitObject unitObject;

    public RotateAdapter(UnitObject unitObject) {
        this.unitObject = unitObject;
    }

    @Override
    public int getDirection() throws GetPropertyException {
        return (int) unitObject.getProperty("direction")
                .orElseThrow(() -> new GetPropertyException("direction"));
    }

    @Override
    public int getAngularVelocity() throws GetPropertyException {
        return (int) unitObject.getProperty("velocityAngular")
                .orElseThrow(() -> new GetPropertyException("velocityAngular"));
    }

    @Override
    public int getDirectionsNumber() throws GetPropertyException {
        return (int) unitObject.getProperty("directionsNumber")
                .orElseThrow(() -> new GetPropertyException("directionsNumber"));
    }

    @Override
    public void setDirection(int value) {
        unitObject.setProperty("direction", value);
    }
}
