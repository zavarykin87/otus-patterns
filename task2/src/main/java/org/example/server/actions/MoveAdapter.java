package org.example.server.actions;

import org.example.server.interfaces.Movable;
import org.example.server.interfaces.Uobject;
import org.example.server.models.Position;

public class MoveAdapter implements Movable {

    private final Uobject uobject;

    public MoveAdapter(Uobject uobject) {
        this.uobject = uobject;
    }


    @Override
    public Position getPosition() {
        Position position = (Position) uobject.getProperty("Position");
        if (position != null) {
            return position;
        } else {
            throw new IllegalArgumentException("property Position not found");
        }
    }

    @Override
    public Position getVelocity() {
        Position velocity = (Position) uobject.getProperty("Velocity");
        if (velocity != null) {
            return velocity;
        } else {
            throw new IllegalArgumentException("property Velocity not found");
        }
    }

    @Override
    public void setPosition(Position position) {
        Position value = (Position) uobject.getProperty("Position");
        if (value != null) {
            uobject.setProperty("Position", position);
        } else {
            throw new IllegalArgumentException("property Position not found");
        }
    }
}
