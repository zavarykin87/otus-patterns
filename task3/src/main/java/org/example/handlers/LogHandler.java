package org.example.handlers;

import org.example.commands.Command;
import org.example.commands.LogCommand;

import static org.example.App.QUEUE_COMMANDS;

// 5. Реализовать обработчик исключения, который ставит Команду, пишущую в лог в очередь Команд.
public class LogHandler implements Handler {

    @Override
    public void work(Command command, Exception exception) {
        QUEUE_COMMANDS.add(new LogCommand(exception));
    }
}
