package org.example.commands;

import org.example.exceptions.SecondException;

public class SecondCommand implements Command {

    @Override
    public void execute() throws Exception {
        throw new SecondException("this is SecondException from SecondCommand class");
    }
}
