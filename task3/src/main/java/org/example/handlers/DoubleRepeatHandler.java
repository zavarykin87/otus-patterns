package org.example.handlers;

import org.example.commands.Command;
import org.example.commands.DoubleRepeatCommand;

import static org.example.App.QUEUE_COMMANDS;

public class DoubleRepeatHandler implements Handler {

    @Override
    public void work(Command command, Exception exception) {
        QUEUE_COMMANDS.add(new DoubleRepeatCommand(command));
    }
}
