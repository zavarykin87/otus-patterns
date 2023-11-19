package org.example.actions;

import org.example.exceptions.GetPropertyException;
import org.example.models.Coordinate;

public interface Movable {
    Coordinate getCurrentCoordinate() throws GetPropertyException;
    Coordinate getVelocity() throws GetPropertyException;
    void setNewCoordinate(Coordinate coordinate);

}
