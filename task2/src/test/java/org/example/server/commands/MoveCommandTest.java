package org.example.server.commands;


import org.example.server.actions.MoveAdapter;
import org.example.server.models.Position;
import org.example.server.models.SpaceShip;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    // Для объекта, находящегося в точке (12, 5) и движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)
    @Test
    public void checkMove() {
        SpaceShip spaceShip = new SpaceShip(new HashMap<>());
        spaceShip.setProperty("Position", new Position(12,5));
        spaceShip.setProperty("Velocity", new Position(-7,3));
        MoveCommand moveCommand = new MoveCommand(new MoveAdapter(spaceShip));

        moveCommand.execute();

        assertEquals(new Position(5,8), spaceShip.getProperty("Position"));
    }

}