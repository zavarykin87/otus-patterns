package org.example.handlers;

import org.example.commands.Command;

public interface Handler {
    void work(Command command, Exception exception);
}
