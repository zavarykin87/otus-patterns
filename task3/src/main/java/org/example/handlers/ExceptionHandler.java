package org.example.handlers;

import org.example.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler {

    public static Map<String, Map<String, Handler>> HANDLERS = new HashMap<>();

    public static void handle(Command command, Exception exception) {
        String commandType = command.getClass().getSimpleName();
        String exceptionType = exception.getClass().getSimpleName();

        HANDLERS.get(commandType).get(exceptionType).work(command, exception);
    }

}
