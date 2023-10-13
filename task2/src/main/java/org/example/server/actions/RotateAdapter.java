package org.example.server.actions;

import org.example.server.interfaces.Rotable;
import org.example.server.interfaces.Uobject;

public class RotateAdapter implements Rotable {

    private final Uobject uobject;

    public RotateAdapter(Uobject uobject) {
        this.uobject = uobject;
    }

    @Override
    public int getDirection() {
        return (int) uobject.getProperty("Direction");
    }

    @Override
    public int getAngularVelocity() {
        return (int) uobject.getProperty("AngularVelocity");
    }

    @Override
    public int getDirectionsNumber() {
        return (int) uobject.getProperty("DirectionsNumber");
    }

    @Override
    public void setDirection(int value) {
        uobject.setProperty("Direction", value);
    }
}
