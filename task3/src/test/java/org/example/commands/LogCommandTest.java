package org.example.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LogCommandTest {

    private final ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
    private final ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
    private final LogCommand logCommand = new LogCommand(new Exception("hello"));

    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(stream1));
    }


    @Test
    public void testExecute() {

        PrintStream expectedPrint = new PrintStream(stream2);
        expectedPrint.println("hello");

        logCommand.execute();

        assertEquals(stream2.toString(), stream1.toString());
    }

}