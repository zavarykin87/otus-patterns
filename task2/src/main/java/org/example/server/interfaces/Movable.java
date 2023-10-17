package org.example.server.interfaces;

import org.example.server.models.Position;

public interface Movable {
    Position getPosition();
    Position getVelocity();
    void setPosition(Position position);
}
