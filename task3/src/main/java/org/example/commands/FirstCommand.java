package org.example.commands;

import org.example.exceptions.FirstException;

public class FirstCommand implements Command {

    @Override
    public void execute() throws FirstException {
        throw new FirstException("this is FirstException from FirstCommand class");
    }
}
