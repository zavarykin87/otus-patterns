package org.example.commands;

import java.util.List;

// 3. Реализовать простейшую макрокоманду и тесты к ней.
public class MacroCommand implements Command {

    private final List<Command> commandList;

    public MacroCommand(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() throws Exception {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
