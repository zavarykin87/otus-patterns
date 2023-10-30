package org.example.handlers;

import org.example.commands.Command;
import org.example.commands.RepeatCommand;

import static org.example.App.QUEUE_COMMANDS;

// 7. Реализовать обработчик исключения, который ставит в очередь Команду - повторитель команды, выбросившей исключение.
public class RepeatHandler implements Handler {

    @Override
    public void work(Command command, Exception exception) {
        QUEUE_COMMANDS.add(new RepeatCommand(command));
    }
}
