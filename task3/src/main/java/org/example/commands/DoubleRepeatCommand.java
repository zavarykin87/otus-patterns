package org.example.commands;

public class DoubleRepeatCommand implements Command {

    private final Command command; // команда выбросившая исключение

    public DoubleRepeatCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        new RepeatCommand(command).execute();
    }
}
