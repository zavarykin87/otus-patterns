package org.example.handlers;

import org.example.commands.FirstCommand;
import org.example.exceptions.FirstException;
import org.junit.jupiter.api.Test;

import static org.example.App.QUEUE_COMMANDS;
import static org.junit.jupiter.api.Assertions.*;

class LogHandlerTest {

    private final LogHandler logHandler = new LogHandler();

    @Test
    public void testWork() throws InterruptedException {
        QUEUE_COMMANDS.clear();
        logHandler.work(new FirstCommand(), new FirstException("hello"));
        assertEquals(1, QUEUE_COMMANDS.size());
        assertEquals("LogCommand", QUEUE_COMMANDS.take().getClass().getSimpleName());
    }



}