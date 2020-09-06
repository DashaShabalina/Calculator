package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.Command;
import ru.nsu.fit.oppjava.task2.core.ExecutionContext;
import ru.nsu.fit.oppjava.task2.core.MyEmptyStackException;
import ru.nsu.fit.oppjava.task2.core.CalculatorException;

import java.util.EmptyStackException;

public class Mul implements Command {
    ExecutionContext context;

    public Mul(ExecutionContext context, String[] arguments) {
        this.context = context;
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public void execute() throws CalculatorException {
        try {
            double val2 = context.stackPop();
            double val1 = context.stackPop();
            context.stackPush(val1 * val2);
        } catch (EmptyStackException es) {
            throw new MyEmptyStackException();
        }
    }
}
