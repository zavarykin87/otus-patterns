package org.example;

import org.example.commands.*;
import org.example.exceptions.FirstException;
import org.example.exceptions.SecondException;
import org.example.handlers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import static org.example.handlers.ExceptionHandler.HANDLERS;

public class App {

    public static final ArrayBlockingQueue<Command> QUEUE_COMMANDS = new ArrayBlockingQueue<>(16);

    static {
        QUEUE_COMMANDS.add(new FirstCommand());
        QUEUE_COMMANDS.add(new SecondCommand());

        // 8. С помощью Команд из пункта 4 и пункта 6 реализовать следующую обработку исключений:
        // при первом выбросе исключения повторить команду, при повторном выбросе исключения записать информацию в лог.
        Map<String, Handler> repeat = new HashMap<>();
        repeat.put(FirstException.class.getSimpleName(), new RepeatHandler());
        HANDLERS.put(FirstCommand.class.getSimpleName(), repeat);

        Map<String, Handler> log = new HashMap<>();
        log.put(FirstException.class.getSimpleName(), new LogHandler());
        log.put(SecondException.class.getSimpleName(), new LogHandler());
        HANDLERS.put(RepeatCommand.class.getSimpleName(), log);

        // 9. Реализовать стратегию обработки исключения - повторить два раза, потом записать в лог.
        // Указание: создать новую команду, точно такую же как в пункте 6. Тип этой команды будет показывать,
        // что Команду не удалось выполнить два раза.
        Map<String, Handler> doubleRepeat = new HashMap<>();
        doubleRepeat.put(SecondException.class.getSimpleName(), new DoubleRepeatHandler());
        HANDLERS.put(SecondCommand.class.getSimpleName(), doubleRepeat);

        Map<String, Handler> doubleRepeat2 = new HashMap<>();
        doubleRepeat2.put(SecondException.class.getSimpleName(), new RepeatHandler());
        HANDLERS.put(DoubleRepeatCommand.class.getSimpleName(), doubleRepeat2);


    }

    public static void main( String[] args ) throws InterruptedException {

        while (true) {
            Command command = QUEUE_COMMANDS.take();
            // 1.Обернуть вызов Команды в блок try-catch.
            try {
                command.execute();
                // 2.Обработчик catch должен перехватывать только самое базовое исключение.
            } catch (Exception e) {
                // 3. Есть множество различных обработчиков исключений. Выбор подходящего обработчика исключения
                // делается на основе экземпляра перехваченного исключения и команды, которая выбросила исключение.
                ExceptionHandler.handle(command, e);
            }
        }

    }
}
