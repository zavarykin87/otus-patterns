package org.example.actions;

import org.example.exceptions.GetPropertyException;

public interface Rotable {
    int getDirection() throws GetPropertyException;
    int getAngularVelocity() throws GetPropertyException;
    int getDirectionsNumber() throws GetPropertyException;
    void setDirection(int value);

}
