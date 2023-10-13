package org.example.server.actions;

import org.example.server.models.Position;
import org.example.server.models.SpaceShip;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MoveAdapterTest {

    // Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке
    @Test
    public void checkExceptionWhenNotPosition() {
        SpaceShip spaceShip = new SpaceShip(new HashMap<>());
        MoveAdapter moveAdapter = new MoveAdapter(spaceShip);

        Exception exception = assertThrows(IllegalArgumentException.class, moveAdapter::getPosition);

        assertEquals("property Position not found", exception.getMessage());
    }

    // Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке
    @Test
    public void checkExceptionWhenNotVelocity() {
        SpaceShip spaceShip = new SpaceShip(new HashMap<>());
        MoveAdapter moveAdapter = new MoveAdapter(spaceShip);

        Exception exception = assertThrows(IllegalArgumentException.class, moveAdapter::getVelocity);

        assertEquals("property Velocity not found", exception.getMessage());
    }

    // Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке 1 балл
    @Test
    public void checkExceptionWhenNotSetPosition() {
        SpaceShip spaceShip = new SpaceShip(new HashMap<>());
        MoveAdapter moveAdapter = new MoveAdapter(spaceShip);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> moveAdapter.setPosition(new Position(1,1)));

        assertEquals("property Position not found", exception.getMessage());
    }

}