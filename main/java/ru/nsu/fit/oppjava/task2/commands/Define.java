package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.DefineException;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.CalculatorException;

public class Define implements Command {
    ExecutionContext context;
    String[] args;

    public Define(ExecutionContext context, String[] arguments){
        this.context = context;
        this.args = arguments;
    }

    @Override
    public String getName() {
        return "DEFINE";
    }

    @Override
    public void execute() throws CalculatorException {
        if (args.length != 3) {
            throw new DefineException(args);
        }
        if (context.defineContainsKey(args[1])) {
            context.defineReplace(args[1], Double.parseDouble(args[2]));
        } else {
            try {
                context.definePut(args[1], Double.valueOf(args[2]));
            } catch (NumberFormatException nfe) {
                throw new DefineException(args);
            }
        }
    }
}
