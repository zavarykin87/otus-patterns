package org.example.commands;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RepeatCommandTest {

    private final LogCommand logCommand = new LogCommand(new Exception("hello"));
    private final RepeatCommand repeatCommand = new RepeatCommand(logCommand);

    @Test
    public void testExecute() throws Exception {
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream1));

        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream2);
        printStream.println("hello");

        repeatCommand.execute();

        assertEquals(stream2.toString(), stream1.toString());

    }

}