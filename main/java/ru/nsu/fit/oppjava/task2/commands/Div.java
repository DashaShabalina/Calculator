package ru.nsu.fit.oppjava.task2.commands;

import ru.nsu.fit.oppjava.task2.core.*;

import java.util.EmptyStackException;

public class Div implements Command {
    ExecutionContext context;

    public Div(ExecutionContext context, String[] arguments){
        this.context = context;
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public void execute() throws CalculatorException {
        try {
            double val2 = context.stackPop();
            double val1 = context.stackPop();
            if (val2 == 0.0) {
                throw new DivByZeroException();
            }
            context.stackPush(val1 / val2);
        } catch (EmptyStackException es) {
            throw new MyEmptyStackException();
        }
    }
}
