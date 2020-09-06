package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.CalculatorException;
import ru.nsu.fit.oppjava.task2.core.PushException;

public class Push implements Command {
    ExecutionContext context;
    String[] args;

    public Push(ExecutionContext context, String[] arguments) {
        this.context = context;
        args = arguments;
    }

    @Override
    public String getName() {
        return "PUSH";
    }

    @Override
    public void execute() throws CalculatorException {
        if (args.length != 2) {
            throw new PushException(args);
        }
        if (context.defineContainsKey(args[1])) {
            context.stackPush(context.defineGet(args[1]));
        } else {
            try {
                context.stackPush(Double.parseDouble(args[1]));
            } catch (NumberFormatException nfe) {
                throw new PushException(args);
            }
        }
    }
}
