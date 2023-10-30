package org.example.commands;


// 4. Реализовать Команду, которая записывает информацию о выброшенном исключении в лог.
public class LogCommand implements Command {
    private final Exception exception;

    public LogCommand(Exception exception) {
        this.exception = exception;
    }

    @Override
    public void execute() {
        System.out.println(exception.getMessage());
    }
}
