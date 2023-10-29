package org.example.commands;

// 6. Реализовать Команду, которая повторяет Команду, выбросившую исключение.
public class RepeatCommand implements Command {

    private final Command command; // команда выбросившая исключение

    public RepeatCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() throws Exception {
        command.execute();
    }
}
